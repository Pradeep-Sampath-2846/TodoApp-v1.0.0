package lk.ijse.dep9.app.dao.custom.impl;

import lk.ijse.dep9.app.dao.custom.QueryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
@Component

public class QueryDAOImpl implements QueryDAO {

    private JdbcTemplate jdbc;

    public QueryDAOImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
