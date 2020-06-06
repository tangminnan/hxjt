package com.hexinjituan.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;



/**
 * 慈善公益表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-01 16:08:42
 */
public class CompanyGongyiDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//名称
	private String gongyiClass;
	//0  未删除     1  已删除
	private Integer deleted;
	//
	private Date updateTime;
	//发布时间
	private Date createTime;
	//业务名字
	private String gongchengName;
	private String gongchengJ;

	public String getGongchengJ() {
		return gongchengJ;
	}

	public void setGongchengJ(String gongchengJ) {
		this.gongchengJ = gongchengJ;
	}

	//详情
	private String gongchengContent;
	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}


	//图片展示地址
	private String url;
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
	 * 设置：名称
	 */
	public void setGongyiClass(String gongyiClass) {
		this.gongyiClass = gongyiClass;
	}
	/**
	 * 获取：名称
	 */
	public String getGongyiClass() {
		return gongyiClass;
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
	 * 设置：业务名字
	 */
	public void setGongchengName(String gongchengName) {
		this.gongchengName = gongchengName;
	}
	/**
	 * 获取：业务名字
	 */
	public String getGongchengName() {
		return gongchengName;
	}
	/**
	 * 设置：内容描述
	 */
	public void setGongchengContent(String gongchengContent) {
		this.gongchengContent = gongchengContent;
	}
	/**
	 * 获取：内容描述
	 */
	public String getGongchengContent() {
		return gongchengContent;
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
}
