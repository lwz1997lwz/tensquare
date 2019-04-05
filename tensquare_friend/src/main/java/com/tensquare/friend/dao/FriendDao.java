package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @program: tensquare_parent
 * @description: friend数据访问层
 * @author: Linweizhe
 * @create: 2019-03-11 16:00
 **/
public interface FriendDao extends JpaRepository<Friend,String>{

    //根据用户id和朋友id查询
    public Friend findByUserIdAndFriendId(String userId, String friendId);

    //将两者更新为相互喜欢 （islike = 1）

    @Modifying
    @Query("update tb_friend set islike = ?1 where userid = ?2 and friendid = ?3")
    public void updateLike(String islike, String userId, String friendId);
}
