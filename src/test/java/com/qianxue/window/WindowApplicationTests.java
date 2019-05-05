package com.qianxue.window;

import com.qianxue.window.dao.WinUserDao;
import com.qianxue.window.vo.WinUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WindowApplicationTests {

    @Autowired
    private WinUserDao winUserDao;

    @Test
    public void contextLoads() {
        WinUser user = winUserDao.getUserById(1L);
        System.out.println(user.toJSONString());
    }


}
