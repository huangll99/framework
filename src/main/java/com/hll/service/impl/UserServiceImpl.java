package com.hll.service.impl;

import com.hll.dao.SysResourceMapper;
import com.hll.dao.SysUserMapper;
import com.hll.model.SysUser;
import com.hll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by hll on 2016/7/18.
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  SysUserMapper sysUserMapper;

  @Override
  public void changePassword(Long userId, String newPassword) {
    //sysUserMapper.changePassword(userId, newPassword);
  }

  @Override
  public SysUser findByUsername(String username) {
    return sysUserMapper.findByUsername(username);
  }

  @Override
  public Set<String> findRoles(String username) {
    return sysUserMapper.findRoles(username);
  }

  @Override
  public Set<String> findPermissions(String username) {
    return sysUserMapper.findPermissions(username);
  }
}
