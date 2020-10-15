package com.kkk.mapper;

import com.kkk.model.Hr;
import com.kkk.model.Role;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr selectHrByUsername(String username);

    List<Role> getHrRolesById(Integer id);
}