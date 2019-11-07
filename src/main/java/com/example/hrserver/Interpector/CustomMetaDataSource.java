package com.example.hrserver.Interpector;/**
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

  @Override
  public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

    String requestUrl = ((FilterInvocation) o).getRequestUrl();
    List<Menu> allMenu = menuService.getAllMenu();
    for (Menu menu : allMenu) {
      if (antPathMatcher.match(menu.getUrl(),requestUrl) && menu.getRoles().size() >0 ){
        List<Role> roles = menu.getRoles();
        int size = roles.size();
        String[] values = new String[size];
        for (int i=0; i<size; i++){
          values[i] = roles.get(i).getName();
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
