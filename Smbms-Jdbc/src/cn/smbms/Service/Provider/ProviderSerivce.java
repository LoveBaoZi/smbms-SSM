package cn.smbms.Service.Provider;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import cn.smbms.Entity.Provider;
import cn.smbms.Util.Page;

/**
 * 供应商的接口
 * 
 * @author Administrator
 * 
 */
public interface ProviderSerivce {

	/**
	 * 查询供应商的数量
	 * 
	 * @return 总数
	 */
	public int ProviderCount(String proCode, String proName);

	/**
	 * 获得供应商的列表
	 * 
	 * @return 供应商列表的集合
	 */
	public ArrayList<Provider> getProviderList(String proCode, String proName,
			String proContact, String creationDate);

	/**
	 * 获得供应商的列表
	 * 
	 * @return 供应商列表的集合
	 */
	public Page getProviderListByCodeAndName(@Param("proCode") String proCode,
			@Param("proName") String proName, Page page);

	
	
	/**
	 * 新增供应商
	 * 
	 * @param pro
	 *            供应商的对象
	 * @return 结果数
	 */
	public int InsertIntoNewProvider(Provider pro);

	/**
	 * 进行修改供应商的信息
	 * 
	 * @param pro
	 *            供应商的对象
	 * @return 结果数
	 */
	public int updateProvider(ProviderSerivce pro);

	/**
	 * 进行删除供应商的信息
	 * 
	 * @param id
	 *            编号
	 * @return 结果数
	 */
	public int deleteProvider(int id);
}
