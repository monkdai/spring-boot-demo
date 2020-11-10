package im.dai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: roc
 * @date: 2020/9/11 下午 05:46
 * @description: TODO
 */
@Controller
public class ThymeleafController {
    @GetMapping("/thymeleaf")
    public String index(ModelMap map) {
        map.addAttribute("host", "thymeleaf");
        return "index";
    }
}
