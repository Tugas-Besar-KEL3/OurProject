/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entity.data_mapel;
import Error.data_mapelException;
import Service.data_mapelDao;
import database.medikacomDatabase;
import java.sql.SQLException;
import java.util.List;

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
        dao.deleteData_mapel("A8899");
        /*
        data_mapel data_mapel = dao.getData_mapel("A7543");
        System.out.println("ID PENGAJAR : "+data_mapel.getIdpengajar());
        System.out.println("MATA PELAJARAN : "+data_mapel.getMapel());
        System.out.println("PROG. KEAHLIAN : "+data_mapel.getPkeahlian());
        System.out.println("KURIKULUM : "+data_mapel.getKurikulum());
        /*
        List<data_mapel> list = dao.selectAllData_mapel();
        for (data_mapel data_mapel : list) {
            System.out.println("KODEMAPEL : " + data_mapel.getKodemapel());
            System.out.println("IDPENGAJAR : " + data_mapel.getIdpengajar());
            System.out.println("MAPEL : " + data_mapel.getMapel());
            System.out.println("PROG.KEAHLIAN : " + data_mapel.getPkeahlian());
            System.out.println("KURIKULUM : " + data_mapel.getKurikulum());
            System.out.println("----------------------------------------");
        */
        }
    }

