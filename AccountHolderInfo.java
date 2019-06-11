
public class AccountHolderInfo {

	private int accountNumber;
	private String accountName;
	//private String accountType;
	private double accountBalance;
	
	AccountHolderInfo(){
		
	}
	
	AccountHolderInfo(int acctNumber, String acctName, double acctBalance){
		accountNumber=acctNumber;
		this.accountName=acctName;
		this.accountBalance=acctBalance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setDepositBalance(double accountBalance) {
		this.accountBalance += accountBalance;
	}
	
	public void setWithdrawBalance(double accountBalance) {
			this.accountBalance -= accountBalance;			
	}
	
}
