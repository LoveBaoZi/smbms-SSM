package cn.smbms.Entity;

/**
 * 用户角色的类
 * 
 * @author Administrator
 */
public class Role {
	/**
	 * 角色的编号
	 */
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	/**
	 * 角色的编码
	 */
	private String roleCode;
	/**
	 * 角色的名称
	 */
	private String roleName;
	/**
	 * 角色的创建人
	 */
	private int createdBy;
	/**
	 * 角色的创建时间
	 */
	private String creationDate;
	/**
	 * 角色的修改人
	 */
	private int modifyBy;
	/**
	 * 角色的修改时间
	 */
	private String modifyDate;
}
