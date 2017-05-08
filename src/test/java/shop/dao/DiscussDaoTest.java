package shop.dao;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.entity.Discuss;

public class DiscussDaoTest extends BaseTest {

	@Autowired
	private DiscussDao discussDao;

	// 查询所有评论
	@Test
	public void testQueryAll() {
		List<Discuss> discussList = discussDao.queryAll();
		for (Discuss discuss : discussList) {
			System.out.println(discuss);
		}
		// 测试通过
	}

	// 根据用户id查询评论
	@Test
	public void testQueryByUserId() {
		List<Discuss> discussList = discussDao.queryByUserId(1);
		for (Discuss discuss : discussList) {
			System.out.println(discuss);
		}
		// 测试通过
	}

	// 插入评论
	@Test
	public void testInsertDiscuss() {
		Discuss discuss = new Discuss();
		discuss.setCreatTime(new Date());
		discuss.setDetail("测试评论2");
		discuss.setStars(3);
		discuss.setUserId(1);
		discussDao.insertDiscuss(discuss);
		// 测试通过
	}

	// 根据评论id删除评论
	@Test
	public void testDeleteDiscuss() {
		discussDao.deleteDiscuss(3);
		// 测试通过
	}

}
