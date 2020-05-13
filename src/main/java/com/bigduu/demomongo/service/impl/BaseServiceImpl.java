package com.bigduu.demomongo.service.impl;

import com.bigduu.demomongo.service.BaseService;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author bigduu
 * @title: BaseServiceImpl
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/404:45
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    private final MongoRepository<T,String> repository;

    public BaseServiceImpl(MongoRepository<T, String> repository) {
        this.repository = repository;
    }

    @Override
    public T insert(T t) {
        return repository.insert(t);
    }
}
