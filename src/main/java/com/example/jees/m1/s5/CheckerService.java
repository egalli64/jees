/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m1.s5;

import java.util.Set;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple stateless service implemented as a singleton - NOT production ready
 * 
 * @see ServletContextListener, EJB @Singleton, Spring @Service, ...
 */
public class CheckerService {
    private static final Logger log = LogManager.getLogger(CheckerService.class);

    // the single instance - delegate to the JVM to safely instantiate it
    private static final CheckerService instance = new CheckerService();

    /**
     * No one could create a service outside the class
     */
    private CheckerService() {
        log.traceEntry();
    }

    /**
     * Unique point of access to the service
     * 
     * @return the singleton
     */
    public static CheckerService getInstance() {
        return instance;
    }

    /**
     * The actual service provided
     * 
     * @param user a string
     * @return the unique (lower-cased) letters in input
     */
    public Set<Character> check(String user) {
        log.traceEntry("on {}", user);

        Set<Character> result = new TreeSet<>();
        if (user != null) {
            for (char c : user.toCharArray()) {
                result.add(Character.toLowerCase(c));
            }
        }
        log.debug("Checked user is {}", result);
        return result;
    }
}
