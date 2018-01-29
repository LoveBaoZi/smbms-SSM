package cn.smbms.Service.Users;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.Dao.Users.UsersMapper;
import cn.smbms.Entity.Users;
import cn.smbms.Util.Page;

/**
 * 用户业务的实现类
 * 
 * @author Administrator
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UsersMapper userMapper = null;

	@Override
	public List<Users> getUsersListByRoleId_Foreach_Array(int... roleIds) {
		return userMapper.getUsersListByRoleId_Foreach_Array(roleIds);
	}

	@Override
	public List<Users> getUserListByRoleIdAndGender(
			Map<String, Object> conditionMap) {
		return userMapper.getUserListByRoleIdAndGender(conditionMap);
	}

	@Override
	public List<Users> getAddressListByUserId(int userId) {
		return userMapper.getAddressListByUserId(userId);
	}

	@Override
	public int add(Users users) {
		return userMapper.add(users);
	}

	@Override
	public int update(Users users) {
		return userMapper.update(users);
	}

	@Override
	public int updatePassWordByUserid(int id, String passWord) {
		return userMapper.updatePassWordByUserid(id, passWord);
	}

	@Override
	public int deleteUserByUserId(int id) {
		return userMapper.deleteUserByUserId(id);
	}

	@Override
	public Users getUserByUserPassWord(String name, String password) {
		// TODO Auto-generated method stub
		return userMapper.getUsersByPassword(name, password);
	}

	@Override
	public Page getUsersList(String name, Integer roleId, Page page) {
		// TODO Auto-generated method stub
		page.setUserList(userMapper.getUsersList(name, roleId,
				(page.getCurrPageNo() - 1) * page.getPageSize()));
		return page;
	}

	@Override
	public int getUserCount(String name, Integer roleId) {
		// TODO Auto-generated method stub
		return userMapper.getUserCount(name, roleId);
	}

	@Override
	public Users getUsersByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.getUsersByUserId(userId);
	}

}
