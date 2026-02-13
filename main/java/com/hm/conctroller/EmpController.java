package com.hm.conctroller;

import com.hm.pojo.Emp;
import com.hm.pojo.PageBean;
import com.hm.pojo.Result;
import com.hm.service.EmpSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpSevice empSevice;

    /**
     * 条件分页查询
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    @GetMapping()
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询，参数：{}，{}, {}, {},{},{}", page, pageSize, name, gender, begin, end);

        // 调用 service 分页查询
        PageBean pageBean = empSevice.page(page, pageSize,name, gender, begin, end);

        return Result.success(pageBean);
    }

    /**
     * 批量删除员工信息
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids ) {
        log.info("批量删除员工信息:{}", ids);

        empSevice.delete(ids);

        return Result.success();
    }

    /**
     * 新增员工
     * @param emp
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工: {}",emp);

        empSevice.save(emp);

        return Result.success();
    }
}
