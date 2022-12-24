/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s07;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * DAO for Coder
 * 
 * @see Coder
 */
public class CoderDao implements AutoCloseable {
    private static final Logger log = LogManager.getLogger(CoderDao.class);

    /** SELECT all coders, as employees from department IT */
    private static final String GET_ALL = """
            SELECT employee_id, first_name, last_name, hired, salary
            FROM employee JOIN department USING (department_id)
            WHERE name = 'IT'""";

    /** The JDBC connection */
    private Connection conn;

    /**
     * Set the connection up
     * 
     * @param ds data source to the required DBMS
     * @throws IllegalStateException wrapping the original {@link SQLException}
     */
    public CoderDao(DataSource ds) {
        log.traceEntry();

        try {
            this.conn = ds.getConnection();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    /**
     * Get all coders in the EMPLOYEE table
     * 
     * @return all coders
     */
    public List<Coder> getAll() {
        log.traceEntry();
        List<Coder> result = new ArrayList<>();

        try (Statement stmt = conn.createStatement(); //
                ResultSet rs = stmt.executeQuery(GET_ALL)) {
            while (rs.next()) {
                LocalDate hired = rs.getDate("hired").toLocalDate();
                Coder cur = new Coder(rs.getLong(1), rs.getString(2), rs.getString(3), hired, rs.getDouble(5));
                result.add(cur);
            }
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }

        log.debug("Read {} items", result.size());
        return result;
    }

    @Override
    public void close() throws IOException {
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
