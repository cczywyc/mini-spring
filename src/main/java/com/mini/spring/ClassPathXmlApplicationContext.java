package com.mini.spring;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class path xmp application context, read xml and reject beans
 *
 * @author cczywyc
 */
public class ClassPathXmlApplicationContext {

    /**
     * bean definitions, put beans
     */
    private List<BeanDefinition> beanDefinitions = new ArrayList<>();

    /**
     * bean map
     */
    private Map<String, Object> singletons = new HashMap<>();

    public ClassPathXmlApplicationContext(String filename) {
        this.readXml(filename);
        this.instanceBean();
    }

    /**
     * read xml
     *
     * @param filename xml filename
     */
    private void readXml(String filename) {
        SAXReader saxReader = new SAXReader();
        try {
            URL xmlPath = this.getClass().getClassLoader().getResource(filename);
            Document document = saxReader.read(xmlPath);
            Element rootElement = document.getRootElement();
            // get every bean info from xml
            for (Element element : (List<Element>) rootElement.elements()) {
                String beanId = element.attributeValue("id");
                String beanClassName = element.attributeValue("class");
                BeanDefinition beanDefinition =  new BeanDefinition(beanId, beanClassName);
                beanDefinitions.add(beanDefinition);
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * instance bean, put singletons
     */
    private void instanceBean() {
        for (BeanDefinition beanDefinition : beanDefinitions) {
            try {
                singletons.put(beanDefinition.getId(), Class.forName(beanDefinition.getClassName()).getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * get bean by beanName
     * @param beanName bean name
     * @return bean object
     */
    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }

}
