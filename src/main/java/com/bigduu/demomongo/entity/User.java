package com.bigduu.demomongo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author bigduu
 * @title: User
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/300:33
 */
@Data
@Builder
@Document
@EqualsAndHashCode(callSuper = true)
public class User extends BaseMongoEntity{
    private String name;
}
