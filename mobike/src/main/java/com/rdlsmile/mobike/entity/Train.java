/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rdlsmile.mobike.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * qEntity
 * @author q
 * @version 2017-09-09
 */
public class Train implements Serializable{
	
	private static final long serialVersionUID = -355806558776873328L;
	
	private String orderid;		// orderid
	private String userid;		// userid
	private String bikeid;		// bikeid
	private String biketype;		// biketype
	private Date starttime;		// starttime
	private String startloc;		// startloc
	private String endloc;
	
	
	public String getEndloc() {
		return endloc;
	}

	public void setEndloc(String endloc) {
		this.endloc = endloc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getBikeid() {
		return bikeid;
	}

	public void setBikeid(String bikeid) {
		this.bikeid = bikeid;
	}
	
	public String getBiketype() {
		return biketype;
	}

	public void setBiketype(String biketype) {
		this.biketype = biketype;
	}
	
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	public String getStartloc() {
		return startloc;
	}

	public void setStartloc(String startloc) {
		this.startloc = startloc;
	}

	@Override
	public String toString() {
		return "train [orderid=" + orderid + ", userid=" + userid + ", bikeid=" + bikeid + ", biketype=" + biketype
				+ ", starttime=" + starttime + ", startloc=" + startloc + ", endloc=" + endloc + "]";
	}

	

	
	
}