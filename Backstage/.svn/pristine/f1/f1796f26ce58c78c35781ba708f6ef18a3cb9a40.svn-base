package com.mysql.shopping.model.bean;

public class Orderitems {
	
	private int orderitemid;
	private int count;
	private float discount;
	private String orderid;
	private int productid;
	
	@Override
	public String toString() {
		return "Orderitems [orderitemid=" + orderitemid + ", count=" + count + ", discount=" + discount + ", orderid="
				+ orderid + ", productid=" + productid + "]";
	}

	public Orderitems(int orderitemid, int count, float discount, String orderid, int productid) {
		super();
		this.orderitemid = orderitemid;
		this.count = count;
		this.discount = discount;
		this.orderid = orderid;
		this.productid = productid;
	}

	public Orderitems() {
		super();
	}

	public int getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + Float.floatToIntBits(discount);
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + orderitemid;
		result = prime * result + productid;
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
		Orderitems other = (Orderitems) obj;
		if (count != other.count)
			return false;
		if (Float.floatToIntBits(discount) != Float.floatToIntBits(other.discount))
			return false;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		if (orderitemid != other.orderitemid)
			return false;
		if (productid != other.productid)
			return false;
		return true;
	}
	
}
