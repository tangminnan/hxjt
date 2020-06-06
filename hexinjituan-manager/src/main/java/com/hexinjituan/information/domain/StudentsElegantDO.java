package com.hexinjituan.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;



/**
 * 学员风采
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-02 10:21:35
 */
public class StudentsElegantDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//类型
	private String typeName;
	//启用状态 0：是；1：否
	private Integer isEnable;
	//添加时间
	private Date addTime;
	//修改时间
	private Date updateTime;
	//添加人
	private Long userId;
	//地址
	private String url;
	//轮播顺序
	private Integer sort;
	//0=未删除   1=已删除
	private Integer deleteFlag;
	private MultipartFile imgFile;

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：类型
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：类型
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：启用状态 0：是；1：否
	 */
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	/**
	 * 获取：启用状态 0：是；1：否
	 */
	public Integer getIsEnable() {
		return isEnable;
	}
	/**
	 * 设置：添加时间
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：添加人
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：添加人
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：轮播顺序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：轮播顺序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：0=未删除   1=已删除
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	/**
	 * 获取：0=未删除   1=已删除
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
}
