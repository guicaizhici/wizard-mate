package com.guicai.guipao.service;

import com.guicai.guipao.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("guicaiString", "dog");
        valueOperations.set("guicaiInt", 1);
        valueOperations.set("guicaiDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("guicai");
        valueOperations.set("guicaiUser", user);
        // 查
        Object guicai = valueOperations.get("guicaiString");
        Assertions.assertTrue("dog".equals((String) guicai));
        guicai = valueOperations.get("guicaiInt");
        Assertions.assertTrue(1 == (Integer) guicai);
        guicai = valueOperations.get("guicaiDouble");
        Assertions.assertTrue(2.0 == (Double) guicai);
        System.out.println(valueOperations.get("guicaiUser"));
        valueOperations.set("guicaiString", "dog");
        redisTemplate.delete("guicaiString");
    }
}
