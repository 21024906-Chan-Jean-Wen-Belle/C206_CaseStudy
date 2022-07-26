
public class Deal {
	String id;
	String itemName;
	String sellerEmail;
	String buyerEmail;
	int transPrice;
	String closeDate;


	public Deal (String id, String itemName, String sellerEmail, String buyerEmail, int transPrice, String closeDate) {
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

	public int getTransactionPrice() {
		return transPrice;
	}

	public String getCloseDate() {
		return closeDate;
	}

}
