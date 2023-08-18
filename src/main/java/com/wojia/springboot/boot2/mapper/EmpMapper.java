package com.wojia.springboot.boot2.mapper;

import com.wojia.springboot.boot2.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface EmpMapper  extends tk.mybatis.mapper.common.Mapper<Emp> {
    List<Emp> shwo();

    Emp showw(int id);

    List<Emp> show(String emp);


}
