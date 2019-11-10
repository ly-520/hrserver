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
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@CacheConfig(cacheNames = "menus_cache")
@Service
public class MenuServiceImpl implements MenuService {
  @Autowired
  private MenuMapper menuMapper;

  @Cacheable(key = "#root.methodName")
  @Override
  public List<Menu> getAllMenu() {
    return menuMapper.getAllMenu();
  }
}
