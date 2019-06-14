package com.xiongya.springboot.shiro.config;

import com.xiongya.springboot.shiro.entity.User;
import com.xiongya.springboot.shiro.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-06-14 14:28
 * 自定义Realm，只需继承AuthorizingRealm
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {


    @Autowired
    private UserMapper userMapper;


    /**
     * 获取用户权限和角色
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户输入的用户名和密码
        String userName = (String)token.getPrincipal();
        String password = (String)token.getCredentials();

        log.info("用户:{}认证------ShiroRealm.doGetAuthenticationInfo", userName);

        //通过用户名到数据库查询用户信息
        User user = userMapper.findByUserName(userName);

        if (user == null){
            throw new UnknownAccountException("用户名或密码错误!");
        }

        if (!password.equals(user.getPassword())){
            throw new IncorrectCredentialsException("用户名或密码错误!");
        }

        if (user.getStatus().equals(0)){
            throw new LockedAccountException("账号已被锁定，请联系管理员!");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
