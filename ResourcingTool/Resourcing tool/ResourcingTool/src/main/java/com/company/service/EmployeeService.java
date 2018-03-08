package com.company.service;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;

import com.company.ldap.AttributeType;
import com.company.model.Employee;

public class EmployeeService {

	public static Employee getEmployeeDetails(NamingEnumeration<SearchResult> employeeDetails) {
		
		System.out.println("inside getting getEmployeeDetails");
		Employee employee=new Employee();
		
		try{
			while (employeeDetails.hasMoreElements())
			{
				System.out.println("loop for values");
				SearchResult sr = (SearchResult)employeeDetails.next();
				System.out.println(">>>" + sr.getName());
				Attributes attrs = sr.getAttributes();
				System.out.println("attrib::"+attrs);

				Attribute nameAttrib=attrs.get(AttributeType.NAME);
				String name="";
				if(nameAttrib!=null){
					name=nameAttrib.get().toString();
					employee.setUserName(name);
				}

				Attribute samaAttrib=attrs.get(AttributeType.SAMACCOUNTNAME);
				String sama="";
				if(samaAttrib!=null){
					sama=samaAttrib.get().toString();
					employee.setNickName(sama);
				}


				Attribute mngrAttrib=attrs.get(AttributeType.MANAGER);
				String manager="";
				if(mngrAttrib!=null){
					manager=mngrAttrib.get(0).toString();
					String cn="CN=";
					manager=manager.substring(manager.indexOf(cn)+cn.length(), manager.indexOf(","));
					employee.setManager(manager);
				}

				Attribute titleAttrib=attrs.get(AttributeType.TITLE);
				String title="";
				if(titleAttrib!=null){
					title=titleAttrib.get().toString();
					employee.setDesignation(title);
				}

				Attribute deptAttrib=attrs.get(AttributeType.DEPARTMENT);
				String dept="";
				if(deptAttrib!=null){
					dept=deptAttrib.get().toString();
					employee.setDepartment(dept);
				}

				Attribute empIdAttrib=attrs.get(AttributeType.EMPLOYEEID);
				String empId="";
				if(empIdAttrib!=null){
					empId=empIdAttrib.get().toString();
					employee.setEmployeeID(empId);
				}
				
				Attribute mailAttrib=attrs.get(AttributeType.MAIL);
				String mailId="";
				if(mailAttrib!=null){
					mailId=mailAttrib.get().toString();
					employee.setMailId(mailId);
				}
				
				Attribute phoneAttrib=attrs.get(AttributeType.TELEPHONENUMBER);
				String phone="";
				if(phoneAttrib!=null){
					phone=phoneAttrib.get().toString();
					employee.setPhone(phone);
				}
				//employee.setPhone("123214124");
				
				System.out.println("name::"+name);
				System.out.println(">>>>>>samaname" +sama );
				System.out.println("manager::"+manager);
				System.out.println("employeeID::"+empId);
				System.out.println("title::"+title);
				System.out.println("dept::"+dept);
				System.out.println("mailid::"+mailId);
				System.out.println("phone::"+phone);
			}
		}
		catch(Exception e){
			
		}

		return employee;
	}	
}
