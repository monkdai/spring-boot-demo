package im.dai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/9/7 上午 09:57
 * @version: 1.0
 * @description: TODO
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public void hello(HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        String name = (String) session.getAttribute("name");
        if (name == null || "".equals(name)) {
            session.setAttribute("name", "admin");
            System.out.println("set session");
        }
        System.out.println("name = " + name);
        System.out.println(session==null?session:session.getId());
    }
}
