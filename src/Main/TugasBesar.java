/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entity.data_mapel;
import Entity.data_pengajar;
import Error.data_mapelException;
import Error.data_nilaiException;
import Error.data_pengajarException;
import Error.data_siswaException;
import Service.data_mapelDao;
import Service.data_pengajarDao;
import View.MainViewPengajar;
import database.medikacomDatabase;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

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
        /*
        dao1.deleteData_pengajar(876123);
         */

 /*
        data_pengajar data_pengajar = dao1.getData_pengajar(912247);
        System.out.println("NAMA : " + data_pengajar.getNama());
         */
 /*
        List<data_pengajar> list = dao1.selectAllData_pengajar();
        for (data_pengajar data_pengajar : list) {
            System.out.println("IDPENGAJAR : " + data_pengajar.getIdpengajar());
            System.out.println("NAMA : "+data_pengajar.getNama());
            System.out.println("JK : "+data_pengajar.getJk());
            System.out.println("----------------------------------------");
         */
 /*
        data_pengajar data_pengajar = dao1.getData_pengajar(876123);
        data_pengajar.setNama("Rizki Wurtzbach");
        data_pengajar.setJk("L");
        dao1.updateData_pengajar(data_pengajar);
         */
    }
}
