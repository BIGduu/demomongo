package com.bigduu.demomongo.mongConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.ObjDoubleConsumer;


/**
 * @author bigduu
 * @title: BeforeSaveListener
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/301:28
 */
@Component
public class BeforeSaveListener extends AbstractMongoEventListener<Object> {

    private final MongoOperations mongoOperations;
    private ObjectMapper objectMapper = new ObjectMapper();

    public BeforeSaveListener(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }


    /**
     * Captures {@link BeforeConvertEvent}.
     *
     * @param event never {@literal null}.
     * @since 1.8
     */
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        ReflectionUtils.doWithFields(source.getClass(), field -> {
            ReflectionUtils.makeAccessible(field);
            if (field.isAnnotationPresent(DBRef.class)){
                if (Objects.requireNonNull(event.getCollectionName()).startsWith("delete_")){
                    return;
                }
                Object fieldValue = field.get(source);
                if (Collection.class.isAssignableFrom(fieldValue.getClass())){
                    Collection collection =  (Collection)fieldValue;
                    for (Object element : collection) {
                        mongoOperations.save(element);
                    }
                } else {
                    mongoOperations.save(fieldValue);
                }

            }
        });
        super.onBeforeConvert(event);
    }

    /**
     * Capture {@link BeforeDeleteEvent}.
     *
     * @param event will never be {@literal null}.
     * @since 1.8
     */
    @Override
    public void onBeforeDelete(BeforeDeleteEvent<Object> event) {
        Document source = event.getSource();
        Object id = mongoOperations.findById(source.get("_id"), event.getClass());
        mongoOperations.save(id,"delete_"+event.getCollectionName());
        super.onBeforeDelete(event);
    }

}
