package shop.service;

import com.github.pagehelper.PageInfo;
import shop.entity.Discuss;

/**
 * Created by Administrator on 2017/3/17.
 * 评论
 */
public interface DiscussService {
    /**
     * 查询所有评论
     *
     * @return
     */
    public PageInfo<Discuss> queryAllDiscsss(int pageNum, int pageSize);

    /**
     * 根据用户名查询评论
     * @param usrname
     * @return
     */
    public PageInfo<Discuss> queryByUsername(String usrname,int pageNum,int pageSize);

    /**
     * 根据评论id删除评论
     * @param discussId
     * @return
     */
    public int deleteDiscuss(int discussId);
    /**
     * 根据评论审核评论
     * @param discussId
     * @return
     */
    public int checkDiscuss(int discussId,int state);
}
