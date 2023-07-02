package com.mini.spring.impl;

import com.mini.spring.AService;

/**
 * test implements
 * @author cczywyc
 */
public class AServiceImpl implements AService {

    @Override
    public String sayHello() {
        return "AService say hello";
    }
}
