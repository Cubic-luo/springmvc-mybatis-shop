package shop.entity;

import java.util.Date;

/**
 * 用户评论实体类
 *
 * @author Administrator
 */
public class Discuss {
    private int id;
    private int userId;
    private int parentId;// 回复对象的id
    private Date creatTime;
    private String detail;
    private int stars;
    private int state;


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    // 单个评论和用户之间的关系是1对1
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "id=" + id +
                ", userId=" + userId +
                ", parentId=" + parentId +
                ", creatTime=" + creatTime +
                ", detail='" + detail + '\'' +
                ", stars=" + stars +
                ", state=" + state +
                ", user=" + user +
                '}';
    }

}
