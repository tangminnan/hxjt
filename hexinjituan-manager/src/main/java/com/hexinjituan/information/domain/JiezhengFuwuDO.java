package com.hexinjituan.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 家政服务表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 20:22:37
 */
public class JiezhengFuwuDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//0  未删除     1  已删除
	private Integer deleted;
	//修改时间
	private Date updateTime;
	//发布时间
	private Date createTime;
	//服务名称
	private String fuwuName;
	//内容描述
	private String gongchengContent;
	//图片展示地址
	private String url;
	//内容详情
	private String gongchengDetail;
	//图片列表
	private String iurl;
	//SHOUYE=首页
	private String leixing;
	private MultipartFile imgFile;
	private List<MultipartFile> imgFileList;

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
	 * 设置：服务名称
	 */
	public void setFuwuName(String fuwuName) {
		this.fuwuName = fuwuName;
	}
	/**
	 * 获取：服务名称
	 */
	public String getFuwuName() {
		return fuwuName;
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
	/**
	 * 设置：图片列表
	 */
	public void setIurl(String iurl) {
		this.iurl = iurl;
	}
	/**
	 * 获取：图片列表
	 */
	public String getIurl() {
		return iurl;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	public List<MultipartFile> getImgFileList() {
		return imgFileList;
	}

	public void setImgFileList(List<MultipartFile> imgFileList) {
		this.imgFileList = imgFileList;
	}
}
