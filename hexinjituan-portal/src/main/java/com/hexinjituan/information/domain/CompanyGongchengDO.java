package com.hexinjituan.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 业务工程表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-01 13:39:38
 */
public class CompanyGongchengDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//负责人微信
	private String weixin;
	//负责人联系电话
	private String phone;
	//负责人姓名
	private String principal;
	//所属公司id
	private Long companyId;
	//业务名称
	private String gongchengClass;
	//0  未删除     1  已删除
	private Integer deleted;
	//
	private Date updateTime;
	//发布时间
	private Date createTime;
	//业务名字
	private String gongchengName;
	//简介
	private String gongchengContent;
	//详细内容
	private String gongchengDetail;

	//图片展示地址
	private String url;
	//图片展示地址
	private String iurl;
	private List<MultipartFile> imgFileList;
	private MultipartFile imgFile;

	public String getGongchengDetail() {
		return gongchengDetail;
	}

	public void setGongchengDetail(String gongchengDetail) {
		this.gongchengDetail = gongchengDetail;
	}

	public List<MultipartFile> getImgFileList() {
		return imgFileList;
	}

	public void setImgFileList(List<MultipartFile> imgFileList) {
		this.imgFileList = imgFileList;
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
	 * 设置：所属公司id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：所属公司id
	 */
	public Long getCompanyId() {
		return companyId;
	}
	/**
	 * 设置：业务名称
	 */
	public void setGongchengClass(String gongchengClass) {
		this.gongchengClass = gongchengClass;
	}
	/**
	 * 获取：业务名称
	 */
	public String getGongchengClass() {
		return gongchengClass;
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

	public String getIurl() {
		return iurl;
	}

	public void setIurl(String iurl) {
		this.iurl = iurl;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
}
