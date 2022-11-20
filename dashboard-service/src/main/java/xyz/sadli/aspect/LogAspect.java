package xyz.sadli.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.sadli.common.Constants;
import xyz.sadli.entity.JtLog;
import xyz.sadli.service.log.JtLogService;
import xyz.sadli.util.DateUtils;
import xyz.sadli.util.IdWorker;
import xyz.sadli.util.IpUtils;
import xyz.sadli.util.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/9/27 22:02.
 * Editored:
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    private final JtLogService jtLogService;

    public LogAspect(JtLogService jtLogService) {
        this.jtLogService = jtLogService;
    }

    /**
     * 切面织入点
     */
    @Pointcut("execution(public * xyz.sadli.controller..*.*(..))")
    public void controllerLog() {
    }

    /**
     * slf4j线程常量切面 在每个请求线程里加上traceId
     *
     * @param point
     * @return
     * @throws Throwable
     */
//    将mdc.traceId改为在过滤器中添加了
//    @Around("controllerLog()")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//        String uuid = StringUtils.UuidLowerCase();
//        MDC.put(Constants.FIELD_MDC_TRACE_ID, uuid);
//        Object proceed = point.proceed();
//        MDC.remove(Constants.FIELD_MDC_TRACE_ID);
//        return proceed;
//    }

    /**
     * 方法调用之前执行
     *
     * @param joinPoint
     */
    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Object[] args = joinPoint.getArgs();

        JtLog jtLog = new JtLog();
        jtLog.setLogId(IdWorker.nextIdStr());
        jtLog.setIp(IpUtils.getIpAddr(request));
        Date date = DateUtils.currentDateTime();
        jtLog.setLogTime(date);
        jtLog.setMethod(request.getMethod());
        jtLog.setPath(String.valueOf(request.getRequestURL()));
        jtLog.setResource(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        jtLog.setParams(Arrays.toString(args));
        String jwtToken = request.getHeader(Constants.FIELD_JWT_TOKEN);
        if (JwtUtils.verify(jwtToken)) {
            String uid = (String) JwtUtils.parseJwtToken(jwtToken).get("uid");
            jtLog.setUid(uid);
        }
        jtLog.setTraceId(MDC.get(Constants.FIELD_MDC_TRACE_ID));
        jtLogService.saveJtLog(jtLog);
        log.info("Request :from={}, time={}, method={}, path={},resource={},params={}", IpUtils.getIpAddr(request), date, request.getMethod(), request.getRequestURL(), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(), Arrays.toString(args));
    }

    /**
     * 方法调用完成时执行
     *
     * @param resp
     */
    @AfterReturning(returning = "resp", pointcut = "controllerLog()")
    public void doAfterReturning(Object resp) {
        log.info("Response :{}", resp);
    }

    /**
     * 方法抛出异常时执行，不在这里处理，交给SysExceptionHandler
     *
     * @param throwable
     */
//    @AfterThrowing(throwing = "throwable", pointcut = "controllerLog()")
//    public void doAfterThrowing(Throwable throwable) {
//        log.error("aspect throwable :{}", throwable.getMessage());
//    }
}
