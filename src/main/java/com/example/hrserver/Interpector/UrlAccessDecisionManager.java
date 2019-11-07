package com.example.hrserver.Interpector;/**
 * @author ljt
 * @Title: UrlAccessDecisionManager
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/7 16:46
 */

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author
 * @description
 * @date 2019/11/7
 *
 */
public class UrlAccessDecisionManager implements AccessDecisionManager {
  @Override
  public void decide(Authentication auth, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
    Iterator<ConfigAttribute> iterator = collection.iterator();
    while (iterator.hasNext()){
      ConfigAttribute ca = iterator.next();
      String needRole = ca.getAttribute();
      if ("ROLE_LOGIN".equals(needRole)){
        if (auth instanceof AnonymousAuthenticationToken){
          throw new BadCredentialsException("未登录");
        }else{
          return ;
        }
      }
      Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
      for (GrantedAuthority authority : authorities){
        if (authority.getAuthority().equals(needRole)){
          return ;
        }
      }
    }
    throw new AccessDeniedException("权限不足！");
  }

  @Override
  public boolean supports(ConfigAttribute configAttribute) {
    return true;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return true;
  }
}