package org.fkit.oa.identity.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="OA_ID_USER",indexes= {@Index(columnList="NAME",name="IDX_USER_NAME")})
public class User implements Serializable {
	
	@Id
	@Column(name="USER_ID",length=50)
	private String userId;
	
	@Column(name="PASS_WORD",length=50)
	private String passWord;
	
	@Column(name="NAME",length=50)
	private String name;
	/** ÄÐ£º1£¬Å®£º2*/
	@Column(name="SEX")
	private Short sex=1;
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=User.class)
	@JoinColumn(name="DEPT_ID",referencedColumnName="ID",foreignKey=@ForeignKey(name="FK_USER_DEPT"))
	private Dept dept;
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=User.class)
	@JoinColumn(name="JOB_CODE",referencedColumnName="CODE",foreignKey=@ForeignKey(name="FK_USER_JOB"))
	private Job job;
	
	@Column(name="EMAIL",length=50)
	private String email;
	
	@Column(name="TEL",length=50)
	private String tel;
	
	@Column(name="PHONE",length=50)
	private String phone;
	
	@Column(name="QQ_NUM",length=50)
	private String qqNum;
	
	@Column(name="QUESTION")
	private Short question;
	
	@Column(name="ANSWER",length=200)
	private String answer;
	
	@Column(name="STATUS")
	private Short status=0;
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=User.class)
	@JoinColumn(name="CREATER",referencedColumnName="USER_ID",foreignKey=@ForeignKey(name="FK_USER_CREATER"))
	private User creater;
	
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
    @JoinColumn(name = "MODIFIER", referencedColumnName = "USER_ID",
            foreignKey=@ForeignKey(name = "FK_USER_MODIFIER"))
    private User modifier;
	
	@Column(name = "MODIFY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyData;
    
    @JoinColumn(name = "CHECKER", referencedColumnName = "USER_ID",
            foreignKey=@ForeignKey(name = "FK_USER_CHECKER"))
    private User checker;
    
	@Column(name = "CHECKER_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkData;
    
	@ManyToMany(fetch=FetchType.LAZY,targetEntity=Role.class,mappedBy="users")
	private Set<Role> roles = new HashSet<>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQqNum() {
		return qqNum;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public Short getQuestion() {
		return question;
	}

	public void setQuestion(Short question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
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

	public User getChecker() {
		return checker;
	}

	public void setChecker(User checker) {
		this.checker = checker;
	}

	public Date getCheckData() {
		return checkData;
	}

	public void setCheckData(Date checkData) {
		this.checkData = checkData;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
    
}
