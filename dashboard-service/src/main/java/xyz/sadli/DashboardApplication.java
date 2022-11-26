package xyz.sadli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 18:10.
 * Editored:
 */
@SpringBootApplication
@EnableCaching
public class DashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }
}
