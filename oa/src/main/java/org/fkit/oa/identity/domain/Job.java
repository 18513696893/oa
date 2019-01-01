package org.fkit.oa.identity.domain;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "OA_ID_JOB")
public class Job implements Serializable{
	
	private static final long serialVersionUID=459497377750274376L;
	
	@Id
	@Column(name="CODE",length=100)
	private String code;
	
	@Column(name="NAME",length=50)
	private String name;
	
	@Column(name="REMARK",length=300)
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
