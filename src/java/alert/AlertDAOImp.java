package alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlertDAOImp implements AlertDao {
    private final Connection connection;

    /**
     * Constructs a AlertDAOImpl using the specified database connection.
     *
     * @param connection The database connection.
     */
    public AlertDAOImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addAlert(Alert alert) throws SQLException {
        if (!alertExists(alert.getAlertID())) {
            String sql = "INSERT INTO Alert (userID, itemID, alertTypeID, alertTime, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, alert.getUserID());
                stmt.setInt(2, alert.getItemID());
                stmt.setInt(3, alert.getAlertTypeID());
                stmt.setTimestamp(4, alert.getAlertTime());  // Ensure this is java.sql.Timestamp
                stmt.setString(5, alert.getEmail());
                stmt.setString(6, alert.getPhone());
                stmt.executeUpdate();
            }
        } else {
            System.out.println("Alert with ID " + alert.getAlertID() + " already exists.");
        }
    }

    @Override
    public Alert getAlert(int alertID) throws SQLException {
        String sql = "SELECT * FROM Alert WHERE alertID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, alertID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Alert alert = new Alert(
                        rs.getInt("alertID"),
                        rs.getInt("userID"),
                        rs.getInt("itemID"),
                        rs.getInt("alertTypeID"),
                        rs.getTimestamp("alertTime"),
                        rs.getString("email"),
                        rs.getString("phone")
                    );
                    return alert;
                }
            }
        }
        return null;
    }

    @Override
    public List<Alert> getAllAlerts() throws SQLException {
        List<Alert> alerts = new ArrayList<>();
        String sql = "SELECT * FROM Alert";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Alert alert = new Alert(
                    rs.getInt("alertID"),
                    rs.getInt("userID"),
                    rs.getInt("itemID"),
                    rs.getInt("alertTypeID"),
                    rs.getTimestamp("alertTime"),
                    rs.getString("email"),
                    rs.getString("phone")
                );
                alerts.add(alert);
            }
        }
        return alerts;
    }

    @Override
    public void updateAlert(Alert alert) throws SQLException {
        String sql = "UPDATE Alert SET userID = ?, itemID = ?, alertTypeID = ?, alertTime = ?, email = ?, phone = ? WHERE alertID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, alert.getUserID());
            stmt.setInt(2, alert.getItemID());
            stmt.setInt(3, alert.getAlertTypeID());
            stmt.setTimestamp(4, alert.getAlertTime());
            stmt.setString(5, alert.getEmail());
            stmt.setString(6, alert.getPhone());
            stmt.setInt(7, alert.getAlertID());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteAlert(int alertID) throws SQLException {
        String sql = "DELETE FROM Alert WHERE alertID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, alertID);
            stmt.executeUpdate();
        }
    }

    private boolean alertExists(int alertID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Alert WHERE alertID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, alertID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    
    public void insertAlert(Alert alert) throws SQLException {
        addAlert(alert);
    }
}

