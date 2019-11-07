package com.example.hrserver.entity;/**
 * @author ljt
 * @Title: Hr
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/4 17:21
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author
 * @description
 * @date 2019/11/4
 *
 */
public class Hr implements UserDetails {

  private Long id;
  private String name;
  private String phone;
  private String telephone;
  private String address;
  private String enabled;
  private String username;
  private String password;
  private String remark;
  private List<Role> roles;
  private String userface;









  @JsonIgnore
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (Role role : roles){
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    }
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isEnabled() {
    return true;
  }
}
