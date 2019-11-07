package com.example.hrserver.dao;/**
 * @author ljt
 * @Title: MenuMapper
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/7 16:26
 */

import com.example.hrserver.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 * @description
 * @date 2019/11/7
 *
 */
@Repository
public interface MenuMapper {
  List<Menu> getAllMenu();
}
