package cn.smbms.Controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.Entity.Provider;
import cn.smbms.Entity.Users;
import cn.smbms.Service.Provider.ProviderSerivce;
import cn.smbms.Util.Page;

@Controller
public class ProviderController {

	@Resource
	private ProviderSerivce providerSerivce;

	/**
	 * 查找供应商列表的信息
	 * 
	 * @param proCode
	 * @param proName
	 * @param currpage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Sys/pro/find")
	public String FindProviderList(
			@RequestParam(value = "proCode", required = false) String proCode,
			@RequestParam(value = "proName", required = false) String proName,
			@RequestParam(value = "pageIndex", required = false) Integer currpage,
			Model model) {
		if (currpage == null) {
			currpage = 1;
		}
		Page page = new Page();
		page.setInfoCount(providerSerivce.ProviderCount(proCode, proName));
		page.setCurrPageNo(currpage);
		page = providerSerivce.getProviderListByCodeAndName(proCode, proName,
				page);
		model.addAttribute("page", page);
		return "providerlist";
	}

	/**
	 * 列表页面跳转到新增页面
	 * 
	 * @param pro
	 * @return
	 */
	@RequestMapping(value = "/Sys/pro/addPro")
	public String AddProvider(@ModelAttribute("pro") Provider pro) {
		return "provideradd";
	}

	/**
	 * 进行持久化操作
	 * 
	 * @param pro
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/Sys/pro/addProSave", method = RequestMethod.POST)
	public String AddProviderSave(Provider pro, HttpSession session) {
		pro.setCreatedBy(((Users) session.getAttribute("userSession")).getId());
		pro.setCreationDate(new Date());
		if (providerSerivce.InsertIntoNewProvider(pro) == 1) {
			return "redirect:/pro/find";
		}
		return "provideradd";
	}
}
