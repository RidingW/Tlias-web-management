package com.hm.service;

import com.hm.pojo.Emp;
import com.hm.pojo.PageBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EmpSevice {

    // 进行分页查询
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);
}
