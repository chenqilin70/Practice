package admin.com.oracle.model.bean;

public class productPage {
	
	private int page;
	private int value;
	private int counts;
	private int nowpage;
	private int lastpage;
	private int nextpage;
	private int prexpage;
	private int firstpage;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public int getPrexpage() {
		return prexpage;
	}
	public void setPrexpage(int prexpage) {
		this.prexpage = prexpage;
	}
	public int getFirstpage() {
		return firstpage;
	}
	public void setFirstpage(int firstpage) {
		this.firstpage = firstpage;
	}
	public productPage(int page, int value, int counts, int nowpage, int lastpage, int nextpage, int prexpage,
			int firstpage) {
		super();
		this.page = page;
		this.value = value;
		this.counts = counts;
		this.nowpage = nowpage;
		this.lastpage = lastpage;
		this.nextpage = nextpage;
		this.prexpage = prexpage;
		this.firstpage = firstpage;
	}
	public productPage() {
		super();
	}
	@Override
	public String toString() {
		return "productPage [page=" + page + ", value=" + value + ", counts=" + counts + ", nowpage=" + nowpage
				+ ", lastpage=" + lastpage + ", nextpage=" + nextpage + ", prexpage=" + prexpage + ", firstpage="
				+ firstpage + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + counts;
		result = prime * result + firstpage;
		result = prime * result + lastpage;
		result = prime * result + nextpage;
		result = prime * result + nowpage;
		result = prime * result + page;
		result = prime * result + prexpage;
		result = prime * result + value;
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
		productPage other = (productPage) obj;
		if (counts != other.counts)
			return false;
		if (firstpage != other.firstpage)
			return false;
		if (lastpage != other.lastpage)
			return false;
		if (nextpage != other.nextpage)
			return false;
		if (nowpage != other.nowpage)
			return false;
		if (page != other.page)
			return false;
		if (prexpage != other.prexpage)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	

}
