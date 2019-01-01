package org.fkit.oa.identity.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "OA_ID_DEPT")
public class Dept implements Serializable {

	private static final long serialVersionUID = 678100638005497362L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "REMARK", length = 500)
	private String remark;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "MODIFIER", referencedColumnName = "USER_ID",
            foreignKey=@ForeignKey(name = "FK_DEPT_MODIFIER"))
    private User modifier;
	@Column(name = "MODIFY_DATE")

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyData;

	@ManyToOne(fetch=FetchType.LAZY,targetEntity=User.class)
	@JoinColumn(name="CREATER",referencedColumnName="USER_ID",foreignKey=@ForeignKey(name="FK_DEPT_CREATER"))
	private User creater;
	
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public User getModifier() {
		return modifier;
	}

	public void setModifier(User modifier) {
		this.modifier = modifier;
	}

	public Date getModifyData() {
		return modifyData;
	}

	public void setModifyData(Date modifyData) {
		this.modifyData = modifyData;
	}

	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
