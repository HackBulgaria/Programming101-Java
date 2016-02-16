package com.axway.cdg.jaas.reference.project.framework;

import java.security.Principal;

/**
 * A Principal to contain the name characteristics of the user.
 * 
 * Principal as a characteristics, should become part of a  subject.
 * The subject may be considered as the authenticated identity of the user,
 * that may contain multiple characteristics - principals.
 * 
 * @author aandreev
 *
 */
public class UserPrincipal implements Principal {
    
    /**
     * Username characteristics.
     */
    private String name;
    
    /**
     * Constructor.
     * 
     * @param username - name of the user
     */
    public UserPrincipal(String username) {
        this.name = username;
    }

    @Override
    public String getName() {
        return name;
    }

}
