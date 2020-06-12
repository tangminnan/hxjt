package com.hexinjituan.information.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 招聘表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 14:10:07
 */
public class ZhaoxianDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//0  未删除     1  已删除
	private Integer deleted;
	//
	private Date updateTime;
	//发布时间
	private Date createTime;
	//招聘标题
	private String title;
	//具体内容
	private String content;
	//招聘电话1
	private String phoneF;
	//招聘电话2
	private String phoneS;

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
	 * 设置：招聘标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：招聘标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：具体内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：具体内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：招聘电话1
	 */
	public void setPhoneF(String phoneF) {
		this.phoneF = phoneF;
	}
	/**
	 * 获取：招聘电话1
	 */
	public String getPhoneF() {
		return phoneF;
	}
	/**
	 * 设置：招聘电话2
	 */
	public void setPhoneS(String phoneS) {
		this.phoneS = phoneS;
	}
	/**
	 * 获取：招聘电话2
	 */
	public String getPhoneS() {
		return phoneS;
	}
}
