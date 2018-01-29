package cn.smbms.Entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户的类
 * 
 * @author Administrator
 * 
 */
public class Users {

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getIdPicPath() {
		return idPicPath;
	}

	public void setIdPicPath(String idPicPath) {
		this.idPicPath = idPicPath;
	}

	public String getWorkPicPath() {
		return workPicPath;
	}

	public void setWorkPicPath(String workPicPath) {
		this.workPicPath = workPicPath;
	}

	/**
	 * 用户编号
	 */
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 用户编码
	 */
	private String userCode;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPassword;
	/**
	 * 用户性别
	 */
	private int gender;
	/**
	 * 用户生日
	 */
	@Past(message = "必须是一个过去的时间")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	/**
	 * 用户联系电话
	 */
	private String phone;
	/**
	 * 用户联系地址
	 */
	private String address;
	/**
	 * 用户角色编号
	 */
	private int userRole;

	/**
	 * 用户角色类型
	 */
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 用户创建人
	 */
	private int createdBy;
	/**
	 * 用户创建日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationDate;
	/**
	 * 用户修改人
	 */
	private int modifyBy;
	/**
	 * 用户时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifyDate;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * 用户证件照
	 */
	private String idPicPath;
	
	/**
	 * 用户工作证
	 */
	private String workPicPath;

	/**
	 * 用户的年龄
	 */
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 用户的地址的列表
	 */
	private List<Address> addressList;

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
}
