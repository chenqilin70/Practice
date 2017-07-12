package com.mysql.shopping.model.bean;

public class Goods {
	private int productid;
	private String name;
	private String brand;
	private String seris;
	private String description;
	private float basicprice;
	private int typeid;
	private String image;
	
	public Goods() {
		super();
	}

	public Goods(int productid, String name, String brand, String seris, String description, float basicprice,
			int typeid, String image) {
		super();
		this.productid = productid;
		this.name = name;
		this.brand = brand;
		this.seris = seris;
		this.description = description;
		this.basicprice = basicprice;
		this.typeid = typeid;
		this.image = image;
	}

	@Override
	public String toString() {
		return "{\"productid\":" + productid + ", \"name\":\"" + name + "\", \"brand\":\"" + brand + "\", \"seris\":\"" + seris
				+ "\", \"description\":\"" + description + "\", \"basicprice\":\"" + basicprice + "\", \"typeid\":\"" + typeid + "\", \"image\":\""
				+ image + "}";
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSeris() {
		return seris;
	}

	public void setSeris(String seris) {
		this.seris = seris;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getBasicprice() {
		return basicprice;
	}

	public void setBasicprice(float basicprice) {
		this.basicprice = basicprice;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(basicprice);
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + productid;
		result = prime * result + ((seris == null) ? 0 : seris.hashCode());
		result = prime * result + typeid;
		return result;
	}

	//重写hashset和equals方法来判断传进来的值或对象是否重复
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (Float.floatToIntBits(basicprice) != Float.floatToIntBits(other.basicprice))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productid != other.productid)
			return false;
		if (seris == null) {
			if (other.seris != null)
				return false;
		} else if (!seris.equals(other.seris))
			return false;
		if (typeid != other.typeid)
			return false;
		return true;
	}
	

}
