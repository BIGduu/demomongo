package com.bigduu.demomongo.service;

/**
 * @author bigduu
 * @title: BaseService
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/404:45
 */
public interface BaseService<T> {

    T insert(T t);

}
