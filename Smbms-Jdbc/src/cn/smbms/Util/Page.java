package cn.smbms.Util;

import java.util.ArrayList;

import cn.smbms.Entity.Provider;
import cn.smbms.Entity.Users;

/**
 * 分页的类
 * 
 * @author Administrator
 * 
 */
public class Page {

	/**
	 * 当前的页数
	 */
	private int currPageNo;

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		if (currPageNo >= this.pageCount) {
			this.currPageNo = this.pageCount;
		} else if (currPageNo <= 1) {
			this.currPageNo = 1;
		} else {
			this.currPageNo = currPageNo;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getInfoCount() {
		return infoCount;
	}

	public void setInfoCount(int infoCount) {
		if (infoCount <= 1) {
			this.infoCount = 0;
			this.pageCount = 1;
		} else {
			this.infoCount = infoCount;
			this.pageCount = (infoCount % pageSize == 0) ? (infoCount / pageSize)
					: (infoCount / pageSize + 1);
		}

	}

	public ArrayList<Users> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<Users> userList) {
		this.userList = userList;
	}

	/**
	 * 页容量
	 */
	private int pageSize = 5;
	/**
	 * 页数
	 */
	private int pageCount;
	/**
	 * 信息的总数
	 */
	private int infoCount;
	/**
	 * 用户的列表
	 */
	private ArrayList<Users> userList;
	/**
	 * 供应商的列表
	 */
	private ArrayList<Provider> proList;

	public ArrayList<Provider> getProList() {
		return proList;
	}

	public void setProList(ArrayList<Provider> proList) {
		this.proList = proList;
	}
}
