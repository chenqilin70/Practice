package com.mysql.shopping.admin.bean;

import java.io.Serializable;

public class Notice implements Serializable{

	private String notice;
	private String honor;
	private String best;
	private String date;
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getHonor() {
		return honor;
	}
	public void setHonor(String honor) {
		this.honor = honor;
	}
	public String getBest() {
		return best;
	}
	public void setBest(String best) {
		this.best = best;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Notice [notice=" + notice + ", honor=" + honor + ", best=" + best + ", date=" + date + "]";
	}
	public Notice(String notice, String honor, String best, String date) {
		super();
		this.notice = notice;
		this.honor = honor;
		this.best = best;
		this.date = date;
	}
	public Notice() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((best == null) ? 0 : best.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((honor == null) ? 0 : honor.hashCode());
		result = prime * result + ((notice == null) ? 0 : notice.hashCode());
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
		Notice other = (Notice) obj;
		if (best == null) {
			if (other.best != null)
				return false;
		} else if (!best.equals(other.best))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (honor == null) {
			if (other.honor != null)
				return false;
		} else if (!honor.equals(other.honor))
			return false;
		if (notice == null) {
			if (other.notice != null)
				return false;
		} else if (!notice.equals(other.notice))
			return false;
		return true;
	}
	
	
}
