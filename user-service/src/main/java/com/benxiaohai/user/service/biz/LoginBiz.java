package com.benxiaohai.user.service.biz;

/**
 * 登录业务类
 *
 * @author wangzhao
 * @create 2019/5/9
 */
public interface LoginBiz {

    String login(String name,String password);

    void logout(String sessionId);
}
