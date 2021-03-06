package admin.com.oracle.model.bean;


public class Product {
	private int productid;
	private String name;
	private String brand;
	private String seris;
	private String type;
	private String description;
	private String basicprice;
	private int typeid;
	private String image;
	
	public Product(int productid, String name, String brand, String seris, String type, String description,
			String basicprice, int typeid, String image) {
		super();
		this.productid = productid;
		this.name = name;
		this.brand = brand;
		this.seris = seris;
		this.type = type;
		this.description = description;
		this.basicprice = basicprice;
		this.typeid = typeid;
		this.image = image;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", brand=" + brand + ", seris=" + seris
				+ ", type=" + type + ", description=" + description + ", basicprice=" + basicprice + ", typeid="
				+ typeid + ", image=" + image + "]";
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBasicprice() {
		return basicprice;
	}
	public void setBasicprice(String basicprice) {
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
		result = prime * result + ((basicprice == null) ? 0 : basicprice.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + productid;
		result = prime * result + ((seris == null) ? 0 : seris.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + typeid;
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
		Product other = (Product) obj;
		if (basicprice == null) {
			if (other.basicprice != null)
				return false;
		} else if (!basicprice.equals(other.basicprice))
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeid != other.typeid)
			return false;
		return true;
	}

	
}
