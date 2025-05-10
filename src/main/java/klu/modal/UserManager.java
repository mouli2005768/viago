package klu.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klu.repository.UserRepository;

@Service
public class UserManager {
	@Autowired
	UserRepository UR;
	
	@Autowired
	EmailManager EM;
	
	@Autowired 
	JwtManager JWT;
	
	//INSERT
	public String insertData(User U)
	{
		if(UR.validateEmail(U.getEmailid()) > 0)
			return "401::Email ID already exist!";
		
		UR.save(U); //INSERT INTO THE DATABASE
		
		return "200::User has been Registered";
	}
	
	//PASSWORD RECOVERY
	public String getPassword(String emailid)
	{
		User U = UR.findById(emailid).get();
		String message = "Dear " + U.getFullname() + "\n\nYour password is " + U.getPassword();
		return EM.sendEmail(emailid, "ViaGo: Password Recovery", message);
	}
	
	//SIGN IN
	public String signIn(String emailid, String password)
	{
		if(UR.validateCredentials(emailid, password) == 0)
			return "401::Invalid Credentials!";
		
		return "200::" + JWT.generateToken(emailid);		
	}
	
}
