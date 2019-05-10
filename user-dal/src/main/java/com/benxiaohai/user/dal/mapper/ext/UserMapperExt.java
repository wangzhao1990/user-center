package com.benxiaohai.user.dal.mapper.ext;

import com.benxiaohai.user.dal.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * UserMapper扩展
 *
 * @author wangzhao
 * @create 2019/5/9
 */
public interface UserMapperExt {

    User selectByNameAndPwd(@Param("name") String name,@Param("password") String password);

}
