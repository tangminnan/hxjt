package com.hexinjituan.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;


/**
 * 合作社分社
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-06 20:04:23
 */
public class HezuosheDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//负责人微信
	private String weixin;
	//负责人联系电话
	private String phone;
	//负责人姓名
	private String principal;
	//标题
	private String title;
	//0  未删除     1  已删除
	private Integer deleted;
	//
	private Date updateTime;
	//发布时间
	private Date createTime;
	//内容描述
	private String gongchengContent;
	//图片展示地址
	private String url;
	//内容详情
	private String gongchengDetail;
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
	 * 设置：负责人微信
	 */
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	/**
	 * 获取：负责人微信
	 */
	public String getWeixin() {
		return weixin;
	}
	/**
	 * 设置：负责人联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：负责人联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：负责人姓名
	 */
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	/**
	 * 获取：负责人姓名
	 */
	public String getPrincipal() {
		return principal;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
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
	/**
	 * 设置：内容详情
	 */
	public void setGongchengDetail(String gongchengDetail) {
		this.gongchengDetail = gongchengDetail;
	}
	/**
	 * 获取：内容详情
	 */
	public String getGongchengDetail() {
		return gongchengDetail;
	}
}
