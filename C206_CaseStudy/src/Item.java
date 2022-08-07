public class Item {
	private String name;
	private String description;
	private double bidPrice;
	private String startDate;
	private String endDate;
	private double increment;
	private boolean deleted;

	
	public Item (String name, String description, double bidPrice, String startDate, String endDate, double increment) {
		this.name = name; 
		this.description = description;
		this.bidPrice = bidPrice ;
		this.startDate = startDate;
		this.endDate = endDate;
		this.increment = increment ;
		this.deleted = false ;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public double getBidPrice() {
		return bidPrice;
	}


	public String getStartDate() {
		return startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public double getIncrement() {
		return increment;
	}
	public void setIsDeleted(boolean deleted) {
		this.deleted = deleted ;
	}
	
	
	public String toString() {
		String item = String.format("%-10s %-20s %-30s %-30s %-20s %-20s", "NAME", "DESCRIPTION ",
				 "MIN BID PRICE", "AUCTION START DATE","AUCTION END DATE", "BID INCREMENT");
		return item;

	}

}
