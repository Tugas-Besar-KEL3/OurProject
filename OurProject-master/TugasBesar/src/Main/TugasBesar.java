/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entity.data_mapel;
import Exception.data_mapelException;
import Service.data_mapelDao;
import database.medikacomDatabase;
import java.sql.SQLException;

/**
 *
 * @author MY PC
 */
public class TugasBesar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, data_mapelException {
        // TODO code application logic here
        data_mapelDao dao = medikacomDatabase.getData_mapelDao();
        data_mapel data_mapel= new data_mapel();
        data_mapel.setKode_mapel("12345");
        data_mapel.setMapel("SBD");
        data_mapel.setProg_keahlian("RPL");
        data_mapel.setKelas("RPL XII-B");
        data_mapel.setKurikulum("2013");
        
        dao.insertData_mapel(data_mapel);
    }

}
