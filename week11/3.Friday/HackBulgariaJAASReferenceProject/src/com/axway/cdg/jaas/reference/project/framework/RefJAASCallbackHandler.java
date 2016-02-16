package com.axway.cdg.jaas.reference.project.framework;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 * A callback handler definition.
 * The purpose of this callback handler is to run a function
 * that will make certain variables available for login modules.
 * 
 * @author aandreev
 *
 */
public class RefJAASCallbackHandler implements CallbackHandler {
    
    /**
     * Username.
     */
    private String name;
    
    /**
     * Password.
     */
    private String password;
    
    /**
     * A constructor.
     * 
     * @param name - login name of the user
     * @param password - password of the user
     */
    public RefJAASCallbackHandler(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            Callback callback = callbacks[i];
            if (callback instanceof NameCallback) {
                NameCallback nc = (NameCallback) callback;
                nc.setName(name);
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback pc = (PasswordCallback) callback;
                pc.setPassword(password.toCharArray());
            }
        }        
    }

}
