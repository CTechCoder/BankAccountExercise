import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

//import java.util.*;


public class AccountFrame extends JFrame
{
   private static final int FRAME_WIDTH = 800;
   private static final int FRAME_HEIGHT = 600;

   private JLabel mainMenuLabel;
   private JLabel menuListLabel;
   private JLabel topBoxResultLabel;
   private JLabel bottomBoxResultLabel;
   private JLabel allResultLabel;
   private JLabel acctSearchLabel;
   private JLabel depositLabel;
   private JLabel withdrawLabel;
	
	private JTextField menuItemValue;
	private JTextField acctSearchValue;
	private JTextField depositValue;
	private JTextField withdrawValue;
	
	private JButton menuItemButton;

	private JPanel panel;

	private BankAccount account;

	
	public AccountFrame() {
		   
		 account = new BankAccount();
		 topBoxResultLabel = new JLabel("<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>");
		 allResultLabel=new JLabel("<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-RESULT WILL BE PUBLISHED HERE-<>-<>-<>-<>-<>-<>-<>-<>-<>");
		 bottomBoxResultLabel = new JLabel("<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>-<>");

		 
		 createInitialLabel();
		 createInitialButton();
		 createInitialTextField();
		 createPanel();
		 setSize(FRAME_WIDTH, FRAME_HEIGHT);
	   }
	
	   private void createInitialLabel()
	   {  
		   
			//  mainMenuLabel = new JLabel("List of Menu items -   1.Display All  2.Search By Account 3.Deposit 4.Withdrawal 5.Exit"); 
		    StringBuilder menuMain = new StringBuilder(64);
            menuMain.append("<html>    List of Menu items -  </br>").
                            append("  1. Display All </br>").
                            append("  2. Search By Account </br>").
                            append("  3. Deposit 4.Withdrawal </br>").
                            append("  4. Withdrawal </br>").
                            append("  5. Exit </br>").
                            append("  </br>").
                            append("  </br>").
                            append("  </br>").
                            append("  </br>").
                            append("</html>");
			  mainMenuLabel = new JLabel(menuMain.toString()); 
			  mainMenuLabel.setFont(new Font("Serif", Font.BOLD, 15));
			  mainMenuLabel.setHorizontalAlignment(JLabel.CENTER);

			 // menuListLabel  = new JLabel("Enter a valid Menu item number:   ");
			    StringBuilder menuList = new StringBuilder(64);
			    	menuList.append("<html>>>>>>>>>>>>>Enter a valid Menu Item Number (values from 1 through 5) : </br> </html>").
	            			append("  </br>").
	            			append("  </br>").
	            			append("  </br>");
				  menuListLabel  = new JLabel(menuList.toString());
				  menuListLabel.setHorizontalTextPosition(JLabel.CENTER);
	          
			  //acctSearchLabel = new JLabel("Enter Account Number (101 through 105): ");
			    StringBuilder acctSearch = new StringBuilder(64);
	            acctSearch.append("<html>>>>>>>>>>>> Enter Account Number (101 through 105):   </br> </html>").
	            			append("  </br>").
	            			append("  </br>").
	            			append("  </br>");
				  acctSearchLabel  = new JLabel(acctSearch.toString());
				  acctSearchLabel.setVerticalTextPosition(JLabel.BOTTOM);
				  
				  depositLabel = new JLabel("Enter Amount to DEPOSIT (make sure Acct number is also provided):  ");

				  withdrawLabel = new JLabel("Enter Amount to WITHDRAW (make sure Acct number is also provided):  ");

	   }
 
	   private void createInitialTextField()
	   {
		  final int FIELD_WIDTH_MENU = 1;
		  final int FIELD_WIDTH_ACCTNUM = 3;
		  final int FIELD_WIDTH_DEPOSIT = 8;
		  final int FIELD_WIDTH_WITHDRAWAL = 8;
		  menuItemValue = new JTextField(FIELD_WIDTH_MENU);
		  acctSearchValue = new JTextField(FIELD_WIDTH_ACCTNUM);
		  depositValue = new JTextField(FIELD_WIDTH_DEPOSIT);
		  withdrawValue = new JTextField(FIELD_WIDTH_WITHDRAWAL);
	   }
   
	   
	    private void createInitialButton() {
	     menuItemButton = new JButton("Enter for the result response: ");
	     
	      class MenuListListener implements ActionListener
	      {
	         public void actionPerformed(ActionEvent event)
	         {
	  	       int menuVal=Integer.parseInt(menuItemValue.getText());
	  	       switch(menuVal) {
	  	       case 1: {
		  	   allResultLabel.setText(account.getAllAccountsList()); 
	  	    	 break;
	  	       }
	  	       case 2: {
	  	    	   if(acctSearchValue.getText().trim().length() == 0) {
	  	    		 allResultLabel.setText("Enter valid Account Number");
	  	    	   }else {
		  	    	   int acctSearchVal=Integer.parseInt(acctSearchValue.getText());
	  	    	   allResultLabel.setText(account.getAccountInfo(acctSearchVal));
	  	    	   }
	  	    	   break;
	  	       }
	  	       case 3: {
	  	    	   if(depositValue.getText().trim().length() == 0 && acctSearchValue.getText().trim().length() == 0) {
	  	    		   allResultLabel.setText("Enter a valid Deposit amountttt and Valid Account Number");
	  	    	   }
	  	    	   else {
	  	    		 int acctSearchVal=Integer.parseInt(acctSearchValue.getText());
	  	    		   double depositVal=Double.parseDouble(depositValue.getText());
	  	    		   account.setDepositBalance(acctSearchVal, depositVal);
		  	    	   allResultLabel.setText("Change the Menu Item as 2 to check the balance update");
	  	    	   }
	  	    	   break;
	  	       }
	  	       case 4: {
	  	    	   if(withdrawValue.getText().trim().length() == 0 && acctSearchValue.getText().trim().length() == 0)
	  	    			   {
	  	    		   allResultLabel.setText("Enter a valid Withdrawal amountttt and Valid Account Number");
	  	    	   }
	  	    	   else 
	  	    		   if(Double.parseDouble(withdrawValue.getText()) > account.getAccountBal(Integer.parseInt(acctSearchValue.getText()))){
	  	    		   allResultLabel.setText("SORRY Withdrawal amountttt is more than Available amount"); 
	  	    		   }
	  	    	   else {
	  	    		 int acctSearchVal=Integer.parseInt(acctSearchValue.getText());
	  	    		   double withdrawVal=Double.parseDouble(withdrawValue.getText());
	  	    		   account.setWithdrawalBalance(acctSearchVal, withdrawVal);
		  	    	   allResultLabel.setText("Change the Menu Item as 2 to check the balance update");
	  	    	   }
	  	    	   break;
	  	       }
	  	       case 5: {
	  	    	   allResultLabel.setText("HOPE YOU ENJOYED THE PROGRAM!!! GOOD BYE");
	  	    	 System.exit(0);
	  	    	   break;
	  	       }
	  	       default: {
	  	    	   allResultLabel.setText("SORRY Clicked Incorrect ITEM NUMBER VALUE - should between 1 and 5");
	  	    	   break;
	  	       }
	  	       
	  	       }
	  	       
	         }
	      }
	      ActionListener d = new MenuListListener();
	      menuItemButton.addActionListener(d);

	      
	    }
	    
	    
	    private void createPanel()
	    {
	       panel = new JPanel();
	     
	       panel.add(mainMenuLabel);
	       panel.add(menuListLabel);
	       panel.add(menuItemValue);
	       panel.add(acctSearchLabel);
	       panel.add(acctSearchValue);
	       panel.add(depositLabel);
	       panel.add(depositValue);
	       panel.add(withdrawLabel);
	       panel.add(withdrawValue);
	       panel.add(menuItemButton);
	       panel.add(topBoxResultLabel);
	       panel.add(allResultLabel);
	       panel.add(bottomBoxResultLabel);
	       add(panel);
	    }


   
}
