package com.hexinjituan.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;


/**
 * 直营加盟店铺
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 16:56:43
 */
public class JiamengStoreDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//名称
	private String jiamengName;
	//类型
	private String jiamengType;
	//电话
	private String jiamengPhone;
	//地址
	private String jiamengAddress;
	private String QQ;
	private String weixin;

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String QQ) {
		this.QQ = QQ;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	//图片展示地址
	private String url;
	//0  未删除     1  已删除
	private Integer deleted;
	//
	private Date updateTime;
	//发布时间
	private Date createTime;
	//图片
	private MultipartFile imgFile;

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

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
	public void setJiamengName(String jiamengName) {
		this.jiamengName = jiamengName;
	}
	/**
	 * 获取：名称
	 */
	public String getJiamengName() {
		return jiamengName;
	}
	/**
	 * 设置：类型
	 */
	public void setJiamengType(String jiamengType) {
		this.jiamengType = jiamengType;
	}
	/**
	 * 获取：类型
	 */
	public String getJiamengType() {
		return jiamengType;
	}
	/**
	 * 设置：电话
	 */
	public void setJiamengPhone(String jiamengPhone) {
		this.jiamengPhone = jiamengPhone;
	}
	/**
	 * 获取：电话
	 */
	public String getJiamengPhone() {
		return jiamengPhone;
	}
	/**
	 * 设置：地址
	 */
	public void setJiamengAddress(String jiamengAddress) {
		this.jiamengAddress = jiamengAddress;
	}
	/**
	 * 获取：地址
	 */
	public String getJiamengAddress() {
		return jiamengAddress;
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
}
