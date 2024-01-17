package com.jat.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseRoleResource<M extends BaseRoleResource<M>> extends Model<M> implements IBean {

	public M setRoleId(java.lang.Integer roleId) {
		set("roleId", roleId);
		return (M)this;
	}
	
	public java.lang.Integer getRoleId() {
		return getInt("roleId");
	}
	
	public M setResId(java.lang.Integer resId) {
		set("resId", resId);
		return (M)this;
	}
	
	public java.lang.Integer getResId() {
		return getInt("resId");
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

