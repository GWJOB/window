package com.qianxue.window.controller;

import com.qianxue.window.BaseTest;
import com.qianxue.window.dao.win.user.WinUserDao;
import com.qianxue.window.vo.WinUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WindowsControllerTest extends BaseTest {

    @Autowired
    private WinUserDao winUserDao;

    @Test
    public void printWindowContent() {
        WinUser user = winUserDao.getUser(1L);
        System.out.println(user.toJSONString());
        System.out.println(user.getUserName());

    }
}