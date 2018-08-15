package cn.leon.bo;

import java.io.Serializable;

public class RoleBo implements Serializable {

 private static final long serialVersionUID = 1L;

 private int id;
 private String role;
 private String name;
 private String modules;
 private String describe;

 public void setid(int id) {
  this.id = id;
 }

 public int getid() {
  return this.id;
 }

 public void setrole(String role) {
  this.role = role;
 }

 public String getrole() {
  return this.role;
 }

 public void setname(String name) {
  this.name = name;
 }

 public String getname() {
  return this.name;
 }

 public void setmodules(String modules) {
  this.modules = modules;
 }

 public String getmodules() {
  return this.modules;
 }

 public void setdescribe(String describe) {
  this.describe = describe;
 }

 public String getdescribe() {
  return this.describe;
 }
}

