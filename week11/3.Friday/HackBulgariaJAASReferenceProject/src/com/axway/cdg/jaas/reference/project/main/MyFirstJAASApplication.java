package com.axway.cdg.jaas.reference.project.main;

import java.security.Principal;
import java.util.Scanner;
import java.util.Set;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import com.axway.cdg.jaas.reference.project.framework.RefJAASCallbackHandler;

/**
 * Main program of our application.
 * The application uses JAAS for authentication mechanism.
 * 
 * @author aandreev
 *
 */
public class MyFirstJAASApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Hello My first JAAS application");        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter username:");
        String username = scan.next();
        
        
        System.out.println("Enter password:");
        String password = scan.next();
        
        //Set JAAS configuration file - it basically contains a list of login modules only
        System.setProperty("java.security.auth.login.config", "jaas.config");  
        
        // create a callback handler that will process data between the JAAS framework  and login modules
        // this is basically an additional object used to store user data, from which login modules read data,
        // instead of directly doing it through the application
        RefJAASCallbackHandler callbackHandler = new RefJAASCallbackHandler(username, password);
        
        // JAAS starts here - the LoginContext is actually the JAAS login component in which authentication occurrs
        LoginContext lc = null;        
        try {
            lc = new LoginContext("RefJAASConfiguration", callbackHandler);
            lc.login();
            // JAAS ends here - if we get to here, this means that JAAS authentication completed successfully
            // Let`s check who the logged in user is by revising the principals
            // in our case we expect only one Principal
            Set<Principal> principals = lc.getSubject().getPrincipals();
            for (Principal principal : principals) {
                System.out.println("User [" + principal.getName() + "] authenticated successfully.");
            }
        } catch (LoginException e) {
            // if we get to here - this means that JAAS authentication failed.
            System.out.println("User [" + username + "] did not authenticate successfully with password [" + password + "]");
            e.printStackTrace();
        }
        
    }

}
