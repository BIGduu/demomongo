package com.bigduu.demomongo.service;

import com.bigduu.demomongo.entity.Department;

/**
 * @author bigduu
 * @title: DepartmentService
 * @projectName demomongo
 * @description: TODO
 * @date 2020/5/1406:34
 */
public interface DepartmentService extends BaseService<Department> {
    Department customerInsertDepartment(Department department);
}
