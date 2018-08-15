package com.hand.domain;

import javax.annotation.Resource;

import com.hand.domain.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valueOpsStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    public void stringRedisTemplateDemo() {
        valueOpsStr.set("xxx","yyyyyyyyyy");
    }

    public void save(Person person){
        valOps.set(person.getId(),person);
    }
    public String getString(){
        return valueOpsStr.get("xx");
    }
    public Person getPerson(){
        return (Person) valOps.get(1);
    }
}
