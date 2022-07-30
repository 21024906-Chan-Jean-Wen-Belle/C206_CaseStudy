
public class Deal {
	private String id;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double transPrice;
	private String closeDate;
	private boolean deleted;

	
	public Deal(String id, String itemName, String sellerEmail, String buyerEmail, double transPrice,
			String closeDate) {
		this.id = id;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail ;
		this.transPrice = transPrice;
		this.closeDate = closeDate;
		this.deleted = false ;
	}

	public String getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public double getTransactionPrice() {
		return transPrice;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setIsDeleted(boolean deleted) {
		this.deleted = deleted ;
	}
	
	public String toString() {
		String dealInfo = String.format("%-10s %-20s %-30s %-30s %-20s %-20s", "ID", "ITEM NAME",
				 "SELLER EMAIL", "BUYER EMAIL","TRANSACTION PRICE", "CLOSE DATE");
		return dealInfo;
	
	}
}

