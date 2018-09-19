package com.sunc.security.authentication;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.rongyun.RongyunController;
import com.sunc.security.UserUtils;
import com.sunc.constants.LoginType;
import com.sunc.model.ResultGenerator;
import com.sunc.properties.SecurityProperties;
import io.rong.models.response.TokenResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaowenfeng on 2017/10/12.
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    //@Autowired
    private SecurityProperties securityProperties = new SecurityProperties();

//    @Autowired
//    private ClientDetailsService clientDetailsService;
//
//    @Autowired
//    private AuthorizationServerTokenServices authorizationServerTokenServices;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            RongyunController controller = new RongyunController();
            TokenResult tokenResult = controller.register(UserUtils.getCurrentUser());
            Map map = new HashMap();
            map.put("user", UserUtils.getCurrentUser());
            map.put("token", tokenResult.getToken());
            response.getWriter().write(objectMapper.writeValueAsString(ResultGenerator.genSuccessResult(map)));
        }else{
            super.onAuthenticationSuccess(request, response, authentication);
        }

//        String header = request.getHeader("Authorization");
//        if (header == null || !header.startsWith("Basic ")) {
//            response.getWriter().write(objectMapper.writeValueAsString(ResultGenerator.genFailResult("请求头中无client信息")));
//        }
//
//        String[] tokens = extractAndDecodeHeader(header, request);
//        String clientId = tokens[0];
//        String clientSecret = tokens[1];
//
//        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
//        if (clientDetails == null) {
//            response.getWriter().write(objectMapper.writeValueAsString(ResultGenerator.genFailResult("clientId对应的匹配信息不存在:" + clientId)));
//        } else if (!StringUtils.equals(clientDetails.getClientSecret(), clientSecret)) {
//            response.getWriter().write(objectMapper.writeValueAsString(ResultGenerator.genFailResult("clientSecurity不匹配")));
//        }
//
//        TokenRequest tokenRequest = new TokenRequest(new HashMap<>(), clientId, clientDetails.getScope(), "custom");
//
//        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
//
//        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
//
//        OAuth2AccessToken token = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
//
//
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write(objectMapper.writeValueAsString(ResultGenerator.genSuccessResult(token)));

    }

    /**
     * 解码请求头
     */
    private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {
        byte[] base64Token = header.substring(6).getBytes("UTF-8");

        byte[] decoded;
        try {
            decoded = Base64.decode(base64Token);
        } catch (IllegalArgumentException var7) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }

        String token = new String(decoded, "UTF-8");
        int delim = token.indexOf(":");
        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        } else {
            return new String[]{token.substring(0, delim), token.substring(delim + 1)};
        }
    }
}
