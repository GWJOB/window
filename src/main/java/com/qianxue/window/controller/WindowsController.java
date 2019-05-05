package com.qianxue.window.controller;

import com.qianxue.window.dao.WinUserDao;
import com.qianxue.window.param.Window;
import com.qianxue.window.vo.WinUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/windows")
public class WindowsController {
    @Autowired
    private WinUserDao winUserDao;

    private final static String TITLE = "弹窗";

    @PostMapping("/printWindowContent")
    public void printWindowContent(Window window) {
//        //处理逻辑
//        System.out.println(window.getName());
//        System.out.println(window.getSex());
//        System.out.println(window.getAge());
//
//        InfoUtil test = new InfoUtil();
//        test.show(TITLE, "这是一个弹窗测试！");
        WinUser user = winUserDao.getUser(1L);
        System.out.println(user.toJSONString());
        System.out.println(user.getUserName());
    }
}
