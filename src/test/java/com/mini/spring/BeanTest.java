package com.mini.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * bean test
 * @author cczywyc
 */

public class BeanTest {

    @Test
    public void simpleBeanTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AService service = (AService) context.getBean("AService");
        Assertions.assertEquals("AService say hello", service.sayHello());
    }
}
