package alertType;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlertTypeDAOImp implements AlertTypeDao {
    private final Connection connection;

    public AlertTypeDAOImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addAlertType(AlertType alertType) throws SQLException {
        String sql = "INSERT INTO AlertType (alertTypeID, alertTypeName) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, alertType.getAlertTypeID());
            stmt.setString(2, alertType.getAlertTypeName());
            stmt.executeUpdate();
        }
    }

    @Override
    public AlertType getAlertType(int alertTypeID) throws SQLException {
        String sql = "SELECT * FROM AlertType WHERE alertTypeID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, alertTypeID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new AlertType(
                        rs.getInt("alertTypeID"),
                        rs.getString("alertTypeName")
                    );
                }
            }
        }
        return null;
    }
}


