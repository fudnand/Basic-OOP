import java.time.LocalDate;
import java.util.*;
public class BankApp {

	public static void main(String[] args) {
		
		List<Acct> accts = new ArrayList<>();
		
		accts.add(new CheckingAcct("123d", 100));
		accts.add(new CheckingAcct("1d3d", 200));
		accts.add(new savingAcct("3e3d", 500));
		
		for(int i =0; i< accts.size(); i++){
			Acct acct = accts.get(i);
			acct.withdraw(150);
			acct.applyInterest();
			System.out.println(acct.balance);
		}
	}

}


abstract class Acct{
	protected String acctNum;
	protected double balance;
	
	public Acct(String acctN, double b){
		acctNum = acctN;
		balance = b;
	}
	
	public Acct(){
		acctNum = "";
		balance = 0;
	}
	
	protected void deposit(double amt){
		balance += amt;
	}
	
	protected void withdraw(double amt){
		balance -= amt;
	}
	
	public abstract void applyInterest(); 
}

class savingAcct extends Acct{
	private final static double InteRate = 0.0125;
	private final int numWithdrawalAllowed = 5;
	private int numWithdrawals;
	
	public savingAcct(){
		super();
		numWithdrawals = 0;
	}	
	public savingAcct(String acctN, double b){
		super(acctN, b);
		numWithdrawals = 0;
	}
	
	@Override
	public void applyInterest() {
		if(LocalDate.now().getDayOfMonth() == 1){
			if(balance > 100){
				balance += balance *InteRate;
			}
		}		
	}
	
	protected void withdraw(double amt){
		if(numWithdrawals< numWithdrawalAllowed){
			super.withdraw(amt);
		}
	}
	
	public void resetNumwithdrawals(){
		if(LocalDate.now().getDayOfMonth() == 1){
			numWithdrawals = 0;
		}
	}
	
}


class CheckingAcct extends Acct{
	private boolean status; 
	private final static double FEEs = 25;
	private final static double InteRate = 0.0025;
	
	public CheckingAcct(String acctN, double b){
		super(acctN, b);
		status = true;
	}
	
	public CheckingAcct(){
		super();
		status = true;
	}
	
	protected void withdraw(double amt){
		super.withdraw(amt);
		if(balance <0){
			balance -= FEEs;
			this.status = false;
		}
	}
	
	public void withdraw(double amt, boolean isElectronic){
		if(isElectronic){
			//verification
			//do something on the balance
		}
		else{
			withdraw(amt);
		}
	}
	
	@Override
	public void applyInterest() {
		if(LocalDate.now().getDayOfMonth() == 1){
			if(balance > 0){
				balance += balance *InteRate;
			}
		}
		
	}
	
}