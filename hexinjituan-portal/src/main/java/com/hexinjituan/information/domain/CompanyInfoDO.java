package com.hexinjituan.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 就业公司表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-05-27 17:12:49
 */
public class CompanyInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private Integer id;
	//公司或机构名称
	private String companyName;
	//公司介绍
	private String companyContent;
	//公司地址
	private String address;
	//联系电话
	private String phone;
	//负责人微信
	private String weixin;
	//负责人姓名
	private String principal;
	private List<CompanyGongchengDO> list = new ArrayList<CompanyGongchengDO>();

	public List<CompanyGongchengDO> getList() {
		return list;
	}

	public void setList(List<CompanyGongchengDO> list) {
		this.list = list;
	}

	public String getIfJianjie() {
		return ifJianjie;
	}

	public void setIfJianjie(String ifJianjie) {
		this.ifJianjie = ifJianjie;
	}

	private String ifJianjie;

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	//0  未删除     1  已删除
	private Integer deleted;
	//修改时间
	private Date updateTime;
	//发布时间
	private Date createTime;
	//创建者
	private Long userId;
	//url地址
	private String url;
	//图片
	private MultipartFile imgFile;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
	 * 设置：公司或机构名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取：公司或机构名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置：公司介绍
	 */
	public void setCompanyContent(String companyContent) {
		this.companyContent = companyContent;
	}

	/**
	 * 获取：公司介绍
	 */
	public String getCompanyContent() {
		return companyContent;
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
	 * 设置：创建者
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取：创建者
	 */
	public Long getUserId() {
		return userId;
	}
}

