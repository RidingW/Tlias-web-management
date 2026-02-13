package com.hm.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hm.mapper.EmpMapper;
import com.hm.pojo.Emp;
import com.hm.pojo.PageBean;
import com.hm.service.EmpSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpSevice {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 分页查询基本实现
     * @param page
     * @param pageSize
     * @return
     */
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        // 获取总记录数
//        Long count = empMapper.count();
//
//        // 获取目标页数据列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//
//
//        // 返回结果
//        return new PageBean(count, empList);
//    }

    /**
     * 使用 pagehelper 进行分页
     * 使用 1.4.2 版本报错：class java.util.ArrayList
     * cannot be cast to class com.github.pagehelper.Page
     * 换成 1.4.6 解决问题
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);

        // 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        // 封装 PageBean 对象
        return new PageBean(p.getTotal(), p.getResult());
    }

    /**
     * 批量删除员工信息
     * @param ids
     */
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    /**
     * 新增员工
     * @param emp
     */
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
    }
}
