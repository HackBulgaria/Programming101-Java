package com.axway.cdg.jaas.reference.project.modules;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

/**
 * A login module that only verifies the user name.
 * 
 * @author aandreev
 *
 */
public class UsernameLoginModule implements LoginModule {
    
    private Subject subject;
    
    private CallbackHandler callbackhandler;

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
       this.subject = subject;
       this.callbackhandler = callbackHandler;
        
    }

    @Override
    public boolean login() throws LoginException {
        NameCallback usernameCallback = new NameCallback("Username");
        try {
            callbackhandler.handle(new Callback[] {usernameCallback});
            String username = usernameCallback.getName();
            
            Properties props = new Properties();
            props.load(new FileInputStream(new File("users.properties")));
            if (props.containsKey(username)) {
                System.out.println("Username Login Module succeeded.");
                return true;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedCallbackException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        // TODO Auto-generated method stub
        return false;
    }

}
