package ATM;

import javax.swing.*;  
import java.awt.*; 
import java.awt.event.*;
/*
 * 登录界面
 */

public class Login extends JFrame implements ActionListener{
	public Account currentAccount;//登录的用户
	private JPanel p0,p1,p2,p3;//定义面板，布局
	private JTextField userName;//账号
	private JPasswordField passWord;//密码
	private JButton login,exit;  //登录，退出按钮
	private JLabel jl1,jl2,jl3;	
	//构造登录界面
	public Login(Account account){
		super("登录ATM");//窗体标题 
		currentAccount=account;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口的点击右上角的x的处理方式，这里设置的是退出程序  
		setLayout(new GridLayout(4,1));//设置窗体布局为4*1的网格布局
		
		p0=new JPanel();
		jl1=new JLabel("欢迎使用ATM柜员机系统！");//设置标签内容（下同）
		jl1.setFont(new Font("黑体",Font.BOLD,40));//设置标签字体，加粗，大小（下同）
		p0.add(jl1);//添加组件，将标签添加到面板（下同）
		
		p1=new JPanel();
		jl2=new JLabel("卡号：");
		jl2.setFont(new Font("黑体",Font.BOLD,25));
		p1.add(jl2);
		userName=new JTextField(20);//设置文本框长度为20
		userName.setFont(new Font("黑体",Font.PLAIN,25));
		p1.add(userName);
		
		p2=new JPanel();
		jl3=new JLabel("密码：");
		jl3.setFont(new Font("黑体",Font.BOLD,25));
		p2.add(jl3);
		passWord=new JPasswordField(20);
		passWord.setFont(new Font("黑体",Font.PLAIN,25));
		passWord.setEchoChar('*');//设置密码框输入密码时显示为*
		p2.add(passWord);
		
		p3=new JPanel();
		p3.setLayout(null);//将容器设置为绝对布局，组件位置坐标大小可自定义
		login=new JButton("登录");
		login.setBounds(350, 50, 60, 40);//定义按钮坐标大小
		exit=new JButton("退出");
		exit.setBounds(500, 50, 60, 40);
		p3.add(login);
		p3.add(exit);
		
		//将面板添加到窗体
		add(p0);
		add(p1);
		add(p2);
		add(p3);		
		
		setVisible(true);//设置窗体可见
		setSize(900, 700);//设置窗体大小		
		setLocationRelativeTo(null);//居中
		setResizable(false);//设置窗体大小固定
		
		//按钮添加监听
		login.addActionListener(this);
		exit.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){//监听login按钮
			if(new String(userName.getText()).equals(currentAccount.id)) {//账号正确
				if(new String(passWord.getPassword()).equals(currentAccount.password)) {//密码正确 
					JOptionPane.showMessageDialog(this, "登录成功");  						
					new Menu(currentAccount);//实例化操作主界面窗口 
					dispose(); //释放登录窗口
				}
				else { 
					JOptionPane.showMessageDialog(this, "密码错误");
					passWord.setText("");//错误密码清空
					passWord.requestFocus();//密码框获得焦点
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "该用户不存在");  	
				userName.setText("");//错误用户名清空
				passWord.setText("");//错误密码清空
				userName.requestFocus();//用户名框获得焦点
			}		
			
		} 		
		
		if(e.getSource()==exit){//监听exit按钮
			JOptionPane.showMessageDialog(null, "确认退出！");
			dispose();//关闭窗体
		}
	}  
	public static void main(String[] args){
		Account currentAccount=new Account("888888","123456","50000");
	    Login login = new Login(currentAccount);  //程序入口
	}  
}
