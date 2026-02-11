package com.hm;

import com.hm.mapper.DeptMapper;
import com.hm.mapper.EmpMapper;
import com.hm.pojo.Dept;
import com.hm.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class TliasWebManagementApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testSelect(){
        List<Emp> emps = empMapper.selectAll();
        System.out.println(emps);
    }

    @Test
    public void testGetIdByName(){
        String name = "销售部";
        Integer id = deptMapper.getIdByName(name);
        System.out.println(name + "的id :" + id);
    }

	@Test
	void contextLoads() {
	}

}
