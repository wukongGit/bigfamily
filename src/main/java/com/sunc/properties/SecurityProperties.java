package com.sunc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by suncheng on 2018/8/7.
 */
@Data
@ConfigurationProperties(prefix = "my.security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
}
