package com.example.hrserver.service;/**
 * @author ljt
 * @Title: HrService
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/7 15:57
 */

import com.example.hrserver.dao.HrMapper;
import com.example.hrserver.entity.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author
 * @description
 * @date 2019/11/7
 *
 */
public class HrService implements UserDetailsService {

  @Autowired
  private HrMapper hrMapper;
  @Override
  public UserDetails loadUserByUsername(String usernmae) throws UsernameNotFoundException {

    Hr hr = hrMapper.loadUserByUsername(usernmae);
    if (hr == null){
      throw new UsernameNotFoundException("用户不存在！");
    }
    return hr;
  }
}
