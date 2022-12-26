/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s10;

import java.util.Set;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple service managed by the context listener
 */
public class CheckerService {
    private static final Logger log = LogManager.getLogger(CheckerService.class);

    /**
     * The actual service provided
     * 
     * @param user a string
     * @return the unique (lower-cased) letters in input
     */
    public Set<Character> check(String user) {
        log.traceEntry();

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
