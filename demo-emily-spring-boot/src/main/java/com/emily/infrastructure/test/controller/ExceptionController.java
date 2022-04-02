package com.emily.infrastructure.test.controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-parent
 * @description: 异常控制器
 * @author: Emily
 * @create: 2021/08/21
 */
@RestController
@RequestMapping("/api/exception")
public class ExceptionController {

    @GetMapping("test1")
    public void exception() {
        String s = null;
        s.length();
    }

    @GetMapping("assert1")
    public void assert1() {
        String s = null;
        Assert.notNull(s, "字符串为不可为空");
    }
}
