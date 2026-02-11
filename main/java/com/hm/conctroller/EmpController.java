package com.hm.conctroller;

import com.hm.service.EmpSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    private EmpSevice empSevice;


}
