package com.mysql.shopping.model.bean;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Orders implements  Serializable{
	
	private String orderid;
	private String time;
	private int  status;
	private int userid;
	private int  addressId;
	private String massage;
	private Address  add;
	private  Set<Orderitems>  items;
	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", time=" + time + ", status=" + status + ", userid=" + userid
				+ ", addressId=" + addressId + ", massage=" + massage + "]";
	}
	public Orders(String orderid, String time, int status, int userid, int addressId, String massage) {
		super();
		this.orderid = orderid;
		this.time = time;
		this.status = status;
		this.userid = userid;
		this.addressId = addressId;
		this.massage = massage;
	}
	public Orders() {
		super();
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + ((massage == null) ? 0 : massage.hashCode());
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + status;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + userid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (addressId != other.addressId)
			return false;
		if (massage == null) {
			if (other.massage != null)
				return false;
		} else if (!massage.equals(other.massage))
			return false;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		if (status != other.status)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public Set<Orderitems> getItems() {
		return items;
	}
	public void setItems(Set<Orderitems> items) {
		this.items = items;
	}
	
}
