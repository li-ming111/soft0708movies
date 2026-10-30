package com.hxx.domain;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

public class TestDemo {

    @Test
    public void test4() {
        String jsonString = "[{\"id\":1001,\"name\":\"hxx\"," +
                "\"age\":18},{\"id\":1002,\"name\":\"hxx2\"," +
                "\"age\":19}]";
        List<Person> list = JSON.parseArray(jsonString, Person.class);
        System.out.println(list);
    }
    @Test
    public void test3() {
        /*List<Person> list = Arrays.asList(new Person(1001, "hxx", 18),
                new Person(1002, "hxx2", 19));*/
        List<Person> list = List.of(new Person(1001, "hxx", 18),
                new Person(1002, "hxx2", 19));

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
    }
    @Test
    public void test1() {
        Person person = new Person(1001, "hxx", 18);
        String jsonString = JSON.toJSONString(person);
        System.out.println(jsonString);
    }

    @Test
    public void test2() {
        String jsonString = "{\"id\":1001,\"name\":\"hxx\"," +
                "\"age\":18}";
        Person person = JSON.parseObject(jsonString, Person.class);
        System.out.println(person);
    }
}

