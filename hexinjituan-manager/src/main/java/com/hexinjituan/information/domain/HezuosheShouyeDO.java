package com.hexinjituan.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 合作社首页编辑
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 15:15:13
 */
public class HezuosheShouyeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//合作社简介/加盟事项说明
	private String hezuosheJianjie;
	//定向培训/加盟程序
	private String dingxiangPeixun;
	//合作社案例/加盟条件
	private String hezuosheAnli;
	//合作社 HEZUOSHE_SHOUYE=合作社首页内容   JIAMENG=合作加盟首页内容
	private String type;
	//资料支持
	private String ziliaoZhichi;

	public String getZiliaoZhichi() {
		return ziliaoZhichi;
	}

	public void setZiliaoZhichi(String ziliaoZhichi) {
		this.ziliaoZhichi = ziliaoZhichi;
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
	 * 设置：合作社简介
	 */
	public void setHezuosheJianjie(String hezuosheJianjie) {
		this.hezuosheJianjie = hezuosheJianjie;
	}
	/**
	 * 获取：合作社简介
	 */
	public String getHezuosheJianjie() {
		return hezuosheJianjie;
	}
	/**
	 * 设置：定向培训
	 */
	public void setDingxiangPeixun(String dingxiangPeixun) {
		this.dingxiangPeixun = dingxiangPeixun;
	}
	/**
	 * 获取：定向培训
	 */
	public String getDingxiangPeixun() {
		return dingxiangPeixun;
	}
	/**
	 * 设置：合作社案例
	 */
	public void setHezuosheAnli(String hezuosheAnli) {
		this.hezuosheAnli = hezuosheAnli;
	}
	/**
	 * 获取：合作社案例
	 */
	public String getHezuosheAnli() {
		return hezuosheAnli;
	}
	/**
	 * 设置：合作社
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：合作社
	 */
	public String getType() {
		return type;
	}
}
