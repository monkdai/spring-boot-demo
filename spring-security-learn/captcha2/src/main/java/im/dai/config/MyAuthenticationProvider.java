package im.dai.config;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName MyAuthenticationProvider
 * @author: roc
 * @date: 2020/9/4 下午 04:48
 * @version: 1.0
 * @description: 默认 + 自定义方式
 */
public class MyAuthenticationProvider extends DaoAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        //验证操作放入自定义的 WebAuthenticationDetails 中
        //HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //String code = req.getParameter("code");
        //String verify_code = (String) req.getSession().getAttribute("verify_code");
        //if (code == null || verify_code == null || !code.equals(verify_code)) {
        //    throw new AuthenticationServiceException("验证码错误");
        //}

        if (!((MyWebAuthenticationDetails) authentication.getDetails()).isPassed()) {
            throw new AuthenticationServiceException("验证码错误");
        }
        super.additionalAuthenticationChecks(userDetails, authentication);
    }
}
