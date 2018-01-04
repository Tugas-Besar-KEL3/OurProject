/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Service.data_mapelDao;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import implement.data_mapelDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MY PC
 */
public class medikacomDatabase {

    private static Connection connection;

    private static data_mapelDao data_mapelDao;

    public static data_mapelDao getData_mapelDao() throws SQLException {
        if (data_mapelDao == null) {
            data_mapelDao = new data_mapelDaoImpl(getConnection());
        }
        return data_mapelDao;
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/medikacom");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
            System.out.println("Konek cuy!");
        }
        return connection;
    }
}
