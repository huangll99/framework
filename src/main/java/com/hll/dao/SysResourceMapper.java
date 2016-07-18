package com.hll.dao;

import com.hll.model.SysResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;
@Mapper
public interface SysResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

}