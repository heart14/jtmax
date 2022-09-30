package xyz.sadli.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.*;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.sadli.shiro.factory.JwtDefaultSubjectFactory;
import xyz.sadli.shiro.filter.JwtFilter;
import xyz.sadli.shiro.realm.JwtRealm;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/29 17:33.
 * Editored:
 */
@Configuration
public class ShiroConfig {

    @Bean
    public SubjectFactory subjectFactory() {
        return new JwtDefaultSubjectFactory();
    }

    @Bean
    public Realm realm() {
        return new JwtRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //使用自定义realm
        securityManager.setRealm(realm());
        //使用自定义subjectFactory
        securityManager.setSubjectFactory(subjectFactory());
//        这样写会报错，Session creation has been disabled for the current subject，报错原因就是禁用了session，而subject.login()方法里面有一行getSession的代码，但sessionCreate被禁用，所以抛出了异常
//        //禁用shiro自带的session管理功能，不要将session存储到任何地方，包括http session，
//        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
//        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//        sessionStorageEvaluator.setSessionStorageEnabled(false);
//        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator);

        //换用这种写法，猜想，由于自定义了SubjectFactory，所以不能直接new DefaultSubjectDAO()，而是应该使用自定义的SubjectFactory中获取的SubjectDAO，给这个DAO设置session存储开关为false
        SubjectDAO subjectDAO = securityManager.getSubjectDAO();
        if (subjectDAO instanceof DefaultSubjectDAO) {
            DefaultSubjectDAO defaultSubjectDAO = (DefaultSubjectDAO) subjectDAO;
            SessionStorageEvaluator sessionStorageEvaluator = defaultSubjectDAO.getSessionStorageEvaluator();
            if (sessionStorageEvaluator instanceof DefaultSessionStorageEvaluator) {
                DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = (DefaultSessionStorageEvaluator) sessionStorageEvaluator;
                defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
            }
        }

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());

        //认证失败时跳转页面
        //shiroFilter.setLoginUrl();
        //授权失败时跳转页面
        //shiroFilter.setUnauthorizedUrl();

        //将jwtFilter过滤器注册到shiroFilter中，实现除了Login Logout之外的请求都经过jwtFilter验证
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("anon", new AnonymousFilter());
        filterMap.put("jwt", new JwtFilter());
        filterMap.put("logout", new LogoutFilter());
        shiroFilter.setFilters(filterMap);

        //设置shiro拦截器，指定路由拦截规则
        Map<String, String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/test/login", "anon");
        filterChainMap.put("/test/logout", "logout");
        filterChainMap.put("/**", "jwt");
        shiroFilter.setFilterChainDefinitionMap(filterChainMap);

        return shiroFilter;
    }

    /**
     * 开启shiro注解配置
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }


}
