package com.hm.conctroller;

import com.hm.pojo.Dept;
import com.hm.pojo.Result;
import com.hm.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 查询部门信息
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)  // 限定 http 方法为get
    @GetMapping("/depts")
    public Result list(){
        log.info("查询部门信息！");

        List<Dept> deptList =  deptService.list();

        return Result.success(deptList);
    }

    // 删除部门
    @DeleteMapping("/depts/{id}")
    public Result deleteDept(@PathVariable Integer id){
        log.info("删除ID="+ id + "的部门！");

        deptService.deleteById(id);

//        return isDelete ? Result.success() : Result.error("删除失败！");
        return Result.success();
    }

    // 新增部门
    @PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept){
        log.info("新增部门 {}", dept);
        // 调用 service 新增部门

        deptService.addDept(dept);
        return Result.success();
    }

    // 根据 ID 查询部门
    @GetMapping("/depts/{id}")
    public Result getDeptById(@PathVariable Integer id){
        log.info("获取 id：{} 的部门信息", id);
        Dept dept =  deptService.getDeptById(id);
        return Result.success(dept);
    }


    // 根据 ID修改部门信息
    @PutMapping("/depts")
    public Result updateDept(@RequestBody Dept dept){
        log.info("修改部门：{}",dept);
        // 调用 service 修改部门

        deptService.updateDept(dept);
        return Result.success();
    }
}
