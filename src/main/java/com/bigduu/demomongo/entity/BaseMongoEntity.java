package com.bigduu.demomongo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

/**
 * @author bigduu
 * @title: BaseMongoEntity
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/300:34
 */
@Data
public class BaseMongoEntity {
    @Id
    private String id;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @Version
    private Long version;
    private Boolean isDeleted = false;
}
