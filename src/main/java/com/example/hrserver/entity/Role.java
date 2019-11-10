package com.example.hrserver.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ljt
 * @Title: Role
 * @ProjectName hrserver
 * @Description:
 * @Version:
 * @date 2019/11/4 17:40
 */
@Data
public class Role implements Serializable {

  private Integer id;
  private String name;
  private String nameZh;
}
