import java.util.*;

import java.lang.*;
 
public class BankAccount

{
    List<AccountHolderInfo> acctList ;

    	
    public BankAccount()
    {
    	acctList = new ArrayList<>();
    	
    	acctList.add(new AccountHolderInfo(101, "Chintu", 0));
    	acctList.add(new AccountHolderInfo(102, "Alexander", 0));
    	acctList.add(new AccountHolderInfo(103, "Peter", 0));
    	acctList.add(new AccountHolderInfo(104, "John", 0));
    	acctList.add(new AccountHolderInfo(105, "Max", 0));
    	
    }
    
    
    public String getAllAccountsList() {
    	StringBuilder strB=new StringBuilder();
    	
    	for(AccountHolderInfo s: acctList) {
    		strB.append(s.getAccountNumber());
    		strB.append(":");
    		strB.append(s.getAccountName());
    		strB.append(":");
    		strB.append(s.getAccountBalance());
    		strB.append("\t");
    	}
    	return strB.toString();
    	
    }
    
    
    public String getAccountInfo(int acctNum) {
    	StringBuilder strB=new StringBuilder();
    	
    	if(100 < acctNum && acctNum < 106)
    	{
    	    for(AccountHolderInfo s: acctList) 
    	{
    		if(s.getAccountNumber()==acctNum) 
    		{
    		strB.append(s.getAccountNumber());
    		strB.append(":");
    		strB.append(s.getAccountName());
    		strB.append(":");
    		strB.append(s.getAccountBalance());
    		strB.append("\t");
    		break;
    		}
    		else {
    			continue;
    	    	}
         	}   	
    	    }
    	else {

    		strB.append("Incorrect Account Numberrrr");
 
    	}
    	return strB.toString();	
    }
    
    public double getAccountBal(int acctNum) {
    //	StringBuilder sbrBal= new StringBuilder();
    	double accountBal=0;
    		for(AccountHolderInfo s: acctList) 
    		{
    		if(s.getAccountNumber()==acctNum) {
    			accountBal=s.getAccountBalance();
    			break;
    		}
    		else 
    			continue;
    		}
    		return accountBal;
    	}
    	
    
 
    public void setDepositBalance(int acctNum, double bal) {
    	
    	if(100 < acctNum && acctNum < 106)
    	{
//    	int acctIndex=acctList.indexOf(acctNum);
    	for(AccountHolderInfo s: acctList) {
    		if(s.getAccountNumber()==acctNum)
    			s.setDepositBalance(bal);
    	}
    	}
		else {
		//do nothing	
	    	}
    }
    
    public void setWithdrawalBalance(int acctNum, double bal) {
    	
    	if(100 < acctNum && acctNum < 106)
    	{
//    	int acctIndex=acctList.indexOf(acctNum);
    	for(AccountHolderInfo s: acctList) {
    		if(s.getAccountNumber()==acctNum && s.getAccountBalance() >= bal)
    		s.setWithdrawBalance(bal);
    	}
    	}
		else {
		//do nothing	
	    	}
    }
    
}
