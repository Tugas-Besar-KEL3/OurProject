/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.data_pengajar;
import Error.data_pengajarException;
import Event.Data_pengajarListener;
import Service.data_pengajarDao;
import database.medikacomDatabase;
import java.sql.SQLException;

/**
 *
 * @author MY PC
 */
public class Data_pengajarModel {

    private int idpengajar;
    private String nama;
    private String jk;
    private Data_pengajarListener listener;

    public Data_pengajarListener getListener() {
        return listener;
    }

    public void setListener(Data_pengajarListener listener) {
        this.listener = listener;
    }

    public int getIdpengajar() {
        return idpengajar;
    }

    public void setIdpengajar(int idpengajar) {
        this.idpengajar = idpengajar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(data_pengajar data_pengajar) {
        if (listener != null) {
            listener.onInsert(data_pengajar);
        }
    }

    protected void fireOnUpdate(data_pengajar data_pengajar) {
        if (listener != null) {
            listener.onUpdate(data_pengajar);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertData_pengajar() throws SQLException, data_pengajarException {
        data_pengajarDao dao = medikacomDatabase.getData_pengajarDao();

        data_pengajar data_pengajar = new data_pengajar();
        data_pengajar.setIdpengajar(idpengajar);
        data_pengajar.setNama(nama);
        data_pengajar.setJk(jk);

        dao.insertData_pengajar(data_pengajar);
        fireOnInsert(data_pengajar);

    }

    public void updateData_pengajar() throws SQLException, data_pengajarException {
        data_pengajarDao dao = medikacomDatabase.getData_pengajarDao();

        data_pengajar data_pengajar = new data_pengajar();
        data_pengajar.setIdpengajar(idpengajar);
        data_pengajar.setNama(nama);
        data_pengajar.setJk(jk);

        dao.updateData_pengajar(data_pengajar);
        fireOnUpdate(data_pengajar);
    }

    public void deleteData_pengajar() throws SQLException, data_pengajarException {

        data_pengajarDao dao = medikacomDatabase.getData_pengajarDao();
        dao.deleteData_pengajar(idpengajar);
        fireOnDelete();
    }

    public void resetData_pengajar() {
        setIdpengajar(0);
        setNama("");
        setJk("");
    }
}
