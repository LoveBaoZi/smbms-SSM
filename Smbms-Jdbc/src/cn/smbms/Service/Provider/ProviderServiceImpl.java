package cn.smbms.Service.Provider;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.Dao.Provider.ProviderMapper;
import cn.smbms.Entity.Provider;
import cn.smbms.Util.Page;

/**
 * 供应商服务的实现类
 * 
 * @author Administrator
 * 
 */
@Service("ProviderService")
public class ProviderServiceImpl implements ProviderSerivce {

	@Resource
	ProviderMapper provider = null;

	@Override
	public int ProviderCount(String proCode, String proName) {
		// TODO Auto-generated method stub
		return provider.ProviderCount(proCode, proName);
	}

	@Override
	public ArrayList<Provider> getProviderList(String proCode, String proName,
			String proContact, String creationDate) {
		// TODO Auto-generated method stub
		return provider.getProviderList(proCode, proName, proContact,
				creationDate);
	}

	@Override
	public Page getProviderListByCodeAndName(String proCode, String proName,
			Page page) {
		page.setProList(provider.getProviderListByCodeAndName(proCode, proName,
				(page.getCurrPageNo() - 1) * page.getPageSize()));
		return page;
	}

	@Override
	public int InsertIntoNewProvider(Provider pro) {
		// TODO Auto-generated method stub
		return provider.InsertIntoNewProvider(pro);
	}

	@Override
	public int updateProvider(ProviderSerivce pro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProvider(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
