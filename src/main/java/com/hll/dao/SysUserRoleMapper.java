package com.hll.dao;

import com.hll.model.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}