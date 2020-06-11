package com.hexinjituan.carousel.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

public class BannerDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	//0=店面图 1=公司活动图 2=家政保洁图 3=人力资源图 4=劳务合作社图 5=送技术下乡图 6=一人就业  全家安心
	private int type;//广告名称代号
	private String typeName;//广告名称
	//状态   0=启用  1=禁用
	private int isEnable;//启用状态
	private String url;//图片地址
	private Date addTime;//添加时间
	private Date updateTime;//修改时间
	private Long userId;	//添加人
	private Integer sort; //图片顺序
	private MultipartFile imgFile;
	//0=未删除  1=已删除
	private Integer deleteFlag;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	public String getTypeName() {
		return typeName;
	}

	public Integer getDeleteFlag() { return deleteFlag; }

	public void setDeleteFlag(Integer deleteFlag) { this.deleteFlag = deleteFlag; }

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
