package com.bigduu.demomongo.service.impl;

import com.bigduu.demomongo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

/**
 * @author bigduu
 * @title: BaseServiceImpl
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/404:45
 */
@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    private final MongoRepository<T,String> repository;

    protected final ApplicationEventPublisher publisher;

    public BaseServiceImpl(MongoRepository<T, String> repository, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @Override
    public T insert(T t) {
        return repository.insert(t);
    }
}
