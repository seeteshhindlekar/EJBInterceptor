package com.seet.interceptor.stateless;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import com.seet.interceptor.BusinessInterceptor;

/**
 * Session Bean implementation class DepartmentBean
 */
@Stateless
//@LocalBean
@Interceptors ({BusinessInterceptor.class})
public class DepartmentBean implements DepartmentBeanRemote {

    /**
     * Default constructor. 
     */
    public DepartmentBean() {
    	bookShelf = new ArrayList<String>();
    }

	@Override
	public String getDepartment() {
		return "department bean";
	}
    
	List<String> bookShelf;    
	
	public void addBook(String bookName) {
      bookShelf.add(bookName);
   }    

   public List<String> getBooks() {
      return bookShelf;
   }  

}
