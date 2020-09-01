package im.dai.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Map;

/**
 * @ClassName TokenTask
 * @author: roc
 * @date: 2020/8/31 下午 05:56
 * @version: 1.0
 * @description: 定义一个专门的类 TokenTask 用来解决 Token 的管理问题
 * 1、首先在 getData 方法中，如果 access_token 为空字符串，并且 code 不为 null，表示这是刚刚拿到授权码的时候，
 * 准备去申请令牌了，令牌拿到之后，将 access_token 和 refresh_token 分别赋值给变量，
 * 然后调用  loadDataFromResServer 方法去资源服务器加载数据。
 *
 * 2、另外有一个 tokenTask 方法，这是一个定时任务，每隔 115 分钟去刷新一下 access_token（access_token 有效期是 120 分钟）
 */
@Component
@SessionScope
public class TokenTask {
    @Autowired
    RestTemplate restTemplate;

    public String access_token = "";
    public String refresh_token = "";

    public String getData(String code) {
        if ("".equals(access_token) && code != null) {
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("code", code);
            map.add("client_id", "admin");
            map.add("client_secret", "admin");
            map.add("redirect_uri", "http://localhost:8082/index.html");
            map.add("grant_type", "authorization_code");
            Map<String, String> resp = restTemplate.postForObject("http://localhost:8080/oauth/token", map, Map.class);
            access_token = resp.get("access_token");
            refresh_token = resp.get("refresh_token");
        }
        return loadDataFromResServer();
    }

    private String loadDataFromResServer() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + access_token);
            HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
            ResponseEntity<String> entity = restTemplate.exchange("http://localhost:8081/admin/hello", HttpMethod.GET, httpEntity, String.class);
            return entity.getBody();
        } catch (RestClientException e) {
            return "未加载";
        }
    }

    @Scheduled(cron = "0 55 0/1 * * ？")
    public void tokenTask() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", "admin");
        map.add("client_secret", "admin");
        map.add("refresh_token", refresh_token);
        map.add("grant_type", "refresh_token");
        Map<String, String> resp = restTemplate.postForObject("http://localhost:8080/oauth/token", map, Map.class);
        access_token = resp.get("access_token");
        refresh_token = resp.get("refresh_token");
    }
}