package com.mysql.shopping.model.bean;

public class Productimage {
	private int productid;
	private String path;
	private int enable;
	
	@Override
	public String toString() {
		return "Productimage [productid=" + productid + ", path=" + path + ", enable=" + enable + "]";
	}

	public Productimage(int productid, String path, int enable) {
		super();
		this.productid = productid;
		this.path = path;
		this.enable = enable;
	}

	public Productimage() {
		super();
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enable;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		Productimage other = (Productimage) obj;
		if (enable != other.enable)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (productid != other.productid)
			return false;
		return true;
	}

}
