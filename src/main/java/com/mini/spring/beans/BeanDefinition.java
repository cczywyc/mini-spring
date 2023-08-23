package com.mini.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * bean definition
 * @author cczywyc
 */

@Data
@AllArgsConstructor
public class BeanDefinition {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    private boolean lazyInit = false;
    private String[] dependsOn;
    private ArgumentValues constructorArgumentValues;
    private PropertyValues propertyValues;
    private String initMethodName;

    private volatile Object beanClass;

    /** bead id */
    private String id;

    /** bean object class name */
    private String className;

    /** scope */
    private String scope = SCOPE_SINGLETON;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public boolean hasBeanClass() {
        return this.beanClass instanceof Class;
    }

    public boolean isSingleton() {
        return SCOPE_SINGLETON.equals(scope);
    }

    public boolean isPrototype() {
        return SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean hasConstructorArgumentValues() {
        return !this.constructorArgumentValues.isEmpty();
    }

}
