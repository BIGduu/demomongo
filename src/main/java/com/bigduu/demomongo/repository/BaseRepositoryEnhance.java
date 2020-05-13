package com.bigduu.demomongo.repository;

import com.bigduu.demomongo.entity.BaseMongoEntity;

/**
 * @author bigduu
 * @title: BaseRepositoryEnhance
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/405:21
 */
public interface BaseRepositoryEnhance<T extends BaseMongoEntity> {
    T softDelete(T entity);
}
