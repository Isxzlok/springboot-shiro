package com.xiongya.springboot.shiro.config;

import com.xiongya.springboot.shiro.entity.Permission;
import com.xiongya.springboot.shiro.entity.Role;
import com.xiongya.springboot.shiro.entity.User;
import com.xiongya.springboot.shiro.mapper.UserMapper;
import com.xiongya.springboot.shiro.mapper.UserPermissionMapper;
import com.xiongya.springboot.shiro.mapper.UserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserPermissionMapper userPermissionMapper;


    /**
     * 获取用户权限和角色
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String userName = user.getUserName();

        log.info("用户{}获取权限-----获取权限-----ShiroRealm.doGetAuthorizationInfo", userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //获取用户角色集
        List<Role> roleList = userRoleMapper.findByUserName(userName);
        //lambda表达式，将list集合中的Role对象的name属性封装进set集合
        Set<String> roleSet = roleList.stream().map(Role::getName).collect(Collectors.toSet());

        simpleAuthorizationInfo.setRoles(roleSet);

        //获取用户权限集
        List<Permission> permissionList = userPermissionMapper.findByUserName(userName);
        Set<String> permissionSet = permissionList.stream()
                .map(Permission::getName)
                .collect(Collectors.toSet());

        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("hahahahhha");
        //获取用户输入的用户名和密码
        String userName = (String)token.getPrincipal();
        char[] pwd = (char[])token.getCredentials();
        String password = new String(pwd);


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
