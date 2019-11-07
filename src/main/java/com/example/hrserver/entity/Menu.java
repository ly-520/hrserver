package com.example.hrserver.entity;/**
 * @author ljt
 * @Title: Menu
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/7 16:23
 */

import lombok.Data;

import java.util.List;

/**
 * @author
 * @description
 * @date 2019/11/7
 *
 */
@Data
public class Menu {
  private int id;
  private String url;
  private String path;
  private String component;
  private String name;
  private String iconCls;
  private int keepAlive;
  private int requireAuth;
  private int parentId;
  private int enabled;
  private List<Role> roles;
}
