package cn.smbms.Service.Role;

import java.util.ArrayList;


import cn.smbms.Entity.Role;

/**
 * 用户角色服务的接口
 * 
 * @author Administrator
 * 
 */
public interface RoleService {

	/**
	 * 获取全部的角色
	 * 
	 * @return
	 */
	public ArrayList<Role> getAllRole();

	/**
	 * 新增一个角色
	 * 
	 * @param role
	 *            角色的对象
	 * @return 结果数
	 */
	public int insertIntoNewRole(Role role);

	/**
	 * 修改一个角色
	 * 
	 * @param role
	 *            角色的对象
	 * @return 结果数
	 */
	public int udpateRole(Role role);

	/**
	 * 根据角色编号查找用户的个数
	 * 
	 * @param roleId
	 *            角色的编号
	 * @return 返回用户的个数
	 */
	public int selectUserCountByRoleId( int roleId);

	/**
	 * 根据角色的编号进行删除角色的对象
	 * 
	 * @param roleId
	 *            角色的编号
	 * @return 结果数
	 */
	public int deleteRole(int roleId);

}
