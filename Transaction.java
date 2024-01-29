import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
import javax.swing.*;


public class Transaction implements ActionListener {
	private static float balance = 0;
	
	UNandPasswords unpas = new UNandPasswords();
	 JFrame frame = new JFrame();
	 JLabel label1 = new JLabel();
	 JLabel label2 = new JLabel();
	 JLabel label3 = new JLabel();
	 JLabel label4 = new JLabel();
	 JLabel label5 = new JLabel();
	 JLabel messageLabel = new JLabel();
	 JTextField choice = new JTextField();
	 JButton pressButton = new JButton("Press");
	 JButton resetButton = new JButton("Reset");

		HashMap<String,String> logininfo = new HashMap<String,String>();

	
	   Transaction(){
		label1.setBounds(5,0,200,35);
		label1.setFont(new Font(null,Font.BOLD,15));

		
		label2.setBounds(10,15,420,35);
		label2.setFont(new Font(null,Font.ITALIC,15));
		
		label3.setBounds(10,30,420,35);
		label3.setFont(new Font(null,Font.ITALIC,15));
		
		label4.setBounds(10,45 ,420,35);
		label4.setFont(new Font(null,Font.ITALIC,15));
		
		label5.setBounds(10 ,60 ,420 ,35);
		label5.setFont(new Font(null,Font.ITALIC,15));
		
		choice.setBounds(10,100,50,25);
		
		pressButton.setBounds(70,150,100,25);
		pressButton.setFocusable(false);
		pressButton.addActionListener(this);
		
		
		resetButton.setBounds(180,150,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);

		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(messageLabel);
		frame.add(choice);
		frame.add(pressButton);
       JRootPane rootPane1=SwingUtilities.getRootPane(pressButton);
       rootPane1.setDefaultButton(pressButton);

		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(183, 235, 234));
		frame.setSize(320,320);
		frame.setLayout(null);
		frame.setVisible(true);
		

		label1.setText("What would you like to do !");
		label2.setText("Press 1 if you want to Withdraw.");
		label3.setText("Press 2 if you want to Deposit.");
		label4.setText("Press 3 to see the Balance.");
		label5.setText("Press 4 to Exit.");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
		if(e.getSource() == resetButton) {
			choice.setText("");
		}
		
		if(e.getSource()==pressButton) {
			String text = choice.getText();
         if (text.equals(""))
         return;
			int choicee = Integer.parseInt(text);
			choice.setText("");
				if(choicee ==1) {
				String amount;
				amount = JOptionPane.showInputDialog("Please Enter the amount you want to Withdraw");
				float a = Float.parseFloat(amount);
				if( a > balance || a == 0) {
					JOptionPane.showMessageDialog(frame, "You have insufficient funds!!\n" +
				                       "(The withdraw should be smaller or the exact amount as balance).\n");	
				} else {
					//they have some cash 
					//update balance 
					balance = balance - a;
					JOptionPane.showMessageDialog(frame,"You have withdrawn " + a + "$ and your new balance is " + balance + "$ \n");
				}
			
			   }else if (choicee == 2) {
				//option number 2 is depositing
				String deposit ;
				deposit = JOptionPane.showInputDialog(null,"Please enter amount you should wish to deposit: ");
				float depo = Float.parseFloat(deposit);
				//updaye balance 
				balance = depo + balance;
				JOptionPane.showMessageDialog( frame, "You have deposited " + depo + "$ and your balance is " + balance + "$");
				

			}else if(choicee == 3) {
				//this option is to check balance 
				JOptionPane.showMessageDialog(frame, "Your balance is: " + balance + " $\n Thank you for choosing us!");
				//anotherTransaction();
			}else if (choicee == 4) {
				frame.dispose();
				JOptionPane.showMessageDialog(frame, "Good Bye. Thank you for choosing us!");
				
				}            
            else {
					JOptionPane.showMessageDialog(frame, "Invalid number! Please use one of the numbers above!");
				
		
			}
			
		}
		
	}
    catch (NumberFormatException St){        
      if(!choice.getText().equals("")){
      JOptionPane.showMessageDialog(null,"Invalid character!");
      }
      else{
         JOptionPane.showMessageDialog(null,"Good Bye. Thank you for choosing us!");
         } 
    }           

    catch(NullPointerException ex){}        
}
}