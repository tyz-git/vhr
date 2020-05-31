package org.javaboy.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: TongYaZhou
 * @create: 2020-05-31 19:03
 **/
@RestController
public class HelloController {

    @GetMapping(value = "/employee/basic/hello")
    public String hello(){
        return "/employee/basic/**";
    }

    @GetMapping(value = "/employee/advanced/hello")
    public String hello1(){
        return "/employee/advanced/**";
    }
}
