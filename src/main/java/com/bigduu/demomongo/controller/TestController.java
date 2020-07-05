package com.bigduu.demomongo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * @author bigduu
 * @title: TestController
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/615:55
 */
@RestController
@RequestMapping("/")
public class TestController {
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public void test(HttpServletRequest httpRequest) throws JsonProcessingException {
        String s = readAsChars(httpRequest);
        Map map = objectMapper.readValue(s, Map.class);
        Object station = map.get("station");

        System.out.println(s);
    }
    // 字符串读取
    // 方法一
    public static String readAsChars(HttpServletRequest request) {

        BufferedReader br;
        StringBuilder sb = new StringBuilder("");
        try {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
