package com.bigduu.demomongo.service.impl;

import com.bigduu.demomongo.entity.Department;
import com.bigduu.demomongo.repository.DepartmentRepository;
import com.bigduu.demomongo.service.DepartmentService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.websocket.server.ServerEndpoint;

/**
 * @author bigduu
 * @title: DepartmentServiceImpl
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/1406:34
 */
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {


    public DepartmentServiceImpl(DepartmentRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Department customerInsertDepartment(Department department) {
        return insert(department);
    }
}
