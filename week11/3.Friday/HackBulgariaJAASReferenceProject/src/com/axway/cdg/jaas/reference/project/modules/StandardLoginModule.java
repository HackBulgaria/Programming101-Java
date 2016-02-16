package com.axway.cdg.jaas.reference.project.modules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import java.util.Properties;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import com.axway.cdg.jaas.reference.project.framework.UserPrincipal;

/**
 * A login module that will validate password of a user.
 * Validation occurs against a simple  properties file.
 * Format of the properties file is in the following format:
 * <username>=<password>
 * 
 * @author aandreev
 *
 */
public class StandardLoginModule implements LoginModule {
    
    /**
     * Callback handler object - to be used by the login module for obtaining username and password.
     */
    private CallbackHandler callbackHandler;
    
    /**
     * Authentication subject object - the authenticated identity.
     */
    private Subject subject;

    @Override
    public boolean abort() throws LoginException {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.callbackHandler = callbackHandler;
        this.subject = subject;
        
    }

    @Override
    public boolean login() throws LoginException {
        // here we specify what data the login module needs from the callback handler
        NameCallback username = new NameCallback("Username");
        PasswordCallback password = new PasswordCallback("Password", false);   
        try {
            // here we run the callback handler handle() method
            // that should provide the needed value to the
            // username and password callback objects
            callbackHandler.handle(new Callback[]{username, password});
        } catch (IOException e) {
            System.out.println("Error reading callbacks.");
            e.printStackTrace();
            throw new LoginException();
        } catch (UnsupportedCallbackException e) {
            System.out.println("Error reading callbacks.");
            e.printStackTrace();
            throw new LoginException();
        }

        // here we take the values for the username and password
        String usernameFromCallback = username.getName();
        char[] passwordFromCallbak = password.getPassword();
        
        // validate the password
        boolean isPasswordValid = validatePassword(usernameFromCallback, passwordFromCallbak);
        if (!isPasswordValid) {
            System.out.println("Standard Login Module failed.");
            return false;
        }
        
        // finally we create a principal and set it to the subject
        // this step is needed because at the end, when authentication succeeds,
        // the application would need to know who is authenticated and
        // what characteristics the logged in user has
        Principal p = new UserPrincipal(usernameFromCallback);
        subject.getPrincipals().add(p);
        
        System.out.println("Standard Login Module succeeded.");
        return true;
    }

    @Override
    public boolean logout() throws LoginException {
        // TODO Auto-generated method stub
        return true;
    }
    
    /**
     * Validates the password of a user against a properties file.
     * 
     * @param username - name of the user
     * @param password - password of the user
     * @return true if password is correct, otherwise false
     */
    private boolean validatePassword(String username, char[] password) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("users.properties")));
            String passwordFromFile = properties.getProperty(username);
            if (passwordFromFile != null && !passwordFromFile.isEmpty()) {
                if (passwordFromFile.equals(String.valueOf(password))) {
                    System.out.println("Authentication of user [" + username + "] is successful.");
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }

}
