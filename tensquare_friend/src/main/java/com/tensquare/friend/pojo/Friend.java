package com.tensquare.friend.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: tensquare_parent
 * @description: friend实体类
 * @author: Linweizhe
 * @create: 2019-03-11 15:52
 **/

@Entity
@Table(name = "tb_friend")
public class Friend implements Serializable {
    @Id
    private String userId;
    @Id
    private String friendId;
    private int islike;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public int getIslike() {
        return islike;
    }

    public void setIslike(int islike) {
        this.islike = islike;
    }
}
