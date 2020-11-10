package im.dai.old;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @description: TODO
 * @author: roc
 * @date: 2020/8/9 下午 11:21
 * @version: 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value="/getResult")
    public ResResult  getResult(  ){
        return ResResult.suc("test");
    }
}
