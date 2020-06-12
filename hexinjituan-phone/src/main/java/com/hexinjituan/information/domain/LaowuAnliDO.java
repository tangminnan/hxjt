package com.hexinjituan.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;


/**
 * 劳务案例表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 09:59:57
 */
public class LaowuAnliDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//0  未删除     1  已删除
	private Integer deleted;
	private Integer cateId;

	private Date updateTime;
	//发布时间
	private Date createTime;
	//标题
	private String laowuTitle;
	//详情
	private String laowuContent;
	//图片展示地址
	private String url;
	//列表简介
	private String gongchengJ;
	//图片
	private MultipartFile imgFile;

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
	 * 设置：标题
	 */
	public void setLaowuTitle(String laowuTitle) {
		this.laowuTitle = laowuTitle;
	}
	/**
	 * 获取：标题
	 */
	public String getLaowuTitle() {
		return laowuTitle;
	}
	/**
	 * 设置：详情
	 */
	public void setLaowuContent(String laowuContent) {
		this.laowuContent = laowuContent;
	}
	/**
	 * 获取：详情
	 */
	public String getLaowuContent() {
		return laowuContent;
	}
	/**
	 * 设置：图片展示地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：图片展示地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：列表简介
	 */
	public void setGongchengJ(String gongchengJ) {
		this.gongchengJ = gongchengJ;
	}
	/**
	 * 获取：列表简介
	 */
	public String getGongchengJ() {
		return gongchengJ;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}
}
