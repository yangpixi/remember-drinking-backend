package com.yangpixi.rememberdrinkingbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpixi.rememberdrinkingbackend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author yangpixi
 * @date 2026/1/1 12:17
 * @description
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM t_user WHERE username = #{username};")
    User selectByUsername(String username);

    @Update("UPDATE t_user SET avatar = #{avatarPath} WHERE id = #{id};")
    Integer updateAvatarById(String avatarPath, Long id);
}
