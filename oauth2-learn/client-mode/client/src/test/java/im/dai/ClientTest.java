package im.dai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
/**
 * @ClassName ClientTest
 * @author: roc
 * @date: 2020/8/31 下午 03:17
 * @version: 1.0
 * @description: TODO
 */

@SpringBootTest(classes = ClientTest.class)
public class ClientTest {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void contextLoads() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", "admin");
        map.add("client_secret", "admin");
        map.add("grant_type", "client_credentials");
        Map<String,String> resp = restTemplate.postForObject("http://localhost:8080/oauth/token", map, Map.class);
        String access_token = resp.get("access_token");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + access_token);
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> entity = restTemplate.exchange("http://localhost:8081/hello", HttpMethod.GET, httpEntity, String.class);
        System.out.println(entity.getBody());
    }

}