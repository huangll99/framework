package com.hll.service;

import com.hll.model.SysResource;

import java.util.List;
import java.util.Set;

/**
 * Created by hll on 2016/7/18.
 */
public interface ResourceService {
  Set<String> findPermissons(Set<Long> resourceIds);
  List<SysResource> findMenus(Set<String> permissions);
}
