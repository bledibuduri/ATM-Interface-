import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPage implements ActionListener{
	JLabel firstPart = new JLabel("National Bank of Kosova!");
	JLabel secondPart = new JLabel("Please write your username and your password before you log in !!");
	JFrame frame = new JFrame("National Bank");
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField usernameField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel usernameLabel = new JLabel("Username: ");
	JLabel userPasswordLabel = new JLabel("Password: ");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LoginPage(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		usernameLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
		
		firstPart.setBounds(100,0,250,35);
		firstPart.setFont(new Font("MV Boli", Font.PLAIN, 20));
		
		secondPart.setBounds(40,15,420,35);
		secondPart.setFont(new Font("MV Boli", Font.PLAIN, 10));
		
		usernameField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(215,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
      
      		
		frame.add(firstPart);
		frame.add(secondPart);
		frame.add(usernameLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(usernameField);
		frame.add(userPasswordField);
		frame.add(loginButton);
        JRootPane rootPane=SwingUtilities.getRootPane(loginButton);
        rootPane.setDefaultButton(loginButton);
		frame.add(resetButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(183, 235, 234));
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==resetButton) {
			//for(int i = 0; 
			usernameField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			String userName = usernameField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userName)) {
				if(logininfo.get(userName).equals(password)) {
					frame.dispose();
					Transaction tran = new Transaction();

				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password!!");
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found!!");
			}
		}
	}	
}