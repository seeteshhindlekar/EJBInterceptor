package com.seet.interceptor.stateless;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface DepartmentBeanRemote {
	
	public String getDepartment();
	
	  void addBook(String bookName);
	   List getBooks();

}
