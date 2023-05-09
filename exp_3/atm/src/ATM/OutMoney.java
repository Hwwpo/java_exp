package ATM;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 

/*
 * 取款界面
 */

public class OutMoney implements ActionListener{
	
	//定义组件
	public JTextField money;
	public JFrame oframe;
	public JPanel op0,op1,op2,op3,op4;
	public JButton confirm,cancel,exit;
	public JLabel id,yue,qu,tishi;
	boolean flag1=false;
	boolean flag2=false;
	private Account currentAccount;
	
	//构造取款界面
	public OutMoney(Account account){
		oframe=new JFrame("取款");
		oframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentAccount=account;
		op0=new JPanel();
		id=new JLabel("账号："+currentAccount.id);
		id.setFont(new Font("黑体",Font.BOLD,25));
		op0.add(id);
		
		op1=new JPanel();
		yue=new JLabel("账户余额："+currentAccount.money);
		yue.setFont(new Font("黑体",Font.BOLD,25));
		op1.add(yue);
		
		op2=new JPanel();
		qu=new JLabel("取款金额：");
		qu.setFont(new Font("黑体",Font.BOLD,25));
		money=new JTextField(20);
		money.setFont(new Font("黑体",Font.BOLD,25));
		
		op2.add(qu);
		op2.add(money);
		
		op3=new JPanel();  
	    confirm=new JButton("确定");  
	    confirm.setFont(new Font("黑体",Font.PLAIN,25));
	    op3.add(confirm);  
	    cancel=new JButton("返回"); 
        cancel.setFont(new Font("黑体",Font.PLAIN,25));
	    op3.add(cancel);  

	    oframe.add(op0);  
	    oframe.add(op1);  
	    oframe.add(op2); 
	    oframe.add(op3);
	    
	    oframe.setLayout(new FlowLayout());  
	    oframe.setVisible(true);  
	    oframe.setSize(450, 200);//窗体大小 
	    oframe.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	    oframe.setResizable(false);
	      
	    confirm.addActionListener(this);  
	    cancel.addActionListener(this);  		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确定")){
			flag1=false;
        	flag2=false;
            try { 
            	int money1=Integer.parseInt(money.getText());
            	if(money1%100==0) {//取款金额为整百的数
            		flag1=true;
            	}
            	if(money1<=5000&&money1>0) {//取款金额不超过5000
            		flag2=true;
            	}
            	if(flag1&&flag2) {            		
            		currentAccount.outMoney(Integer.parseInt(money.getText()));  	
            		JOptionPane.showMessageDialog(null, "取款成功");//弹窗  
            		yue.setText("账户余额:"+currentAccount.money);//更新余额显示
            		money.setText("");//清空文本框
            	}
            	if(!flag1) {
            		JOptionPane.showMessageDialog(null, "系统不支持非100元整钞取款\n 请重新输入取款金额 ！ ");//弹窗 
            		money.setText("");
            	}
            	if(!flag2){
            		JOptionPane.showMessageDialog(null, "系统不支持取款超过5000元\n 请重新输入取款金额 ！ ");//弹窗 
            		money.setText("");
            	}
            	if(money1>currentAccount.money){
            		JOptionPane.showMessageDialog(null, "余额不足，请重新输入取款金额 ！ ");//弹窗 
            		money.setText("");
            	}
            }  
            catch (ClassCastException e1){
                JOptionPane.showMessageDialog(null, "输入数据类型错误，请输入整数");//捕获Test类中outmoney方法的异常
            }  
            catch (Exception e1){  
                JOptionPane.showMessageDialog(null, e1.getMessage());  
            }  
        }  
		else if(e.getActionCommand().equals("返回")){
				oframe.dispose();//关闭取款界面
		}
	}
}
