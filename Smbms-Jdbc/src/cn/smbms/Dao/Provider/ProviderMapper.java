package cn.smbms.Dao.Provider;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import cn.smbms.Entity.Provider;

/**
 * 供应商的接口
 * 
 * @author Administrator
 * 
 */
public interface ProviderMapper {

	/**
	 * 查询供应商的数量
	 * 
	 * @return 总数
	 */
	public int ProviderCount(@Param("proCode") String proCode,
			@Param("proName") String proName);

	/**
	 * 获得供应商的列表
	 * 
	 * @return 供应商列表的集合
	 */
	public ArrayList<Provider> getProviderList(
			@Param("proCode") String proCode, @Param("proName") String proName,
			@Param("proContact") String proContact,
			@Param("creationDate") String creationDate);

	/**
	 * 获得供应商的列表
	 * 
	 * @return 供应商列表的集合
	 */
	public ArrayList<Provider> getProviderListByCodeAndName(
			@Param("proCode") String proCode, @Param("proName") String proName,
			@Param("currpage") Integer currpage);

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
	public int updateProvider(Provider pro);

	/**
	 * 进行删除供应商的信息
	 * 
	 * @param id
	 *            编号
	 * @return 结果数
	 */
	public int deleteProvider(@Param("id") int id);
}
