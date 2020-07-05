package com.bigduu.demomongo;

import com.bigduu.demomongo.entity.Department;
import com.bigduu.demomongo.entity.User;
import com.bigduu.demomongo.repository.DepartmentRepository;
import com.bigduu.demomongo.repository.UserRepository;
import com.bigduu.demomongo.repository.impl.BaseRepositoryEnhanceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@EnableMongoAuditing
@EnableMongoRepositories(repositoryBaseClass = BaseRepositoryEnhanceImpl.class)
public class DemomongoApplication  implements CommandLineRunner {
    private final DepartmentRepository departmentRepository;

    private final UserRepository userRepository;

    public DemomongoApplication(DepartmentRepository departmentRepository, UserRepository userRepository) {
        this.departmentRepository = departmentRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemomongoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Department department = Department.builder().name("总部").build();
        User user = User.builder().name("张三").build();
        User user1 = User.builder().name("李四").build();
        List<User> users = Arrays.asList(user, user1);
        userRepository.insert(user);
        department.setUsers(users);
        departmentRepository.insert(department);
    }



}
