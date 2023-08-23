package com.mini.spring.context;

/**
 * application event publisher
 *
 * @author cczywyc
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
