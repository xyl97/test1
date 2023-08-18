package com.wojia.springboot.boot2.service;

import com.wojia.springboot.boot2.pojo.Emp;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmpService {
//    List<Emp> show();

    Emp showw(Integer id);


    Integer delete(Integer id);

    void update(Emp emp);

    void add(Emp emp);

    List<Emp> show(String username);
}
