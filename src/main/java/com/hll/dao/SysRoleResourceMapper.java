package com.hll.dao;

import com.hll.model.SysRoleResource;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleResourceMapper {
    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);
}