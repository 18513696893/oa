package org.fkit.oa.identity.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.Reference;


@Entity
@Table(name="OA_ID_ROLE")
public class Role implements Serializable{
	
	private static final long serialVersionUID=6837526111700641932L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@Column(name="NAME",length=50)
	private String name;
	
	@Column(name="REMARK",length=500)
	private String remark;
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=User.class)
	@JoinColumn(name="CREATER",referencedColumnName="USER_ID",foreignKey=@ForeignKey(name="FK_ROLE_CREATER"))
	private User creater;
	
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "MODIFIER", referencedColumnName = "USER_ID",
            foreignKey=@ForeignKey(name = "FK_ROLE_MODIFIER"))
    private User modifier;
	
	@Column(name = "MODIFY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyData;
	
	@ManyToMany(fetch=FetchType.LAZY,targetEntity=Role.class)
	@JoinTable(name="OA_IA_USER_ROLE",joinColumns=@JoinColumn(name="ROLE_ID",referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="USER_ID",referencedColumnName="USER_ID"))
	private Set<User> users = new HashSet<>();

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
 	
	
}
