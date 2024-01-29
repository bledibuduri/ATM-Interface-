import java.util.HashMap;

public class UNandPasswords {
HashMap<String,String> logininfo = new HashMap<String,String>();
	
	UNandPasswords(){
		
		logininfo.put("bledibuduri","math123");
		logininfo.put("diellzerushiti","PASSWORD");
		logininfo.put("fjollaberisha","abc123");
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
	}

}
