package com.hll;

import com.hll.model.SysUser;
import com.hll.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hll on 2016/7/18.
 */
public class MyShiroRealm extends AuthorizingRealm{

  @Autowired
  UserService userService;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    String username= (String) principals.getPrimaryPrincipal();
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    authorizationInfo.setRoles(userService.findRoles(username));
    authorizationInfo.setStringPermissions(userService.findPermissions(username));
    return authorizationInfo;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    String username= (String) token.getPrincipal();
    SysUser user = userService.findByUsername(username);
    if (user==null){
      throw new UnknownAccountException();
    }
    if (Boolean.TRUE.equals(user.getLocked())){
      throw new LockedAccountException();
    }
    return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),"");
  }
}
