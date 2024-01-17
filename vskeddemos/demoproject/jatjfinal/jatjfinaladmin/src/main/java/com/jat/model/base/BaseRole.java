package com.jat.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseRole<M extends BaseRole<M>> extends Model<M> implements IBean {

	/**
	 * 角色编号
	 */
	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	/**
	 * 角色编号
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}
	
	/**
	 * 角色名称
	 */
	public M setName(java.lang.String name) {
		set("name", name);
		return (M)this;
	}
	
	/**
	 * 角色名称
	 */
	public java.lang.String getName() {
		return getStr("name");
	}
	
	/**
	 * 角色描述
	 */
	public M setDescript(java.lang.String descript) {
		set("descript", descript);
		return (M)this;
	}
	
	/**
	 * 角色描述
	 */
	public java.lang.String getDescript() {
		return getStr("descript");
	}
	
	/**
	 * 0表示有效  1表示无效
	 */
	public M setIsDel(java.lang.Integer isDel) {
		set("isDel", isDel);
		return (M)this;
	}
	
	/**
	 * 0表示有效  1表示无效
	 */
	public java.lang.Integer getIsDel() {
		return getInt("isDel");
	}
	
}

