package com.qianxue.window;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qianxue.window.dao.win.user.WinUserDao;
import com.qianxue.window.vo.WinUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WindowApplicationTests {

    @Autowired
    private WinUserDao winUserDao;

    @Test
    public void contextLoads() {
//        WinUser user = winUserDao.getUser(1L);
//        System.out.println(user.toJSONString());
//        List<WinUser> winUsers = winUserDao.selectList(new LambdaQueryWrapper<WinUser>());
//        winUsers.forEach(winUser -> System.out.println(winUser.toJSONString()));
        WinUser winUser = winUserDao.getUserById(1L);
        System.out.println(winUser);
    }


}
