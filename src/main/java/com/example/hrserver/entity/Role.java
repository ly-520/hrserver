package com.example.hrserver.entity;/**
 * @author ljt
 * @Title: Role
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/4 17:40
 */

public class Role {
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNameAh() {
    return nameAh;
  }

  public void setNameAh(String nameAh) {
    this.nameAh = nameAh;
  }

  private Integer id;
  private String name;
  private String nameAh;
}
