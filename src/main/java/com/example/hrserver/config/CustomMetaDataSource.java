package com.example.hrserver.config;/**
 * @author ljt
 * @Title: CustomMetaDataSource
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/7 16:18
 */

import com.example.hrserver.entity.Menu;
import com.example.hrserver.entity.Role;
import com.example.hrserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author
 * @description
 * @date 2019/11/7
 *
 */
@Component
public class CustomMetaDataSource implements FilterInvocationSecurityMetadataSource {

  @Autowired
  private MenuService menuService;
  AntPathMatcher antPathMatcher = new AntPathMatcher();

/*  public static void main(String[] args) {
    Collection<String> test = new ArrayList<>();
    test.add("qqqq");
    test.add("wwww");
    test.add("eeee");
    System.out.println(test.toString());
  }*/

  @Override
  public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

    String requestUrl = ((FilterInvocation) o).getRequestUrl();
    System.out.println("=====>requestUrl:"+requestUrl);
    List<Menu> allMenu = menuService.getAllMenu();
    System.out.println("=====>allMenu:"+allMenu.toString());

    for (Menu menu : allMenu) {
      if (antPathMatcher.match(menu.getUrl(),requestUrl) && menu.getRoles().size() >0 ){
        System.out.println("测试！！！");
        List<Role> roles = menu.getRoles();
        int size = roles.size();

        String[] values = new String[size];
        for (int i=0; i<size; i++){
          values[i] = roles.get(i).getName();
          System.out.println("values["+i+"]:"+roles.get(i).getName());
        }

        return SecurityConfig.createList(values);
      }
    }
    return SecurityConfig.createList("ROLE_LOGIN");
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return FilterInvocation.class.isAssignableFrom(aClass);
  }
}
