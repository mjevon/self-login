package cn.leon.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

 private static final long serialVersionUID = 1L;

 private int id;
 private String name;
 private String loginName;
 private String password;
 private String email;

 public void setid(int id) {
  this.id = id;
 }

 public int getid() {
  return this.id;
 }

 public void setname(String name) {
  this.name = name;
 }

 public String getname() {
  return this.name;
 }

 public void setloginName(String loginName) {
  this.loginName = loginName;
 }

 public String getloginName() {
  return this.loginName;
 }

 public void setpassword(String password) {
  this.password = password;
 }

 public String getpassword() {
  return this.password;
 }

 public void setemail(String email) {
  this.email = email;
 }

 public String getemail() {
  return this.email;
 }
}

