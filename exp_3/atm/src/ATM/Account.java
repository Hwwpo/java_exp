package ATM;

import java.io.*;


public class Account {
	int money;  
	String id;//�˺���  
	String password;  
	
	public Account(){//���췽��
		try {
			FileReader id_reader = new FileReader("id.txt");
			FileReader pw_reader = new FileReader("pw.txt");
			FileReader money_reader = new FileReader("money.txt");
			BufferedReader id_br = new BufferedReader(id_reader);
			BufferedReader pw_br = new BufferedReader(pw_reader);
			BufferedReader money_br = new BufferedReader(money_reader);
			this.id = id_br.readLine();
			this.password = pw_br.readLine();
			this.money = Integer.parseInt(money_br.readLine());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}  	  
	
	public void outMoney (int money)throws Exception { 
	    if (money > this.money) { 
	        throw new Exception("����");  
	    }
	    if(money<0){
	        throw new Exception("����ȡ������");  
	    }  
	    this.money -= money;
		try {
			FileWriter money_writer = new FileWriter("money.txt");
			BufferedWriter money_br = new BufferedWriter(money_writer);
			money_br.write(Integer.toString(this.money));
			money_br.flush();
		}
		catch (IOException e){
			e.printStackTrace();
		}

	}  	  
	
	public void inMoney(int money)throws Exception {
		if(money<0){
	        throw new Exception("���ܴ��븺��");  
	    } 
		this.money+=money;
		try {
			FileWriter money_writer = new FileWriter("money.txt");
			BufferedWriter money_br = new BufferedWriter(money_writer);
			money_br.write(Integer.toString(this.money));
			money_br.flush();
		}
		catch (IOException e){
			e.printStackTrace();
		}
    }  	   
	
	public void ChangePassword(String newPassword)throws Exception{
	    if(newPassword.equals(this.password)) {
	        throw new Exception("ԭ����������벻��һ��");  
	    }  
	    else {
	        if(newPassword.equals("")) {
	            throw new Exception("���벻��Ϊ��");  
	        }  
	    }  
        password=newPassword;
		try {
			FileWriter pw_writer = new FileWriter("pw.txt");
			BufferedWriter pw_br = new BufferedWriter(pw_writer);
			pw_br.write(this.password);
			pw_br.flush();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}  	  
}
