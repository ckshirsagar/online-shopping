package net.kzn.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.kzn.onlineshopping.model.UserModel;
import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.User;



@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel=null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel(){
		
		if(session.getAttribute("userModel")==null){
			
			Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
			
			User user=userDAO.getbyEmail(authentication.getName());
			
			if(user!=null){
				
				userModel=new UserModel();

				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName()+" "+ user.getLastName());
				
				if(user.getRole().equals("USER")){
					userModel.setCart(user.getCart());
				}
				
				session.setAttribute("userModel", userModel);
				return userModel;
			}
			
			
			
		}
		
		return (UserModel) session.getAttribute("userModel");
	}

}
