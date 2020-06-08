package com.hexinjituan.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 劳务案例分裂表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 11:24:45
 */
public class LaowuAnliCateDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//0  未删除     1  已删除
	private Integer deleted;
	//
	private Date updateTime;
	//发布时间
	private Date createTime;
	//分类标题
	private String title;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：0  未删除     1  已删除
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：0  未删除     1  已删除
	 */
	public Integer getDeleted() {
		return deleted;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：发布时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：分类标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：分类标题
	 */
	public String getTitle() {
		return title;
	}
}
