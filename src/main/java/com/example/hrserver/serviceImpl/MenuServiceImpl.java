package com.example.hrserver.serviceImpl;/**
 * @author ljt
 * @Title: MenuServiceImpl
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/7 16:24
 */

import com.example.hrserver.dao.MenuMapper;
import com.example.hrserver.entity.Menu;
import com.example.hrserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author
 * @description
 * @date 2019/11/7
 *
 */
public class MenuServiceImpl implements MenuService {
  @Autowired
  private MenuMapper menuMapper;

  @Override
  public List<Menu> getAllMenu() {
    return menuMapper.getAllMenu();
  }
}
