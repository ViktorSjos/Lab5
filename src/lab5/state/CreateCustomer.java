package lab5.state;

public class CreateCustomer {
	
	private int Id = 0;
	

	
	public Customer NewCustomer() {
		Customer customer = new Customer(Id);
		return customer;
	}
	

	

	public class Customer {
		private int Id;
		
		public Customer(int NewId) {
			this.Id = NewId;
		}
		
		public int GetId() {
			return this.Id;
		}
		
		
	}
	

}

