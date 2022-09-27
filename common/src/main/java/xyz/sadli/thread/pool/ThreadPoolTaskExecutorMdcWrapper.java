package xyz.sadli.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import xyz.sadli.thread.factory.SysThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/9/27 22:19.
 * Editored:
 */
public class ThreadPoolTaskExecutorMdcWrapper extends ThreadPoolTaskExecutor {

    public static final Logger log = LoggerFactory.getLogger(ThreadPoolTaskExecutorMdcWrapper.class);

    /**
     * ThreadPoolTaskExecutor与ThreadPoolExecutor的区别：
     * ThreadPoolExecutor：JDK提供的线程池类，（java.util.concurrent.ThreadPoolExecutor）继承自java.util.concurrent.Executor
     * ThreadPoolTaskExecutor：Spring提供的线程池类（org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor），最终也是继承自java.util.concurrent.Executor
     */

    @Autowired
    private SysThreadFactory sysThreadFactory;

    /**
     * 重载initializeExecutor方法，设置线程池使用自定义ThreadFactory
     *
     * @param threadFactory
     * @param rejectedExecutionHandler
     * @return
     */
    @Override
    protected ExecutorService initializeExecutor(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        log.debug(" *** initializeExecutor");
        return super.initializeExecutor(sysThreadFactory, rejectedExecutionHandler);
    }
}
