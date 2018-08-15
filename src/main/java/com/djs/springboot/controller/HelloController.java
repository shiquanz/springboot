package com.djs.springboot.controller;

import com.djs.springboot.service.AdminService;
import com.djs.springboot.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private AdminService adminService;

    protected static Logger logger=LoggerFactory.getLogger(HelloController.class);

   /* @RequestMapping("/")
    public String helloworld(){
        logger.debug("访问hello");
        return "Hello world!";
    }
*/
    @RequestMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        logger.debug("访问helloName,Name={}",name);
        return "Hello "+name;
    }
    @GetMapping("/helloworld")
    public String helloworld() throws Exception{
        Logger log = LogUtils.getExceptionLogger();
        Logger log1 = LogUtils.getBussinessLogger();
        Logger log2 = LogUtils.getDBLogger();
        adminService.selectAll();
        log.error("getExceptionLogger===日志测试");
        log1.info("getBussinessLogger===日志测试");
        log2.debug("getDBLogger===日志测试");
        return "helloworld";
    }

}

