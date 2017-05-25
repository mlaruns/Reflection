package com.ciber.converter;

import java.util.List;

import com.ciber.beans.EmployeeDetails;
import com.ciber.beans.EmployeeList;
import com.ciber.beans.User;

public class UsertoPeersInfoConverter {
	
public static  EmployeeDetails converter(List<EmployeeList> users){
	
	EmployeeDetails empInfo=new EmployeeDetails();
	for(EmployeeList user:users){
		
		if("PEER1".equalsIgnoreCase(user.getRole())){
			empInfo.setPeer1Name(user.getEmpName());
			empInfo.setPeer1Email(user.getEmail());
		}
		if("PEER2".equalsIgnoreCase(user.getRole())){
			empInfo.setPeer2Name(user.getEmpName());
			empInfo.setPeer2Email(user.getEmail());
		}
		if("CROSSFUNCTION".equalsIgnoreCase(user.getRole())){
			empInfo.setCrossFunctionalName(user.getEmpName());
			empInfo.setCrossFunctionalEmail(user.getEmail());
		}
		if("HRBP".equalsIgnoreCase(user.getRole())){
			empInfo.setHrbpName(user.getEmpName());
			empInfo.setHrbpEmail(user.getEmail());
		}
		if("IT".equalsIgnoreCase(user.getRole())){
			empInfo.setItName(user.getEmpName());
			empInfo.setItEmail(user.getEmail());
		}
		if("QMO".equalsIgnoreCase(user.getRole())){
			empInfo.setQmoName(user.getEmpName());
			empInfo.setQmoEmail(user.getEmail());
		}
		if("ADMIN".equalsIgnoreCase(user.getRole())){
			empInfo.setAdminName(user.getEmpName());
			empInfo.setAdminEmail(user.getEmail());
		}
		if("FINANCE".equalsIgnoreCase(user.getRole())){
			empInfo.setFinanceName(user.getEmpName());
			empInfo.setFinanceEmail(user.getEmail());
		}
		if("RECRUITMENT".equalsIgnoreCase(user.getRole())){
			empInfo.setRequitmentName(user.getEmpName());
			empInfo.setRequitmentEmail(user.getEmail());
		}
		if("RMG".equalsIgnoreCase(user.getRole())){
			empInfo.setRmgName(user.getEmpName());
			empInfo.setRmgEmail(user.getEmail());
		}
		
	}
	return empInfo;
	
}

}
