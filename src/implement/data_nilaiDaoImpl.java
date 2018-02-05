/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Entity.data_nilai;
import Entity.data_siswa;
import Error.data_nilaiException;
import Service.data_nilaiDao;
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
public class data_nilaiDaoImpl implements data_nilaiDao {

    private Connection connection;

    public data_nilaiDaoImpl(Connection connection) {
        this.connection = connection;
    }

    private final String insertData_nilai = "INSERT INTO DATA_NILAI VALUES (?,?,?,?)";

    @Override
    public void insertData_nilai(data_nilai data_nilai) throws data_nilaiException {
        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertData_nilai);
            statement.setInt(1, data_nilai.getNis());
            statement.setString(2, data_nilai.getKodemapel());
            statement.setInt(3, data_nilai.getUts());
            statement.setInt(4, data_nilai.getUas());
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_nilaiException(exception.getMessage());
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

    private final String updateData_nilai = "UPDATE DATA_NILAI SET KODEMAPEL=?,UTS=?,UAS=? WHERE NIS=?";

    @Override
    public void updateData_nilai(data_nilai data_nilai) throws data_nilaiException {
        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateData_nilai);
            statement.setString(1, data_nilai.getKodemapel());
            statement.setInt(2, data_nilai.getUts());
            statement.setInt(3, data_nilai.getUas());

            statement.setInt(4, data_nilai.getNis());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_nilaiException(e.getMessage());
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
    private final String deleteData_nilai = "DELETE FROM DATA_NILAI WHERE NIS=?";

    @Override
    public void deleteData_nilai(Integer nis) throws data_nilaiException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteData_nilai);
            statement.setInt(1, nis);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_nilaiException(e.getMessage());
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
    private final String selectAllData_nilai = "SELECT * FROM DATA_NILAI";

    @Override
    public List<data_nilai> selectAllData_nilai() throws data_nilaiException {
        Statement statement = null;
        List<data_nilai> list = new ArrayList<data_nilai>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllData_nilai);
            while (result.next()) {
                data_nilai data_nilai = new data_nilai();
                data_nilai.setNis(result.getInt("NIS"));
                data_nilai.setKodemapel(result.getString("KODEMAPEL"));
                data_nilai.setUts(result.getInt("UTS"));
                data_nilai.setUas(result.getInt("UAS"));

                list.add(data_nilai);
            }
            return list;
        } catch (SQLException exception) {
            throw new data_nilaiException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {

                }
            }
        }
    }
    private final String getByNis = "SELECT * FROM DATA_NILAI WHERE NIS = ?";

    @Override
    public data_nilai getData_nilai(Integer nis) throws data_nilaiException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByNis);
            statement.setInt(1, nis);

            ResultSet result = statement.executeQuery();
            data_nilai data_nilai = null;
            if (result.next()) {
                data_nilai = new data_nilai();
                data_nilai.setNis(result.getInt("NIS"));
                data_nilai.setKodemapel(result.getString("KODE_MAPEL"));
                data_nilai.setUts(result.getInt("UTS"));
                data_nilai.setUas(result.getInt("UAS"));
            } else {
                throw new data_nilaiException("Data nilai dengan NIS "
                        + nis + " tidak ditemukan!");
            }
            connection.commit();
            return data_nilai;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_nilaiException(e.getMessage());
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
