
public class Deal {
	private String id;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double transPrice;
	private String closeDate;

	
	public Deal(String dealID, String itemName, String sellerEmail, String buyerEmail, double transPrice,
			String closeDate) {
		this.id = id;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail ;
		this.transPrice = transPrice;
		this.closeDate = closeDate;
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

	public String getCloseDate() {
		return closeDate;
	}

}
