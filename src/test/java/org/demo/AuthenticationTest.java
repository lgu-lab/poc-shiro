package org.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuthenticationTest {

    @BeforeClass
    public static void beforeClass() {
        //0.  Build and set the SecurityManager used to build Subject instances used in your tests
        //    This typically only needs to be done once per class if your shiro.ini doesn't change,
        //    otherwise, you'll need to do this logic in each test that is different
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_tests.ini");
        //setSecurityManager(factory.getInstance());
        SecurityUtils.setSecurityManager(factory.getInstance());

    }
    
	// See : http://shiro.apache.org/java-authentication-guide.html 
	
	@Test
	public void test1() {
		SecurityManager securityManager = SecurityUtils.getSecurityManager();
		System.out.println("SecurityManager : " + securityManager.getClass());

		// Init 
//		Realm realm = null ;//instantiate or acquire a Realm instance.  We'll discuss Realms later.
//		SecurityManager securityManager = new DefaultSecurityManager(realm);

//		SecurityManager securityManager = new DefaultSecurityManager();

		// when "currentUser.login(token);"
		// java.lang.IllegalStateException: Configuration error:  No realms have been configured!  One or more realms must be present to execute an authentication attempt.
		
//		SecurityManager securityManager = 
//		        (SecurityManager)appCtx.getBean("securityManager");

		//Make the SecurityManager instance available to the entire application:
//		SecurityUtils.setSecurityManager(securityManager);
		    
		    
		String username = "John" ;
		String password = "secret" ;
		
		
		//---------- Step 1 - Collect the subject's principals and credentials
		
		//Example using most common scenario:
		//String username and password.  Acquire in
		//system-specific manner (HTTP request, GUI, etc)

		UsernamePasswordToken token =
		 new UsernamePasswordToken( username, password );

		//”Remember Me” built-in, just do this:
		token.setRememberMe(true);
		System.out.println("UsernamePasswordToken : " + token );
		
		
		//---------- Step 2 - Submit the principals and credentials to an authentication system.
		
		//With most of Shiro, you'll always want to make sure you're working with the currently executing user, referred to as the subject
		Subject currentUser;
		try {
			currentUser = SecurityUtils.getSubject();
			// throws UnavailableSecurityManagerException if no security manager
		} catch ( ShiroException se ) {
		    //unexpected error?
			se.printStackTrace();
			return ;
		}
		System.out.println("Subject currentUser : " + currentUser );

		//Authenticate the subject by passing
		//the user name and password token
		//into the login method
		try {
			currentUser.login(token);
		} catch ( UnknownAccountException uae ) { 
			uae.printStackTrace();
		} catch ( IncorrectCredentialsException ice ) { 
			ice.printStackTrace();
		} catch ( LockedAccountException lae ) { 
			lae.printStackTrace();
		} catch ( ExcessiveAttemptsException eae ) { 
			eae.printStackTrace();
			
		//catch your own ...
		} catch ( AuthenticationException ae ) {
		    //unexpected error?
			ae.printStackTrace();
		}
		
		currentUser.logout();
	}
}
