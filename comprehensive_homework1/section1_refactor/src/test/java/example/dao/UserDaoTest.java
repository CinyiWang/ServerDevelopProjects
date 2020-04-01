package example.dao;


import example.config.*;
import example.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@Transactional
public class UserDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserDao userDao;


    @Test
    public void hasMatchUser() {
        User user = userDao.findByNameAndPassword("admin", "123456");
        assertNotEquals(user,null);
    }

    @Test
    public void findUserByUserName() {
        User user = userDao.findByName("admin");
        assertNotNull(user);
        assertEquals(user.getUserName(), "admin");
    }

}
