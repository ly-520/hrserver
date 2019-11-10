package com.example.hrserver.service;/**
 * @author ljt
 * @Title: MenuService
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/7 16:19
 */

import com.example.hrserver.entity.Menu;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MenuService {
    List<Menu> getAllMenu();
}
