package com.seet.interceptor.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ClientUtility {

	private static final String JNP_INTERFACES = 
            "org.jboss.naming:org.jnp.interfaces";
     
	private static final String PROVIDER_URL = "jnp://127.0.0.1:1099";
	
	private static final String INITIAL_CONTEXT_FACTORY = 
            "org.jnp.interfaces.NamingContextFactory";
 
    private static Context initialContext;
     
    public static Context getInitialContext() throws NamingException
    {
        if (initialContext == null) {
            //Properties extends HashTable
//            Properties prop = new Properties();                   
 //           prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
 //           prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
 //           prop.put(Context.PROVIDER_URL, PROVIDER_URL);
 //           initialContext = new InitialContext(prop);
            
            Properties properties = new Properties();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            properties.put(Context.PROVIDER_URL,"remote+http://localhost:8080");
            // username
            properties.put(Context.SECURITY_PRINCIPAL, "seetesh");
            // password
            properties.put(Context.SECURITY_CREDENTIALS, "seetesh");
            // This is an important property to set if you want to do EJB invocations via the remote-naming project
            properties.put("jboss.naming.client.ejb.context", true);
            // create a context passing these properties
            return new InitialContext(properties);
            
            
        }
        return initialContext;
    }
	
}
