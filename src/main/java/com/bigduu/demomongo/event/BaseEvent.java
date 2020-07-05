package com.bigduu.demomongo.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author bigduu
 * @title: BaseEvent
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/1511:11
 */
public class BaseEvent<T> extends ApplicationEvent {
    public BaseEvent(T source) {
        super(source);
    }
}
