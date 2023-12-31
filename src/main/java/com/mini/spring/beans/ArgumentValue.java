package com.mini.spring.beans;

import lombok.Data;

/**
 * arg value
 *
 * @author cczywyc
 */

@Data
public class ArgumentValue {

    private Object value;

    private String type;

    private String name;

    public ArgumentValue(Object value, String type) {
        this.value = value;
        this.type = type;
    }

    public ArgumentValue(Object value, String type, String name) {
        this.value = value;
        this.type = type;
        this.name = name;
    }
}
