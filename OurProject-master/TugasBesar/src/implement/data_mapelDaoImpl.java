/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Entity.data_mapel;
import Error.data_mapelException;
import Service.data_mapelDao;
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
public class data_mapelDaoImpl implements data_mapelDao {

    private Connection connection;

    public data_mapelDaoImpl(Connection connection) {
        this.connection = connection;
    }

    private final String insertData_mapel = "INSERT INTO DATA_MAPEL VALUES (?,?,?,?,?)";

    @Override
    public void insertData_mapel(data_mapel data_mapel) throws data_mapelException {

        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertData_mapel);
            statement.setString(1, data_mapel.getKodemapel());
            statement.setInt(2, data_mapel.getIdpengajar());
            statement.setString(3, data_mapel.getMapel());
            statement.setString(4, data_mapel.getPkeahlian());
            statement.setString(5, data_mapel.getKurikulum());
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_mapelException(exception.getMessage());
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

    private final String updateData_mapel = "UPDATE DATA_MAPEL SET IDPENGAJAR=?,MAPEL=?,PKEAHLIAN=?,KURIKULUM=? WHERE KODEMAPEL=?";

    @Override
    public void updateData_mapel(data_mapel data_mapel) throws data_mapelException {
        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateData_mapel);
            statement.setInt(1, data_mapel.getIdpengajar());
            statement.setString(2, data_mapel.getMapel());
            statement.setString(3, data_mapel.getPkeahlian());
            statement.setString(4, data_mapel.getKurikulum());

            statement.setString(5, data_mapel.getKodemapel());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_mapelException(e.getMessage());
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

    private final String deleteData_mapel = "DELETE FROM DATA_MAPEL WHERE KODEMAPEL=?";

    @Override
    public void deleteData_mapel(String kodemapel) throws data_mapelException {
          PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteData_mapel);
            statement.setString(1, kodemapel);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_mapelException(e.getMessage());
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

    private final String selectAll = "SELECT * FROM DATA_MAPEL";

    @Override
    public List<data_mapel> selectAllData_mapel() throws data_mapelException {
        Statement statement = null;
        List<data_mapel> list = new ArrayList<data_mapel>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                data_mapel data_mapel = new data_mapel();
                data_mapel.setKodemapel(result.getString("KODEMAPEL"));
                data_mapel.setIdpengajar(result.getInt("IDPENGAJAR"));
                data_mapel.setMapel(result.getString("MAPEL"));
                data_mapel.setPkeahlian(result.getString("PKEAHLIAN"));
                data_mapel.setKurikulum(result.getString("KURIKULUM"));

                list.add(data_mapel);
            }
            return list;
        } catch (SQLException exception) {
            throw new data_mapelException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {

                }
            }
        }
    }
    private final String getByKodeMapel = "SELECT * FROM DATA_MAPEL WHERE KODEMAPEL = ?";

    @Override
    public data_mapel getData_mapel(String kodemapel) throws data_mapelException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByKodeMapel);
            //indeks ke 1, isinya ID dari parameter
            statement.setString(1, kodemapel);

            ResultSet result = statement.executeQuery();
            data_mapel data_mapel = null;
            if (result.next()) {
                data_mapel = new data_mapel();
                data_mapel.setKodemapel(result.getString("KODEMAPEL"));
                data_mapel.setIdpengajar(result.getInt("IDPENGAJAR"));
                data_mapel.setMapel(result.getString("MAPEL"));
                data_mapel.setPkeahlian(result.getString("PKEAHLIAN"));
                data_mapel.setKurikulum(result.getString("KURIKULUM"));
            } else {
                throw new data_mapelException("Data Mapel dengan kode mapel "
                        + kodemapel + " tidak ditemukan");
            }
            connection.commit();
            return data_mapel;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_mapelException(e.getMessage());
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
