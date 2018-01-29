package cn.smbms.Entity;
/**
 * 商品的类
 * @author Administrator
 *
 */
public class Bill {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public double getProductCount() {
		return productCount;
	}

	public void setProductCount(double productCount) {
		this.productCount = productCount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getIsPayment() {
		return isPayment;
	}

	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	/**
	 * 主键ID
	 */
	private int id;
	/**
	 * 账单编号
	 */
	private String billCode;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 商品描述
	 */
	private String productDesc;
	/**
	 * 商品单位
	 */
	private String productUnit;
	/**
	 * 商品数量
	 */
	private double productCount;
	/**
	 * 商品总额
	 */
	private double totalPrice;
	/**
	 * 是否支付（1：未支付 2：已支付）
	 */
	private int isPayment;
	/**
	 * 创建者（userId）
	 */
	private int createdBy;
	/**
	 * 创建时间
	 */
	private String creationDate;
	/**
	 * 更新者（userId）
	 */
	private int modifyBy;
	/**
	 * 更新时间
	 */
	private String modifyDate;
	/**
	 * 供应商ID
	 */
	private int providerId;
	/**
	 * 供应商的对象
	 */
	private Provider provider;

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
