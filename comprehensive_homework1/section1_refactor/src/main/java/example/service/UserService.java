package example.service;

import example.dao.LoginLogDao;
import example.dao.UserDao;
import example.domain.LoginLog;
import example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password) {
//        int matchCount = userDao.getMatchCount(userName, password);
        User user = userDao.findByNameAndPassword(userName, password);
        ;
        if(user!=null){
            return true;
        }else{
            return false;
        }
    }

    public User findUserByUserName(String userName) {
        return userDao.findByName(userName);
    }

    public boolean saveLog(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
//        loginLogDao.insertLoginLog(loginLog);
        loginLogDao.save(loginLog);
        return true;
    }
}
