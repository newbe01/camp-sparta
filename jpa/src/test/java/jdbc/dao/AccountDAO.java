package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.vo.AccountVO;

public class AccountDAO {

    private Connection conn = null;

    private PreparedStatement stmt = null;

    private ResultSet rs = null;

    private static final String url = "jdbc:postgresql://localhost:5432/messenger";
    private static final String username = "root";
    private static final String password = "1234";

    private final String ACCOUNT_INSERT = "INSERT INTO ACCOUNT (id, username, password) VALUES ((SELECT coalesce(MAX(ID), 0) + 1 FROM ACCOUNT A), ?, ?)";
    private final String ACCOUNT_SELECT = "SELECT * FROM ACCOUNT WHERE ID = ?";

    public Integer insertAccount(AccountVO vo) {
        var id = -1;

        try {
            String[] returnId = {"id"};
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement(ACCOUNT_INSERT, returnId);
            stmt.setString(1, vo.getUsername());
            stmt.setString(2, vo.getPassword());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public AccountVO selectAccount(Integer id) {

        AccountVO vo = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement(ACCOUNT_SELECT);
            stmt.setInt(1, id);
            var rs = stmt.executeQuery();

            if (rs.next()) {
                vo = new AccountVO();
                vo.setId(rs.getInt("ID"));
                vo.setUsername(rs.getString("USERNAME"));
                vo.setPassword(rs.getString("PASSWORD"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vo;
    }

}
