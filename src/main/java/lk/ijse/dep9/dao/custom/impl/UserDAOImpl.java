package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.dao.util.ConnectionUtil;
import lk.ijse.dep9.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    private final Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User save(User user) {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO User (username, full_name, password) VALUES (?,?,?)");
            stm.setString(1,user.getUsername());
            stm.setString(2,user.getFullName());
            stm.setString(3,user.getPassword());

            stm.executeUpdate();
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(String pk) {

    }

    @Override
    public Optional<User> findById(String pk) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existById(String pk) {
        return false;
    }
}
