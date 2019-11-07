package com.example.hrserver.service;/**
 * @author ljt
 * @Title: MenuService
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/7 16:19
 */

import com.example.hrserver.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description
 * @date 2019/11/7
 *
 */
@Service
public interface MenuService {
    List<Menu> getAllMenu();
}
