package shop.service;

import shop.entity.Order;
import shop.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 展示已登录用户的所有订单
     *
     * @return
     */
    public List<Order> showOrders();

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public int register(User user);

    /**
     * 用户前端验证用户名是否存在
     * @param username
     * @return
     */
    public boolean checkUsername(String username);

    /**
     * 展示用户信息
     *
     * @param
     * @return
     */
    public User showUser();


}
