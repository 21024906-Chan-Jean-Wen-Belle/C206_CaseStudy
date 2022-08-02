
public class Bid  {
	private String bidId;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double bidPrice;
	private boolean deleted;
	
	public Bid (String bidId, String itemName,String sellerEmail, String buyerEmail, double bidPrice) {
		this.bidId = bidId;
		this.itemName = itemName ;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail ;
		this.bidPrice = bidPrice;

	}

	public String getItemName() {
		return itemName;
	}

	public String getBidId() {
		return bidId;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public double getBidPrice() {
		return bidPrice;
	}
	
	public void setIsDeleted(boolean b) {
		// TODO Auto-generated method stub
		this.deleted = deleted;
	}
	
	
	
}
