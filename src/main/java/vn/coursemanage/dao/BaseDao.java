package vn.coursemanage.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.coursemanage.config.DataSource;
import vn.coursemanage.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao {
    private static final Logger LOGGER = LogManager.getLogger(BaseDao.class);

    private Connection getConnection() {
        return DataSource.getConnection();
    }

    private void setStatement(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long param) {
                    statement.setLong(index, param);
                } else if (parameter instanceof String param) {
                    statement.setString(index, param);
                } else if (parameter instanceof Integer param) {
                    statement.setInt(index, param);
                } else if (parameter instanceof Double param) {
                    statement.setDouble(index, param);
                } else if (parameter instanceof Float param) {
                    statement.setFloat(index, param);
                } else if (parameter instanceof Timestamp param) {
                    statement.setTimestamp(index, param);
                } else if (parameter instanceof Float param) {
                    statement.setFloat(index, param);
                } else if (parameter instanceof java.util.Date param) {
                    java.sql.Date sqlDate = new java.sql.Date((param).getTime());
                    statement.setDate(index, sqlDate);
                } else {
                    statement.setNull(index, Types.NULL);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setStatement(statement, parameters);
            LOGGER.info(statement.toString());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    protected Integer insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Integer id = null;
            connection = getConnection();
            System.out.println(connection);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setStatement(statement, parameters);
            LOGGER.info(statement.toString());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    protected void update(String sql, Object... parameter) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setStatement(statement, parameter);
            LOGGER.info(statement.toString());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

}
