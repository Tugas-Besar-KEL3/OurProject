/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Entity.data_pengajar;
import Error.data_pengajarException;
import Service.data_pengajarDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MY PC
 */
public class data_pengajarDaoImpl implements data_pengajarDao {

    private Connection connection;

    public data_pengajarDaoImpl(Connection connection) {
        this.connection = connection;
    }

    private final String insertData_pengajar = "INSERT INTO DATA_PENGAJAR VALUES (?,?,?)";

    @Override
    public void insertData_pengajar(data_pengajar data_pengajar) throws data_pengajarException {

        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertData_pengajar);
            statement.setInt(1, data_pengajar.getIdpengajar());
            statement.setString(2, data_pengajar.getNama());
            statement.setString(3, data_pengajar.getJk());
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_pengajarException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    private final String updateData_pengajar = "UPDATE DATA_PENGAJAR SET NAMA=?,JK=? WHERE IDPENGAJAR=?";

    @Override
    public void updateData_pengajar(data_pengajar data_pengajar) throws data_pengajarException {
        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateData_pengajar);
            statement.setString(1, data_pengajar.getNama());
            statement.setString(2, data_pengajar.getJk());

            statement.setInt(3, data_pengajar.getIdpengajar());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_pengajarException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    private final String deleteData_pengajar = "DELETE FROM DATA_PENGAJAR WHERE IDPENGAJAR=?";

    @Override
    public void deleteData_pengajar(Integer idpengajar) throws data_pengajarException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteData_pengajar);
            statement.setInt(1, idpengajar);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_pengajarException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    private final String selectAll = "SELECT * FROM DATA_PENGAJAR";

    @Override
    public List<data_pengajar> selectAllData_pengajar() throws data_pengajarException {
        Statement statement = null;
        List<data_pengajar> list = new ArrayList<data_pengajar>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                data_pengajar data_pengajar = new data_pengajar();
                data_pengajar.setIdpengajar(result.getInt("IDPENGAJAR"));
                data_pengajar.setNama(result.getString("NAMA"));
                data_pengajar.setJk(result.getString("JK"));

                list.add(data_pengajar);
            }
            return list;
        } catch (SQLException exception) {
            throw new data_pengajarException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {

                }
            }
        }
    }
    private final String getByIdpengajar = "SELECT * FROM DATA_PENGAJAR WHERE IDPENGAJAR = ?";

    @Override
    public data_pengajar getData_pengajar(Integer idpengajar) throws data_pengajarException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByIdpengajar);
            statement.setInt(1, idpengajar);

            ResultSet result = statement.executeQuery();
            data_pengajar data_pengajar = null;
            if (result.next()) {
                data_pengajar = new data_pengajar();
                data_pengajar.setIdpengajar(result.getInt("IDPENGAJAR"));
                data_pengajar.setNama(result.getString("NAMA"));
                data_pengajar.setJk(result.getString("JK"));
            } else {
                throw new data_pengajarException("Data pengajar dengan ID pengajar "
                        + idpengajar + " tidak ditemukan");
            }
            connection.commit();
            return data_pengajar;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_pengajarException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
}

}
