package im.dai.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/8/28 上午 11:35
 * @version: 1.0
 * @description: TODO
 */
@Controller
public class HelloController {

    @Autowired
    TokenTask tokenTask;

    @GetMapping("/index.html")
    public String hello(String code, Model model) {
        model.addAttribute("msg", tokenTask.getData(code));
        return "index";
    }

    //@Bean
    //public RestTemplate restTemplate(RestTemplateBuilder builder) {
    //    return builder.build();
    //}
    //
    //@Autowired
    //RestTemplate restTemplate;
    //
    //@GetMapping("/index.html")
    //public String hello(String code, Model model) {
    //    if (code != null) {
    //        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    //        map.add("code", code);
    //        map.add("client_id", "admin");
    //        map.add("client_secret", "admin");
    //        map.add("redirect_uri", "http://localhost:8082/index.html");
    //        map.add("grant_type", "authorization_code");
    //        Map<String,String> resp = restTemplate.postForObject("http://localhost:8080/oauth/token", map, Map.class);
    //        String access_token = resp.get("access_token");
    //        System.out.println(access_token);
    //        HttpHeaders headers = new HttpHeaders();
    //        headers.add("Authorization", "Bearer " + access_token);
    //        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
    //        ResponseEntity<String> entity = restTemplate.exchange("http://localhost:8081/admin/hello", HttpMethod.GET, httpEntity, String.class);
    //        model.addAttribute("msg", entity.getBody());
    //    }
    //    return "index";
    //}
}
