package com.hexinjituan.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 人力资源表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-11 17:30:27
 */
public class RespurcesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//0  未删除     1  已删除
	private Integer deleted;
	//
	private Date updateTime;
	//发布时间
	private Date createTime;
	//人力资源顶部logo
	private String url;
	//人力资源规划内容
	private String renliGuihua;
	//人力资源规划（图片拼接）
	private String iurl;
	//劳务派遣内容
	private String laowuPaiquan;
	//人力资源规划列表图
	private List<MultipartFile> imgFileList;
	//顶部logo
	private MultipartFile imgFile;

	public List<MultipartFile> getImgFileList() {
		return imgFileList;
	}

	public void setImgFileList(List<MultipartFile> imgFileList) {
		this.imgFileList = imgFileList;
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
	 * 设置：人力资源顶部logo
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：人力资源顶部logo
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：人力资源规划内容
	 */
	public void setRenliGuihua(String renliGuihua) {
		this.renliGuihua = renliGuihua;
	}
	/**
	 * 获取：人力资源规划内容
	 */
	public String getRenliGuihua() {
		return renliGuihua;
	}
	/**
	 * 设置：人力资源规划（图片拼接）
	 */
	public void setIurl(String iurl) {
		this.iurl = iurl;
	}
	/**
	 * 获取：人力资源规划（图片拼接）
	 */
	public String getIurl() {
		return iurl;
	}
	/**
	 * 设置：劳务派遣内容
	 */
	public void setLaowuPaiquan(String laowuPaiquan) {
		this.laowuPaiquan = laowuPaiquan;
	}
	/**
	 * 获取：劳务派遣内容
	 */
	public String getLaowuPaiquan() {
		return laowuPaiquan;
	}
}
