package com.bigduu.demomongo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author bigduu
 * @title: Department
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/300:34
 */
@EqualsAndHashCode(callSuper = true)
@Document
@Data
@Builder
public class Department extends BaseMongoEntity{

    private String name;
    @DBRef
    private List<User> users;
}
