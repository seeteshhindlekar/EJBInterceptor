package com.seet.interceptor.client;

import java.util.List;

import javax.naming.Context;

import javax.naming.NamingException;

import com.seet.interceptor.stateless.DepartmentBeanRemote;

public class EJBApplicationClientStateful {

    private static final String LOOKUP_STRING = "ejb:/EJBInterceptor/DepartmentBean!com.seet.interceptor.stateless.DepartmentBeanRemote";
    public static void main(String[] args) {
    	DepartmentBeanRemote bean = doLookup();
    	System.out.println("dept    XXXXXXXXXXXX ");
       String pp = bean.getDepartment();
      System.out.println("department    XXXXXXXXXXXX "+pp);
      
      bean.addBook("ddddd");
      
      List<String> booksList = bean.getBooks();
      
      System.out.println(booksList.size());
      
      
    }
 
    private static DepartmentBeanRemote doLookup(){
    	
    	System.out.println("dept 1111");
        Context context = null;
        DepartmentBeanRemote bean = null;
        try{
                    //1. Obtaining Context
            context = ClientUtility.getInitialContext();
            
        	System.out.println("dept   22222222  aaaaaa");

                //2. Lookup and cast
                bean = (DepartmentBeanRemote)context.lookup(LOOKUP_STRING);
                
            	System.out.println("dept   33333");

        }catch(NamingException e){
            e.printStackTrace();
        }
        return bean;
    }
	
}
