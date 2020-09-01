package im.dai.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginController
 * @author: roc
 * @date: 2020/9/1 下午 02:46
 * @version: 1.0
 * @description: TODO
 */
@Controller
public class LoginController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @GetMapping("/authorization_code")
    public String authorization_code(String code) {
        Map<String, String> map = new HashMap<>();
        map.put("client_id", "换成你github生成的id");
        map.put("client_secret", "换成你github生成的secret");
        map.put("state", "demo");
        map.put("code", code);
        map.put("redirect_uri", "http://localhost:8080/authorization_code");
        Map<String,String> resp = restTemplate.postForObject("https://github.com/login/oauth/access_token", map, Map.class);
        System.out.println(resp);
        HttpHeaders httpheaders = new HttpHeaders();
        httpheaders.add("Authorization", "token " + resp.get("access_token"));
        HttpEntity<?> httpEntity = new HttpEntity<>(httpheaders);
        ResponseEntity<Map> exchange = restTemplate.exchange("https://api.github.com/user", HttpMethod.GET, httpEntity, Map.class);
        System.out.println("exchange.getBody() = " + exchange.getBody());
        return "forward:/index.html";
    }

}
