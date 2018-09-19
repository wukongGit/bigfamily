package com.sunc.rongyun;

import io.rong.RongCloud;
import io.rong.methods.user.User;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;

/**
 * Created by suncheng on 2018/8/2.
 */
public class RongyunController {

    private User getRongCloudUser() {
        RongCloud rongCloud = RongCloud.getInstance(Constants.appKey, Constants.appSecret);
        return rongCloud.user;
    }

    public TokenResult register(com.sunc.bean.User user) {
        UserModel userModel = new UserModel()
                .setId(String.valueOf(user.getId()))
                .setName(user.getUsername())
                .setPortrait(user.getImage());
        try {
            TokenResult result = getRongCloudUser().register(userModel);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
