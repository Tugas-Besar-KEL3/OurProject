/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Entity.data_mapel;
import Exception.data_mapelException;
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

    private final String insertData_mapel = "INSERT INTO DATA_MAPEL (KODE_MAPEL, MAPEL, PROG_KEAHLIAN, KELAS, KURIKULUM) VALUES (?????)";

    @Override
    public void insertData_mapel(data_mapel data_mapel) throws data_mapelException {

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(insertData_mapel);
            statement.setString(1, data_mapel.getKode_mapel());
            statement.setString(2, data_mapel.getMapel());
            statement.setString(3, data_mapel.getProg_keahlian());
            statement.setString(4, data_mapel.getKelas());
            statement.setString(5, data_mapel.getKurikulum());
            statement.executeUpdate();
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

    @Override
    public void updateData_mapel(data_mapel data_mapel) throws data_mapelException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteData_mapel(String kode_mapel) throws data_mapelException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                data_mapel.setKode_mapel(result.getString("KODE_MAPEL"));
                data_mapel.setMapel(result.getString("MAPEL"));
                data_mapel.setProg_keahlian(result.getString("PROG_KEAHLIAN"));
                data_mapel.setKelas(result.getString("KELAS"));
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
}
