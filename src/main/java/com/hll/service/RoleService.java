package com.hll.service;

import java.util.Set;

/**
 * Created by hll on 2016/7/18.
 */
public interface RoleService {

  Set<String> findRoles(Long... roleIds);
  Set<String> findPermissions(Long[] roleIds);
}
