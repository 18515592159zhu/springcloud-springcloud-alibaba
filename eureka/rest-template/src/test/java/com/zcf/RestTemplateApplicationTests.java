package com.zcf;

import com.zcf.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestTemplateApplicationTests {

    //在Java代码中发送一个请求，请求一个页面
    @Test
    void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        //如果你访问的是一个页面，会返回html代码
        String url = "https://www.baidu.com";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println("responseEntity = " + responseEntity);
    }

    //测试发送get请求使用getForObject
    @Test
    void testGet() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/testGet?name=zcf";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("result = " + result);
    }

    //测试发送get请求使用getForEntity
    @Test
    void testGet_1() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/testGet?name=zcf";
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        //http:// 协议 (规范 接头暗号)
        //请求头 请求参数 .. 响应头 响应状态码 报文 ....
        System.out.println("result = " + result);
    }

    //测试发送 post JSON 参数
    @Test
    void testPost_1() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/testPost1";
        User user = new User("张三", 23, 23000D);
        String result = restTemplate.postForObject(url, user, String.class);
        System.out.println("result = " + result);
    }

    //测试发送post表单参数
    @Test
    void testPost_2(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/testPost2";
        //构建表单参数
        LinkedMultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
        map.add("name","李四");
        map.add("age",24);
        map.add("price",24000D);
        String result = restTemplate.postForObject(url, map, String.class);
        System.out.println("result = " + result);
    }
}
