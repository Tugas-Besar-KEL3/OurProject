/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Entity.data_pengajar;
import Entity.data_siswa;
import Error.data_siswaException;
import Service.data_siswaDao;
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
public class data_siswaDaoImpl implements data_siswaDao {

    private Connection connection;

    public data_siswaDaoImpl(Connection connection) {
        this.connection = connection;
    }

    private final String insertData_siswa = "INSERT INTO DATA_SISWA VALUES (?,?,?,?,?,?,?)";

    @Override
    public void insertData_siswa(data_siswa data_siswa) throws data_siswaException {

        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertData_siswa);
            statement.setInt(1, data_siswa.getNis());
            statement.setString(2, data_siswa.getNama());
            statement.setString(3, data_siswa.getKelas());
            statement.setString(4, data_siswa.getJk());
            statement.setString(5, data_siswa.getTtl());
            statement.setString(6, data_siswa.getAlamat());
            statement.setInt(7, data_siswa.getNohp());
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_siswaException(exception.getMessage());
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
    private final String updateData_siswa = "UPDATE DATA_SISWA SET NAMA=?,KELAS=?,JK=?,TTL=?,ALAMAT=?,NOHP=? WHERE NIS=?";

    @Override
    public void updateData_siswa(data_siswa data_siswa) throws data_siswaException {

        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateData_siswa);
            statement.setString(1, data_siswa.getNama());
            statement.setString(2, data_siswa.getKelas());
            statement.setString(3, data_siswa.getJk());
            statement.setString(4, data_siswa.getTtl());
            statement.setString(5, data_siswa.getAlamat());
            statement.setInt(6, data_siswa.getNohp());

            statement.setInt(7, data_siswa.getNis());
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_siswaException(exception.getMessage());
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
    private final String deleteData_siswa = "DELETE FROM DATA_SISWA WHERE NIS=?";

    @Override
    public void deleteData_siswa(Integer nis) throws data_siswaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteData_siswa);
            statement.setInt(1, nis);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_siswaException(e.getMessage());
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

    private final String selectAll = "SELECT * FROM DATA_SISWA";

    @Override
    public List<data_siswa> selectAllData_siswa() throws data_siswaException {
        Statement statement = null;
        List<data_siswa> list = new ArrayList<data_siswa>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                data_siswa data_siswa = new data_siswa();
                data_siswa.setNis(result.getInt("NIS"));
                data_siswa.setNama(result.getString("NAMA"));
                data_siswa.setKelas(result.getString("KELAS"));
                data_siswa.setJk(result.getString("JK"));
                data_siswa.setTtl(result.getString("TTL"));
                data_siswa.setAlamat(result.getString("ALAMAT"));
                data_siswa.setNohp(result.getInt("NOHP"));

                list.add(data_siswa);
            }
            return list;
        } catch (SQLException exception) {
            throw new data_siswaException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {

                }
            }
        }
    }
    private final String getByNis = "SELECT * FROM DATA_SISWA WHERE NIS = ?";

    @Override
    public data_siswa getData_siswa(Integer nis) throws data_siswaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByNis);
            statement.setInt(1, nis);

            ResultSet result = statement.executeQuery();
            data_siswa data_siswa = null;
            if (result.next()) {
                data_siswa = new data_siswa();
                data_siswa.setNis(result.getInt("NIS"));
                data_siswa.setNama(result.getString("NAMA"));
                data_siswa.setKelas(result.getString("KELAS"));
                data_siswa.setJk(result.getString("JK"));
                data_siswa.setTtl(result.getString("TTL"));
                data_siswa.setAlamat(result.getString("ALAMAT"));
                data_siswa.setNohp(result.getInt("NOHP"));
            } else {
                throw new data_siswaException("Data siswa dengan nis "
                        + nis + " tidak ditemukan");
            }
            connection.commit();
            return data_siswa;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new data_siswaException(e.getMessage());
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
