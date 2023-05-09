package ATM;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 

/*
 * ATM更改密码界面
 */

public class ChangePassword implements ActionListener {
	
	//定义组件
	public JPasswordField oldPassword,newPassword,checkPassword;
	public JFrame cframe;
	public JPanel cp0,cp1,cp2,cp3;
	public JLabel l1,l2,l3;
	public JButton confirm,cancel;
	private Account currentAccount;
	//构造更改密码界面
	public ChangePassword(Account account){
		cframe=new JFrame("更改密码");
		cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentAccount=account;
		cp0=new JPanel();
		l1=new JLabel("原密码：");
		l1.setFont(new Font("黑体",Font.BOLD,25));
		cp0.add(l1);
		oldPassword=new JPasswordField(20);
		oldPassword.setFont(new Font("黑体",Font.BOLD,25));
		oldPassword.setEchoChar('*');
		cp0.add(oldPassword);
		
		cp1=new JPanel();
		l2=new JLabel("新密码：");
		l2.setFont(new Font("黑体",Font.BOLD,25));
		cp1.add(l2);
		newPassword=new JPasswordField(20);
		newPassword.setFont(new Font("黑体",Font.BOLD,25));
		newPassword.setEchoChar('*');
		cp1.add(newPassword);
		
		cp2=new JPanel();
		l3=new JLabel("再次输入新密码：");
		l3.setFont(new Font("黑体",Font.BOLD,25));
		cp2.add(l3);
		checkPassword=new JPasswordField(20);
		checkPassword.setFont(new Font("黑体",Font.BOLD,25));
		checkPassword.setEchoChar('*');
		cp2.add(checkPassword);
		
		confirm=new JButton("确定");  
		confirm.setFont(new Font("黑体",Font.PLAIN,25));
	    cancel=new JButton("返回"); 
	    cancel.setFont(new Font("黑体",Font.PLAIN,25));
	    
	    cframe.add(cp0);  
	    cframe.add(cp1);  
	    cframe.add(cp2); 
	    cframe.add(confirm);  
	    cframe.add(cancel);  
	    cframe.setLayout(new FlowLayout());  
	    cframe.setVisible(true);  
	    cframe.setSize(550, 250);//窗体大小 
	    cframe.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
	    cframe.setResizable(false);
	    
	    //添加监听
	    confirm.addActionListener(this);  
	    cancel.addActionListener(this);  	
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确定")){
			if (currentAccount.password.equals(new String(oldPassword.getPassword()))) {  //原密码匹配
                try {  
                    if(newPassword.getText().equals(checkPassword.getText())) { //两次输入密码相同
                    	if(newPassword.getText().length()>=6) { //新密码大6位数
                    		currentAccount.ChangePassword(newPassword.getText());  
                    		JOptionPane.showMessageDialog(null, "更改密码成功");  //弹窗
                    		cframe.setVisible(false);  //关闭更改密码界面
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null,"密码不能少于6位！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);//弹窗
                    		//清空密码框
                    		oldPassword.setText("");
        					newPassword.setText("");
        					checkPassword.setText("");
                    	}
                    }  
                    else{
                        JOptionPane.showMessageDialog(null, "两次输入的密码不一致");  //弹窗
                        //清空密码框
                        oldPassword.setText("");
    					newPassword.setText("");
    					checkPassword.setText("");
                    }  
                }  
             catch (Exception e1) {//捕获账户类中更改密码函数的异常并弹窗显示  
                    JOptionPane.showMessageDialog(null, e1.getMessage()); 
                    oldPassword.setText("");
					newPassword.setText("");
					checkPassword.setText("");
                }  
            } 
			else { 
                JOptionPane.showMessageDialog(null, "原密码错误");  
                oldPassword.setText("");
				newPassword.setText("");
				checkPassword.setText("");
            }  
        } 			
		if(e.getActionCommand().equals("返回")){
			cframe.dispose();//关闭更改密码界面
		}
	}
}
