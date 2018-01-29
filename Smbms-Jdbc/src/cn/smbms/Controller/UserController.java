package cn.smbms.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

import cn.smbms.Entity.Role;
import cn.smbms.Entity.Users;
import cn.smbms.Service.Role.RoleService;
import cn.smbms.Service.Users.UserService;
import cn.smbms.Util.Page;

/**
 * 控制器 :UserController
 * 
 * @author Administrator
 * 
 */
@Controller
public class UserController {
	
	@Resource
	private UserService userService = null;
	@Resource
	private RoleService roleService = null;

	/**
	 * 根据用户的账号密码登陆用户主页
	 * 
	 * @param userName
	 * @param userPassword
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String Login(@RequestParam String userName,
			@RequestParam String userPassword, HttpSession session,
			HttpServletRequest request) {
		Users users = userService.getUserByUserPassWord(userName, userPassword);
		if (null != users) {
			session.setAttribute("userSession", users);
			return "frame";
		} else {
			users = userService.getUserByUserPassWord(userName, null);
			if (users == null) {
				request.setAttribute("error", "该用户不存在");
			} else {
				request.setAttribute("error", "用户名或密码不正确");
			}
			return "../login";
		}
	}

	/**
	 * 退出用户登陆的方法
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/Sys/user/exitLogin")
	public String ExitUserLogin(HttpSession session) {
		session.setAttribute("userSession", null);
		return "../login";
	}

	/**
	 * 实现用户的查找
	 * 
	 * @param userName
	 *            用户名
	 * @param roleId
	 *            用户角色编号
	 * @param currpage
	 *            当前页
	 * @param model
	 * @return 用户列表
	 */
	@RequestMapping(value = "/Sys/user/find")
	public String FindUserList(
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "roleId", required = false) Integer roleId,
			@RequestParam(value = "pageIndex", required = false) Integer currpage,
			Model model) {
		if (currpage == null) {
			currpage = 1;
		}
		Page page = new Page();
		page.setInfoCount(userService.getUserCount(userName, roleId));
		page.setCurrPageNo(currpage);
		page = userService.getUsersList(userName, roleId, page);
		ArrayList<Role> roleList = roleService.getAllRole();
		model.addAttribute("roleList", roleList);
		model.addAttribute("page", page);
		return "userlist";
	}

	/**
	 * 从列表页面跳转到新增页面 （中转站，带去一个空的user对象，准备带回满的user对象）
	 * 
	 * @param user
	 *            用户对象
	 * @return
	 */
	@RequestMapping(value = "/Sys/user/addUser", method = RequestMethod.GET)
	public String AddUser(@ModelAttribute("user") Users user) {
		return "useradd";
	}

	/**
	 * 进行保存用户的操作
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/Sys/user/addUserSave")
	public String AddUserSave(
			Users user,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs) {
		int userId = ((Users) session.getAttribute("userSession")).getId();
		String idPicPath = null;
		String workPicPath = null;
		String errorInfo = null;
		String path = request
				.getSession()
				.getServletContext()
				.getRealPath(
						"statics" + File.separator + "uploadfiles"
								+ File.separator + userId);// 定义存储的位置

		for (int i = 0; i < attachs.length; i++) {
			MultipartFile attach = attachs[i];
			// 判断文件是否为空
			if (!attach.isEmpty()) {
				if (i == 0) {
					errorInfo = "uploadFileError";
				} else if (i == 1) {
					errorInfo = "uploadWpError";
				}
				String oldFileName = attach.getOriginalFilename();// 原文件名
				String prefix = FilenameUtils.getExtension(oldFileName); // 获取源文件名的后缀
				int filesize = 500000; // 定义一个文件大小 500 kb
				if (attach.getSize() > filesize) {
					request.setAttribute("uploadFileError",
							"上传的文件大小不得超过  500 kb");
					return "useradd";
				} else if (prefix.equalsIgnoreCase("jpg")
						|| prefix.equalsIgnoreCase("png")
						|| prefix.equalsIgnoreCase("jpeg")
						|| prefix.equalsIgnoreCase("pneg")) {
					String fileName = System.currentTimeMillis() + "_"
							+ RandomUtils.nextInt(1000000) + "_" + userId
							+ "_Rersonal.jpg";// 取到系统的时间
					File targetFile = new File(path, fileName); // 新建文件
																// （1.路径，2.文件名）
					if (!targetFile.exists()) {
						targetFile.mkdirs(); // 新建文件
						try {
							attach.transferTo(targetFile);
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute(errorInfo, "上传失败！");
							return "useradd";
						}
						if (i == 0) {
							idPicPath = path + File.separator + fileName;
						} else if (i == 1) {
							workPicPath = path + File.separator + fileName;
						}
					}
				}
			} else {
				request.setAttribute(errorInfo, "上传的文件格式不正确");
				return "useradd";
			}
		}
		user.setCreatedBy(((Users) session.getAttribute("userSession")).getId());
		user.setIdPicPath(idPicPath);
		user.setWorkPicPath(workPicPath);
		user.setCreationDate(new Date());
		if (userService.add(user) >= 1) {
			return "redirect:/user/find";
		}
		return "useradd";
	}

	/**
	 * 修改前夕，进行查找。 找到需要修改的User对象
	 * 
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("/Sys/user/selectUser")
	public String SelectUserUpdate(@RequestParam("uid") Integer userId,
			Model model) {
		Users user = userService.getUsersByUserId(userId);
		model.addAttribute("user", user);
		return "usermodify";
	}

	/**
	 * 进行修改的操作
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping("/Sys/user/updateUserSave")
	public String UpdateUser(Users user, HttpSession session) {
		user.setModifyBy(((Users) session.getAttribute("userSession")).getId());
		user.setModifyDate(new Date());
		if (userService.update(user) >= 1) {
			return "redirect:/user/find";
		}

		return "usermodify";
	}

	/**
	 * 查看用户的方法
	 * 
	 * @param userid
	 *            用户的编号
	 * @param model
	 * @return
	 */
	@RequestMapping("/Sys/user/viewUser/{userid}")
	public String SelectUser(@PathVariable Integer userid, Model model) {
		Users user = userService.getUsersByUserId(userid);
		model.addAttribute("user", user);
		return "userview";
	}

	/**
	 * 进行同名测试 (Ajax处理)
	 * 
	 * @param userCode
	 * @return
	 */
	@RequestMapping("/Sys/user/userExits")
	@ResponseBody
	public Object userCodeIsExist(@RequestParam("userCode") String userCode) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (StringUtils.isNullOrEmpty(userCode)) {
			resultMap.put("userCode", "yes");
		} else {
			Users user = userService.getUserByUserPassWord(userCode, null);
			if (null != user) {
				resultMap.put("userCode", "no");
			} else {
				resultMap.put("userCode", "yes");
			}
		}
		return JSONArray.toJSONString(resultMap);
	}

	/**
	 * 通过用户的编号进行查找用户的信息进行返回(Ajax)
	 * 
	 * @param userid
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/Sys/user/userViewAjax", method = RequestMethod.GET)
	@ResponseBody
	public String userSelectView(@RequestParam("userid") Integer userid,
			HttpServletResponse response) {
		Users user = userService.getUsersByUserId(userid);
		String json = JSON.toJSONString(user);
		return json;
	}

	/**
	 * 根据当前用户的密码检测原密码是否正确
	 * 
	 * @param pwd
	 *            用户传过来的密码
	 * @param session
	 *            session用来获取用户的原密码
	 * @return
	 */
	@RequestMapping("/Sys/user/checkUserPwdExist")
	@ResponseBody
	public String checkUserPwdISExist(@RequestParam("oldpassword") String pwd,
			HttpSession session) {
		String isExits = "";
		Users userAdmin = ((Users) (session.getAttribute("userSession")));
		if (null != userAdmin) {
			if (pwd.equals(userAdmin.getUserPassword())) {
				isExits = "true";
			} else {
				isExits = "false";
			}
		} else {
			isExits = "sessionerror";
		}
		return JSON.toJSONString(isExits);
	}

	/**
	 * 修改用户的密码
	 * 
	 * @param userPass
	 * @param request
	 * @return
	 */
	@RequestMapping("/Sys/user/updateUserPassWord")
	public String UpdateUserPassWord(
			@RequestParam("newpassword") String userPass,
			HttpServletRequest request) {
		Integer userId = ((Users) (request.getSession()
				.getAttribute("userSession"))).getId();
		if (userService.updatePassWordByUserid(userId, userPass) >= 1) {
			request.getSession().setAttribute("userSession", null);
			return "../login";
		}
		request.setAttribute("message", "修改密码失败！请稍后重试");
		return "passWordUpdate";
	}

	/**
	 * 查找所有角色
	 * 
	 * @return
	 */
	@RequestMapping("/Sys/user/findUserRole")
	@ResponseBody
	public String FindUserRole() {
		return JSON.toJSONString(roleService.getAllRole());
	}
}
