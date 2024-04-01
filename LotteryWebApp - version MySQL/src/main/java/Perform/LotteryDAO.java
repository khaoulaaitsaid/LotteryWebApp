package Perform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LotteryDAO {
    private Connection connection;

    public LotteryDAO() throws SQLException {
        connection = DBManager.getConnection();
    }

    public void addWinner(LotteryWinner winner) throws SQLException {
        String sql = "INSERT INTO winners (first_name, last_name, amount) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, winner.getFirstName());
            statement.setString(2, winner.getLastName());
            statement.setDouble(3, winner.getAmount());
            statement.executeUpdate();
        }
    }

    public List<LotteryWinner> getAllWinners() throws SQLException {
        List<LotteryWinner> winners = new ArrayList<>();
        String sql = "SELECT * FROM winners";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                double amount = resultSet.getDouble("amount");
                winners.add(new LotteryWinner(firstName, lastName, amount));
            }
        }
        return winners;
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
