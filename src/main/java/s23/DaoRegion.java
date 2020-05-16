package s23;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoRegion implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(DaoRegion.class);
    private Connection conn;

    public DaoRegion(DataSource ds) {
        LOG.trace("called");

        try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }

    public List<Region> getAll() {
        LOG.trace("called");
        List<Region> results = new ArrayList<>();

        try (Statement stmt = conn.createStatement(); //
                ResultSet rs = stmt.executeQuery("select * from regions")) {
            while (rs.next()) {
                results.add(new Region(rs.getLong("REGION_ID"), rs.getString("REGION_NAME")));
            }
        } catch (SQLException se) {
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
