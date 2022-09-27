package xyz.sadli.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import xyz.sadli.thread.utils.ThreadPoolMdcUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/9/27 22:19.
 * Editored:
 */
@Component
public class SysThreadPoolTaskExecutor extends ThreadPoolTaskExecutorMdcWrapper {

    public static final Logger log = LoggerFactory.getLogger(SysThreadPoolTaskExecutor.class);

    @Override
    public void execute(Runnable task) {
        log.debug(" *** sysThreadPoolTaskExecutor executed Runnable task");
        //执行包装后的线程任务类
        super.execute(ThreadPoolMdcUtils.wrap(task, MDC.getCopyOfContextMap()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        log.debug(" *** sysThreadPoolTaskExecutor submitted Runnable task");
        return super.submit(ThreadPoolMdcUtils.wrap(task, MDC.getCopyOfContextMap()));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        log.debug(" *** sysThreadPoolTaskExecutor submitted Callable<T> task");
        return super.submit(ThreadPoolMdcUtils.wrap(task, MDC.getCopyOfContextMap()));
    }

}
