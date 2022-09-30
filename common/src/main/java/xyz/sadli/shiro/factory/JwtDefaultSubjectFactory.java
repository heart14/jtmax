package xyz.sadli.shiro.factory;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * About:
 * Other: 默认shiro会使用defaultSubjectFactory，这个factory会创建session，但我们使用Jwt而不使用shiro管理的session，所以要自定义一个factory，禁用shiro session
 * Created: wfli on 2022/9/29 17:35.
 * Editored:
 */
public class JwtDefaultSubjectFactory extends DefaultWebSubjectFactory {

    @Override
    public Subject createSubject(SubjectContext context) {
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
