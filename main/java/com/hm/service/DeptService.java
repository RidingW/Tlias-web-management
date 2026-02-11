package com.hm.service;

import com.hm.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void deleteById(Integer id);

    void addDept(Dept dept);

    Dept getDeptById(Integer id);

    void updateDept(Dept dept);
}
