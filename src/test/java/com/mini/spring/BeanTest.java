package com.mini.spring;

import com.mini.spring.beans.BeansException;
import com.mini.spring.beans.NoSuchBeanDefinitionException;
import com.mini.spring.context.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * bean test
 * @author cczywyc
 */

public class BeanTest {

    @Test
    public void simpleBeanTest() throws NoSuchBeanDefinitionException, BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AService service = (AService) context.getBean("AService");
        Assertions.assertEquals("AService say hello", service.sayHello());
    }
}
