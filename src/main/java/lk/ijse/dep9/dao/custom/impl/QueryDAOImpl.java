package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.QueryDAO;
import lk.ijse.dep9.dao.util.ConnectionUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
@Component
@Scope("request")
public class QueryDAOImpl implements QueryDAO {

    private final Connection connection;

    public QueryDAOImpl() {
        this.connection = ConnectionUtil.getConnection();
    }
}
