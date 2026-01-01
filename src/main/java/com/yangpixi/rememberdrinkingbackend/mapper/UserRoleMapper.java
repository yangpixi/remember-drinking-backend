package com.yangpixi.rememberdrinkingbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpixi.rememberdrinkingbackend.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yangpixi
 * @date 2026/1/1 12:19
 * @description
 */

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
    @Select("SELECT role_id FROM t_user_role WHERE user_id = #{userId}")
    List<Long> selectByUserId(Long userId);
}
