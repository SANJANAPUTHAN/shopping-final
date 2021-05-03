package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daomodel.CustomerDetailsDao;
import com.daomodel.UsersMasterDao;
import com.model.CustomerDetailsDto;
import com.model.UsersMasterDto;
@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired
	private UsersMasterDao userAccessObject;
	
	@Autowired
	private CustomerDetailsDao customerdao;
	
	@Override
	public boolean checkUser(String uname, String upass) {
		
		UsersMasterDto user =userAccessObject.findUserByName(uname, upass);
		//System.out.println(user);
		if(user==null) {
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public boolean updateFlag(String uname, String upass, int flag) {
		boolean result=false;
		UsersMasterDto user =userAccessObject.findUserByName(uname, upass);
		user.setFlag(flag);
		result=userAccessObject.updateUsersDetails(user);
		return result;
	}
	
	 @Override
	public int checkFlag(String uname, String upass) {
		UsersMasterDto user =userAccessObject.findUserByName(uname, upass);
		return user.getFlag();
	}
	 
	 @Override
	public int getUserId(String uname, String upass) {
		 UsersMasterDto user =userAccessObject.findUserByName(uname, upass);
		return user.getUid();
	}
	 @Override
	public boolean checkAdmin(String uname, String upass) {
		 UsersMasterDto user =userAccessObject.findUserByName(uname, upass);
		
		 if(user.getAdmin()==1) {
			 return true;
		 }else {
			 return false;
		 }
	}
	 
	 @Override
	public boolean checkManager(String uname, String upass) {
		 UsersMasterDto user =userAccessObject.findUserByName(uname, upass);
		
		 if(user.getAdmin()==2) {
			 return true;
		 }else {
			 return false;
		 }
	}

	@Override
	public String getAddress(String uname) {
		List<CustomerDetailsDto> customer=customerdao.findCustomerByName(uname);
		return customer.get(0).getAddress();
	}
}
