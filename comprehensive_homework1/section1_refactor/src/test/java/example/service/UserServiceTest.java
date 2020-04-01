package example.service;


import example.dao.UserDao;
import example.domain.LoginLog;
import example.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest{
    @Mock
    private UserDao userDao;

    @Spy
    @InjectMocks
    private UserService userService;

    private User user;

    @Before
    public void init(){
        user = new User();
        user.setUserId(1);
        user.setUserName("admin");
        user.setPassword("123456");
        user.setLastIp("192.168.12.7");
        user.setLastVisit(new Date());
    }


    @Test
    public void hasMatchUser() {
        doReturn(null).when(userDao).findByNameAndPassword("admin", "1111");
        doReturn(user).when(userDao).findByNameAndPassword("admin", "123456");
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        assertTrue(b1);
        assertFalse(b2);
    }


    @Test
    public void findUserByUserName() {
        doReturn(user).when(userService).findUserByUserName("admin");
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void loginSuccess() {
        doReturn(true).when(userService).saveLog(user);
        boolean b = userService.saveLog(user);
        assertTrue(b);
    }
}

