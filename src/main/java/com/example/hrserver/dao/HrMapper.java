package com.example.hrserver.dao;

import com.example.hrserver.entity.Hr;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ljt
 * @Title: HrMapper
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/7 16:01
 */
@Repository
public interface HrMapper {
    Hr loadUserByUsername(@Param("username") String username);
}
