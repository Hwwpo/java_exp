package ATM;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

/*
 * 查询余额界面
 */

public class Inqury extends JFrame{
	
	//定义组件
	private JLabel id,yue;
	private JButton ok;
	private Account currentAccount;
	
	//构造查询界面
    public Inqury(Account account){
	    super("查询");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
	    currentAccount=account;	 
	    
	    id=new JLabel("账号："+currentAccount.id);
	    id.setFont(new Font("黑体",Font.BOLD,25));
	    yue=new JLabel("账户余额："+currentAccount.money);
	    yue.setFont(new Font("黑体",Font.BOLD,25));
	    ok=new JButton("确定");
    	ok.setFont(new Font("黑体",Font.PLAIN,25)); 
	    add(id);
        add(yue);      	
    	add(ok);
    
	    	
    	setVisible(true);//设置窗体可见
    	setSize(400, 120);//设置大小
    	setLocationRelativeTo(null);//居中
    	setResizable(false);//设置窗体大小固定	
    	
    	ok.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    }	
}

