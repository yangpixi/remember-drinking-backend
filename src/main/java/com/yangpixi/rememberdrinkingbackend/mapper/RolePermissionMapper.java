package com.yangpixi.rememberdrinkingbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpixi.rememberdrinkingbackend.entity.Permission;
import com.yangpixi.rememberdrinkingbackend.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yangpixi
 * @date 2026/1/1 12:18
 * @description
 */

@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    @Select("SELECT permission_id FROM t_role_permission WHERE role_id = #{roleId}")
    List<Long> selectAllByRoleId(Long roleId);
}
