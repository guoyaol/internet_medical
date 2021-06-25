package org.linlinjava.internetmedical.wx.service;

import org.linlinjava.internetmedical.db.domain.InternetmedicalUser;
import org.linlinjava.internetmedical.db.service.InternetmedicalUserService;
import org.linlinjava.internetmedical.wx.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserInfoService {
    @Autowired
    private InternetmedicalUserService userService;


    public UserInfo getInfo(Integer userId) {
        InternetmedicalUser user = userService.findById(userId);
        Assert.state(user != null, "用户不存在");
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}
