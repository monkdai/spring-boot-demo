package im.dai;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author: roc
 * @date: 2020/9/16 上午 11:42
 * @description: TODO
 */
@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }
}
