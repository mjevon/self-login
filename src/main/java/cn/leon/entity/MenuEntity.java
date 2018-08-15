package cn.leon.entity;

import java.io.Serializable;

public class MenuEntity implements Serializable {

 private static final long serialVersionUID = 1L;

 private int id;
 private String name;
 private String url;
 private int parentId;
 private String sort;
 private String remark;
 private String icon;

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

 public void seturl(String url) {
  this.url = url;
 }

 public String geturl() {
  return this.url;
 }

 public void setparentId(int parentId) {
  this.parentId = parentId;
 }

 public int getparentId() {
  return this.parentId;
 }

 public void setsort(String sort) {
  this.sort = sort;
 }

 public String getsort() {
  return this.sort;
 }

 public void setremark(String remark) {
  this.remark = remark;
 }

 public String getremark() {
  return this.remark;
 }

 public void seticon(String icon) {
  this.icon = icon;
 }

 public String geticon() {
  return this.icon;
 }
}
