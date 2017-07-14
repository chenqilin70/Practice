package com.mysql.shopping.model.bean;

import java.io.Serializable;
import java.util.Set;

public class order implements  Serializable{
private String oid;
private Set<Orderitems> prm;
private String te;
private String pe;
private float tot;
private String ti;
private int st;
private Address ad;
public String getOid() {
	return oid;
}
public void setOid(String oid) {
	this.oid = oid;
}
public Set<Orderitems> getPrm() {
	return prm;
}
public void setPrm(Set<Orderitems> prm) {
	this.prm = prm;
}
public String getTe() {
	return te;
}
public void setTe(String te) {
	this.te = te;
}
public String getPe() {
	return pe;
}
public void setPe(String pe) {
	this.pe = pe;
}
public float getTot() {
	return tot;
}
public void setTot(float tot) {
	this.tot = tot;
}
public String getTi() {
	return ti;
}
public void setTi(String ti) {
	this.ti = ti;
}

public Address getAd() {
	return ad;
}
public void setAd(Address ad) {
	this.ad = ad;
}
public int getSt() {
	return st;
}
public void setSt(int st) {
	this.st = st;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ad == null) ? 0 : ad.hashCode());
	result = prime * result + ((oid == null) ? 0 : oid.hashCode());
	result = prime * result + ((pe == null) ? 0 : pe.hashCode());
	result = prime * result + ((prm == null) ? 0 : prm.hashCode());
	result = prime * result + st;
	result = prime * result + ((te == null) ? 0 : te.hashCode());
	result = prime * result + ((ti == null) ? 0 : ti.hashCode());
	result = prime * result + Float.floatToIntBits(tot);
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
	order other = (order) obj;
	if (ad == null) {
		if (other.ad != null)
			return false;
	} else if (!ad.equals(other.ad))
		return false;
	if (oid == null) {
		if (other.oid != null)
			return false;
	} else if (!oid.equals(other.oid))
		return false;
	if (pe == null) {
		if (other.pe != null)
			return false;
	} else if (!pe.equals(other.pe))
		return false;
	if (prm == null) {
		if (other.prm != null)
			return false;
	} else if (!prm.equals(other.prm))
		return false;
	if (st != other.st)
		return false;
	if (te == null) {
		if (other.te != null)
			return false;
	} else if (!te.equals(other.te))
		return false;
	if (ti == null) {
		if (other.ti != null)
			return false;
	} else if (!ti.equals(other.ti))
		return false;
	if (Float.floatToIntBits(tot) != Float.floatToIntBits(other.tot))
		return false;
	return true;
}
@Override
public String toString() {
	return "order [oid=" + oid + ", prm=" + prm + ", te=" + te + ", pe=" + pe + ", tot=" + tot + ", ti=" + ti + ", st="
			+ st + ", ad=" + ad + "]";
}
public order(String oid, Set<Orderitems> prm, String te, String pe, float tot, String ti, int st, Address ad) {
	super();
	this.oid = oid;
	this.prm = prm;
	this.te = te;
	this.pe = pe;
	this.tot = tot;
	this.ti = ti;
	this.st = st;
	this.ad = ad;
}
public order() {
	super();
	// TODO Auto-generated constructor stub
}


}
