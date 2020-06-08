package com.hexinjituan.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 留言表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 19:38:13
 */
public class LeaveMsgDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//0  未删除     1  已删除
	private Integer deleted;
	//发布时间
	private Date createTime;
	//姓名
	private String leaveName;
	//手机号
	private String phone;
	//
	private String content;

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
	 * 设置：姓名
	 */
	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}
	/**
	 * 获取：姓名
	 */
	public String getLeaveName() {
		return leaveName;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}
}
