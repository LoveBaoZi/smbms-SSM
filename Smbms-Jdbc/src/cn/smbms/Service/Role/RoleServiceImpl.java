package cn.smbms.Service.Role;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.Dao.Role.RoleMapper;
import cn.smbms.Entity.Role;

/**
 * 用户角色服务接口的实现类
 * 
 * @author Administrator
 * 
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper = null;

	@Override
	public ArrayList<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleMapper.getAllRole();
	}

	@Override
	public int insertIntoNewRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int udpateRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectUserCountByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRole(int roleId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
