package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: tensquare_parent
 * @description:
 * @author: Linweizhe
 * @create: 2019-03-11 15:52
 **/

@Service
@Transactional
public class FriendService {
    @Autowired
    private FriendDao friendDao;


    public int addFriend(String userId, String friendId) {

        if (friendDao.findByUserIdAndFriendId(userId, friendId) != null) {
            return 0;
        }
        Friend friend = new Friend();
        friend.setUserId(userId);
        friend.setFriendId(friendId);
        friend.setIslike(0);
        friendDao.save(friend);
        if (friendDao.findByUserIdAndFriendId(friendId,userId  ) != null) {
            friend.setIslike(1);
            friendDao.updateLike("1",userId,friendId);
        }
        return 1;
    }
}
