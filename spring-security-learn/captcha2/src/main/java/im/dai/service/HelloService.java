package im.dai.service;

import im.dai.config.MyWebAuthenticationDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @author: roc
 * @date: 2020/9/4 下午 05:29
 * @version: 1.0
 * @description: 默认只获取到用户 ip 和 session id
 */
@Service
public class HelloService {

    //public WebAuthenticationDetails hello() {
    //    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //    WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
    //    return details;
    //}

    public MyWebAuthenticationDetails hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyWebAuthenticationDetails details = (MyWebAuthenticationDetails) authentication.getDetails();
        return details;
    }
}
