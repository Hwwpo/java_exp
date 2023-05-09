package ATM;

public class Account {
	int money;  
	String id;//账号名  
	String password;  
	
	public Account(String id, String password, String money) {//构造方法
	    this.id = id;  
	    this.password = password;  
	    this.money=Integer.parseInt(money);  
	}  	  
	
	public void outMoney (int money)throws Exception { 
	    if (money > this.money) { 
	        throw new Exception("余额不足");  
	    }
	    if(money<0){
	        throw new Exception("不能取出负数");  
	    }  
	    this.money -= money;  
	}  	  
	
	public void inMoney(int money)throws Exception {
		if(money<0){
	        throw new Exception("不能存入负数");  
	    } 
		this.money+=money;
    }  	   
	
	public void ChangePassword(String newPassword)throws Exception{
	    if(newPassword.equals(this.password)) {
	        throw new Exception("原密码和新密码不能一样");  
	    }  
	    else {
	        if(newPassword.equals("")) {
	            throw new Exception("密码不能为空");  
	        }  
	    }  
        password=newPassword;  
	}  	  
}
