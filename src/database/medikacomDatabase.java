/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Service.data_mapelDao;
import Service.data_nilaiDao;
import Service.data_pengajarDao;
import Service.data_siswaDao;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import implement.data_mapelDaoImpl;
import implement.data_nilaiDaoImpl;
import implement.data_pengajarDaoImpl;
import implement.data_siswaDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MY PC
 */
public class medikacomDatabase {

    private static Connection connection;

    private static data_mapelDao data_mapelDao;

    private static data_pengajarDao data_pengajarDao;

    private static data_siswaDao data_siswaDao;

    private static data_nilaiDao data_nilaiDao;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/medikacom");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
    }

    public static data_mapelDao getData_mapelDao() throws SQLException {
        if (data_mapelDao == null) {
            data_mapelDao = new data_mapelDaoImpl(getConnection());
        }
        return data_mapelDao;
    }

    public static data_pengajarDao getData_pengajarDao() throws SQLException {
        if (data_pengajarDao == null) {
            data_pengajarDao = new data_pengajarDaoImpl(getConnection());
        }
        return data_pengajarDao;
    }

    public static data_siswaDao getData_siswaDao() throws SQLException {
        if (data_siswaDao == null) {
            data_siswaDao = new data_siswaDaoImpl(getConnection());
        }
        return data_siswaDao;
    }

    public static data_nilaiDao getData_nilaiDao() throws SQLException {
        if (data_nilaiDao == null) {
            data_nilaiDao = new data_nilaiDaoImpl(getConnection());
        }
        return data_nilaiDao;
    }

    public static Connection getConnection(String jdbcmysqllocalhostnama_database, String root, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

