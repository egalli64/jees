package s13;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoderDao implements AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(CoderDao.class);
    private static final String GET_ALL = "SELECT coder_id, first_name, last_name, hire_date, salary FROM coders";
    private Connection conn;

    public CoderDao(DataSource ds) {
        log.trace("called");

        try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }

    public List<Coder> getAll() {
        log.trace("called");
        List<Coder> results = new ArrayList<>();

        try (Statement stmt = conn.createStatement(); //
                ResultSet rs = stmt.executeQuery(GET_ALL)) {
            while (rs.next()) {
                LocalDate hired = rs.getDate("hire_date").toLocalDate();
                Coder cur = new Coder(rs.getLong(1), rs.getString(2), rs.getString(3), hired, rs.getDouble(5));
                results.add(cur);
            }
        } catch (SQLException se) {
            log.error("Can't get coders: " + se.getMessage());
            throw new IllegalStateException("Database issue " + se.getMessage());
        }

        return results;
    }

    @Override
    public void close() throws IOException {
        try {
            conn.close();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }
}
