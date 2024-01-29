//the controller
public class AtmMachine {
	public static void main(String[] args) {
		UNandPasswords unandPasswords = new UNandPasswords();
		LoginPage loginPage = 
				new LoginPage(unandPasswords.getLoginInfo());
		
	}
}
