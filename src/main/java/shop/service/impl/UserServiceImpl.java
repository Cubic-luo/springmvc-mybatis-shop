package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import shop.dao.UserDao;
import shop.entity.Order;
import shop.entity.User;
import shop.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<Order> showOrders() {
        String username = getUserName();// 获取当前登录用户名
        User user = userDao.queryByName(username);// 查询用户信息
        List<Order> orderList = user.getOrders();// 查询用户订单
        return orderList;
    }

    @Override
    public int register(User user) {
//		注册密码加密开始
        PasswordEncoder encoder = new StandardPasswordEncoder("hfahdf3");
        String rowPassword = user.getPassword();
        String password = encoder.encode(rowPassword);
        user.setPassword(password);
//		注册密码加密结束
        user.setImgUrl("logo.jpg");//设置默认头像
        user.setSex("女");//设置默认性别
        userDao.creatUser(user);// 将注册用户信息插入数据库
        return 0;
    }

    @Override
    public boolean checkUsername(String username) {
        User user = userDao.queryByName(username);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User showUser() {
        String username1 = getUserName();// 获取当前登录用户名
        User user = userDao.queryByName(username1);
        return user;
    }

    /**
     * 获取认证用户信息详情
     *
     * @return
     */
    private UserDetails getUserDetail() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 获取当前认证用户姓名
     *
     * @return
     */
    private String getUserName() {
        String userName = getUserDetail().getUsername();
        return userName;

    }

}
