package com.mini.spring.beans.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * bean definition
 * @author cczywyc
 */

@Data
@AllArgsConstructor
public class BeanDefinition {

    /** bead id */
    private String id;

    /** bean object class name */
    private String className;
}
