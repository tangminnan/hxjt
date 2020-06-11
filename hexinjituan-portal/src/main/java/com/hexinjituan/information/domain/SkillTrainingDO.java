package com.hexinjituan.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;


/**
 * 送技术下乡
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-02 14:22:56
 */
public class SkillTrainingDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//类型（JINGDIAN_ANLI=经典案例 PEIXUN_XIANGMU=培训项目 JISHU_XIAXIANG=技术下乡）
	private String trainingClass;
	//0  未删除     1  已删除
	private Integer deleted;
	//
	private Date updateTime;
	//发布时间
	private Date createTime;
	//标题
	private String trainingName;
	//内容描述
	private String trainingContent;
	//图片展示
	private String url;
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
	 * 设置：类型（JINGDIAN_ANLI=经典案例 PEIXUN_XIANGMU=培训项目）
	 */
	public void setTrainingClass(String trainingClass) {
		this.trainingClass = trainingClass;
	}
	/**
	 * 获取：类型（JINGDIAN_ANLI=经典案例 PEIXUN_XIANGMU=培训项目）
	 */
	public String getTrainingClass() {
		return trainingClass;
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
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	/**
	 * 获取：标题
	 */
	public String getTrainingName() {
		return trainingName;
	}
	/**
	 * 设置：内容描述
	 */
	public void setTrainingContent(String trainingContent) {
		this.trainingContent = trainingContent;
	}
	/**
	 * 获取：内容描述
	 */
	public String getTrainingContent() {
		return trainingContent;
	}
	/**
	 * 设置：图片展示
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：图片展示
	 */
	public String getUrl() {
		return url;
	}
}
