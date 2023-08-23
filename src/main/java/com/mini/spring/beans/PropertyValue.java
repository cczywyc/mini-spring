package com.mini.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * property value
 *
 * @author cczywyc
 */

@Data
@AllArgsConstructor
public class PropertyValue {
    private String type;

    private String name;

    private Object value;

}
