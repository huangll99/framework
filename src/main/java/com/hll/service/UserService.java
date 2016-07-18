package com.hll.service;

import com.hll.model.SysUser;

import java.util.Set;

/**
 * Created by hll on 2016/7/18.
 */
public interface UserService {

  void changePassword(Long userId,String newPassword);
  SysUser findByUsername(String username);
  Set<String> findRoles(String username);
  Set<String> findPermissions(String username);
}
