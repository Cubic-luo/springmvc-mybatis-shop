package shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.DiscussDao;
import shop.dao.UserDao;
import shop.entity.Discuss;
import shop.entity.User;
import shop.service.DiscussService;

import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
@Service
public class DiscussServiceImpl implements DiscussService {
    @Autowired
    private DiscussDao discussDao;
    @Autowired
    private UserDao userDao;
    @Override
    public PageInfo<Discuss> queryAllDiscsss(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Discuss> discussList = discussDao.queryAll();
        PageInfo<Discuss> p=new PageInfo<>(discussList);
        return p;
    }

    @Override
    public PageInfo<Discuss> queryByUsername(String username,int pageNum,int pageSize) {
        User user=userDao.queryByName(username);
        int userId=user.getId();//获取用户id
        PageHelper.startPage(pageNum,pageSize);
        List<Discuss> discussList=discussDao.queryByUserId(userId);//根据用户id查询评论
        PageInfo<Discuss> p=new PageInfo<>(discussList);
        return p;

    }

    @Override
    public int deleteDiscuss(int discussId) {
        return discussDao.deleteDiscuss(discussId);
    }

    @Override
    public int checkDiscuss(int discussId,int state) {
        return discussDao.checkDiscuss(discussId,state);
    }

}
