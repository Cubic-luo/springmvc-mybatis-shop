package shop.dao;

import org.apache.ibatis.annotations.Param;
import shop.entity.Discuss;

import java.util.List;

public interface DiscussDao {

	/**
	 * 查询所有评论
	 * 
	 * @return
	 */
	public List<Discuss> queryAll();

	/**
	 * 根据用户id查询评论
	 * 
	 * @param userId
	 * @return
	 */
	public List<Discuss> queryByUserId(int userId);

	/**
	 * 插入评论
	 * 
	 * @param discuss
	 * @return
	 */
	public int insertDiscuss(Discuss discuss);

	/**
	 * 根据评论id删除评论
	 * 
	 * @param discussId
	 * @return
	 */
	public int deleteDiscuss(int discussId);

	/**
	 * 根据评论id更改评论审核状态
	 * @param discussId 评论id
	 * @param state 修改的状态
	 * @return
	 */
	public int checkDiscuss(@Param("discussId") int discussId,@Param("state") int state);

}
