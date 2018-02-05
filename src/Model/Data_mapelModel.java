/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.data_mapel;
import Error.data_mapelException;
import Event.Data_mapelListener;
import Service.data_mapelDao;
import database.medikacomDatabase;
import java.sql.SQLException;

/**
 *
 * @author MY PC
 */
public class Data_mapelModel {

    private String kodemapel;
    private int idpengajar;
    private String mapel;
    private String pkeahlian;
    private String kurikulum;
    private Data_mapelListener listener;

    public Data_mapelListener getListener() {
        return listener;
    }

    public void setListener(Data_mapelListener listener) {
        this.listener = listener;
    }

    public String getKodemapel() {
        return kodemapel;
    }

    public void setKodemapel(String kodemapel) {
        this.kodemapel = kodemapel;
    }

    public int getIdpengajar() {
        return idpengajar;
    }

    public void setIdpengajar(int idpengajar) {
        this.idpengajar = idpengajar;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getPkeahlian() {
        return pkeahlian;
    }

    public void setPkeahlian(String pkeahlian) {
        this.pkeahlian = pkeahlian;
    }

    public String getKurikulum() {
        return kurikulum;
    }

    public void setKurikulum(String kurikulum) {
        this.kurikulum = kurikulum;
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(data_mapel data_mapel) {
        if (listener != null) {
            listener.onInsert(data_mapel);
        }
    }

    protected void fireOnUpdate(data_mapel data_mapel) {
        if (listener != null) {
            listener.onUpdate(data_mapel);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertData_mapel() throws SQLException, data_mapelException {
        data_mapelDao dao = medikacomDatabase.getData_mapelDao();

        data_mapel data_mapel = new data_mapel();
        data_mapel.setKodemapel(kodemapel);
        data_mapel.setIdpengajar(idpengajar);
        data_mapel.setMapel(mapel);
        data_mapel.setPkeahlian(pkeahlian);
        data_mapel.setKurikulum(kurikulum);

        dao.insertData_mapel(data_mapel);
        fireOnInsert(data_mapel);

    }

    public void updateData_mapel() throws SQLException, data_mapelException {
        data_mapelDao dao = medikacomDatabase.getData_mapelDao();

        data_mapel data_mapel = new data_mapel();
        data_mapel.setKodemapel(kodemapel);
        data_mapel.setIdpengajar(idpengajar);
        data_mapel.setMapel(mapel);
        data_mapel.setPkeahlian(pkeahlian);
        data_mapel.setKurikulum(kurikulum);

        dao.updateData_mapel(data_mapel);
        fireOnUpdate(data_mapel);
    }

    public void deleteData_mapel() throws SQLException, data_mapelException {

        data_mapelDao dao = medikacomDatabase.getData_mapelDao();
        dao.deleteData_mapel(kodemapel);
        fireOnDelete();
    }

    public void resetData_mapel() {
        setKodemapel("");
        setIdpengajar(0);
        setMapel("");
        setPkeahlian("");
        setKurikulum("");

    }
}
