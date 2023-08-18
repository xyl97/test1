package com.wojia.springboot.boot2.service;

import com.wojia.springboot.boot2.mapper.EmpMapper;
import com.wojia.springboot.boot2.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    EmpMapper empmapper;
//    @Override
//    public List<Emp> show() {
//        return empmapper.selectAll();
//    }

    @Override
    public Emp showw(Integer id) {
        return empmapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer delete(Integer id) {
        return empmapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Emp emp) {
        empmapper.updateByPrimaryKey(emp);
    }

    @Override
    public void add(Emp emp) {
        empmapper.insert(emp);
    }

    @Override
    public List<Emp> show(String username) {
        return empmapper.show(username);
    }


}
