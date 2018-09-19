package com.sunc.properties;

import com.sunc.constants.LoginType;
import com.sunc.constants.SecurityConstants;
import lombok.Data;

/**
 * Created by suncheng on 2018/8/7.
 */
@Data
public class BrowserProperties {
    private LoginType loginType = LoginType.JSON;
    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;
}
