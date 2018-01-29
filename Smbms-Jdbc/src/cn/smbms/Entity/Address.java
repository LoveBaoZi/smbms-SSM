package cn.smbms.Entity;

/**
 * 用户地址的类
 * 
 * @author Administrator
 * 
 */
public class Address {
	/**
	 * 地址的编号
	 */
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddressDesc() {
		return addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * 地址的名字
	 */
	private String contact;
	/**
	 * 地址的描述
	 */
	private String addressDesc;
	/**
	 * 地址邮政编码
	 */
	private String postCode;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 地址的创建人
	 */
	private int createdBy;
	/**
	 * 地址的创建时间
	 */
	private String creationDate;
	/**
	 * 地址的修改人
	 */
	private int modifyBy;
	/**
	 * 地址的修改时间
	 */
	private String modifyDate;
	/**
	 * 地址的用户的编号
	 */
	private int userId;
}
