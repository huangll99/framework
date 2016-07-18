package com.hll.dao;

import com.hll.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;
@Mapper
public interface SysUserMapper {
  int deleteByPrimaryKey(Long id);

  int insert(SysUser record);

  int insertSelective(SysUser record);

  SysUser selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(SysUser record);

  int updateByPrimaryKey(SysUser record);

  @Select("select * from sys_user where username=#{username}")
  SysUser findByUsername(String username);

  @Select("SELECT r.role FROM sys_user u JOIN sys_user_role ur ON u.id = ur.user_id JOIN sys_role r ON ur.role_id = r.id where u.username=#{username}")
  Set<String> findRoles(String username);

  @Select("SELECT res.permission FROM sys_user u JOIN sys_user_role ur ON u.id = ur.user_id JOIN sys_role r ON ur.role_id = r.id JOIN sys_role_resource rr ON r.id = rr.role_id JOIN sys_resource res ON rr.resource_id = res.id where u.username=#{username}")
  Set<String> findPermissions(String username);
}