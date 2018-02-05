/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.data_nilai;
import Error.data_nilaiException;
import Event.Data_nilaiListener;
import Service.data_nilaiDao;
import database.medikacomDatabase;
import java.sql.SQLException;

/**
 *
 * @author MY PC
 */
public class Data_nilaiModel {
    
    private int nis;
    private String kodemapel;
    private int uts;
    private int uas;
    private Data_nilaiListener listener;
    
    public Data_nilaiListener getListener() {
        return listener;
    }
    
    public void setListener(Data_nilaiListener listener) {
        this.listener = listener;
    }
    
    public int getNis() {
        return nis;
    }
    
    public void setNis(int nis) {
        this.nis = nis;
    }
    
    public String getKodemapel() {
        return kodemapel;
    }
    
    public void setKodemapel(String kodemapel) {
        this.kodemapel = kodemapel;
    }
    
    public int getUts() {
        return uts;
    }
    
    public void setUts(int uts) {
        this.uts = uts;
    }
    
    public int getUas() {
        return uas;
    }
    
    public void setUas(int uas) {
        this.uas = uas;
    }
    
    protected void FireOnInsert(data_nilai data_nilai) {
        if (listener != null) {
            listener.onInsert(data_nilai);
        }
    }
    
    protected void FireOnUpdate(data_nilai data_nilai) {
        if (listener != null) {
            listener.onUpdate(data_nilai);
        }
    }
    
    protected void FireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertData_nilai() throws SQLException, data_nilaiException {
        data_nilaiDao dao = medikacomDatabase.getData_nilaiDao();
        data_nilai data_nilai = new data_nilai();
        data_nilai.setNis(nis);
        data_nilai.setKodemapel(kodemapel);
        data_nilai.setUts(uts);
        data_nilai.setUas(uas);
        dao.insertData_nilai(data_nilai);
        FireOnInsert(data_nilai);
    }
    
    public void updateData_nilai() throws SQLException, data_nilaiException {
        data_nilaiDao dao = medikacomDatabase.getData_nilaiDao();
        data_nilai data_nilai = new data_nilai();
        data_nilai.setNis(nis);
        data_nilai.setKodemapel(kodemapel);
        data_nilai.setUts(uts);
        data_nilai.setUas(uas);
        dao.updateData_nilai(data_nilai);
        FireOnUpdate(data_nilai);
    }
    
    public void deleteData_nilai() throws SQLException, data_nilaiException {
        data_nilaiDao dao = medikacomDatabase.getData_nilaiDao();
        dao.deleteData_nilai(nis);
        FireOnDelete();
    }
    
    public void resetData_nilai() {
        setNis('0');
        setKodemapel("");
        setUts('0');
        setUas('0');
    }
}
