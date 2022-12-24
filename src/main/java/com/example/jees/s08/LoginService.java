/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s08;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple service implemented as singleton - NOT production ready
 * 
 * @see ServletContextListener, Spring @Service, ...
 */
public class LoginService {
    private static final Logger log = LogManager.getLogger(LoginService.class);
    private static final LoginService instance = new LoginService();

    private LoginService() {
    }

    /**
     * Unique point of access to the service
     * 
     * @return the singleton
     */
    public static LoginService getInstance() {
        return instance;
    }

    /**
     * The check password service
     * 
     * @param user     the passed username
     * @param password the passed password
     * @return true if the access is vouched
     */
    public boolean check(String user, String password) {
        log.traceEntry(user);

        // don't do that! sensitive data should be encrypted and stored in a safe place!
        boolean vouched = "superuser".equals(user) && "fido".equals(password);

        log.log(vouched ? Level.TRACE : Level.WARN, "User/password is {}", vouched);
        return vouched;
    }
}
