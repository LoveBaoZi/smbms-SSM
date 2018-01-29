package cn.smbms.Dao.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.smbms.Entity.Users;

/**
 * 用户的接口
 * 
 * @author Administrator
 * 
 */
public interface UsersMapper {

	/**
	 * 根据用户的编号进行查找用户的对象
	 * 
	 * @param userId
	 * @return
	 */
	public Users getUsersByUserId(@Param("userid") Integer userId);

	/**
	 * 根据用户名和密码查询用户的对象
	 * 
	 * @param name
	 * @param passWord
	 * @return
	 */
	public Users getUsersByPassword(@Param("name") String name,
			@Param("password") String passWord);

	/**
	 * 返回用户列表
	 * 
	 * @return
	 */
	public ArrayList<Users> getUsersList(@Param("userName") String name,
			@Param("role") Integer roleId, @Param("currpage") int currpage);

	/**
	 * 返回用户列表的总数
	 * 
	 * @param name
	 * @param roleId
	 * @return
	 */
	public int getUserCount(@Param("userName") String name,
			@Param("role") Integer roleId);

	/**
	 * 返回用户的列表 于角色的编号
	 * 
	 * @param roleId
	 *            角色的编号
	 * @return 用户列表
	 */
	public List<Users> getUsersListByRoleId_Foreach_Array(int... roleIds);

	/**
	 * 根据用户的性别和角色的编号尽心查找用户列表
	 * 
	 * @param conditionMap
	 * @return
	 */
	public List<Users> getUserListByRoleIdAndGender(
			Map<String, Object> conditionMap);

	/**
	 * 返回用户的列表，及地址的信息
	 * 
	 * @param userId
	 *            用户的编号
	 * @return 用户的信息
	 */
	public List<Users> getAddressListByUserId(@Param("userid") int userId);

	/**
	 * 新增用户
	 * 
	 * @param users
	 *            用户的对象
	 * @return 结果数
	 */
	public int add(Users users);

	/**
	 * 修改用户
	 * 
	 * @param users
	 *            用户的对象
	 * @return 结果数
	 */
	public int update(Users users);

	/**
	 * 
	 * 修改用户的密码
	 * 
	 * @param id
	 *            用户的id
	 * @param passWord
	 *            用户的新密码
	 * @return 结果数
	 */
	public int updatePassWordByUserid(@Param("id") int id,
			@Param("userPassWord") String passWord);

	/**
	 * 根据用户的编号删除用户
	 * 
	 * @param id
	 *            用户的编号
	 * @return 结果数
	 */
	public int deleteUserByUserId(@Param("id") int id);
}
