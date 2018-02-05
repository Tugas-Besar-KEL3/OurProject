/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.data_siswa;
import Error.data_siswaException;
import Event.Data_siswaListener;
import Service.data_siswaDao;
import database.medikacomDatabase;
import java.sql.SQLException;

/**
 *
 * @author MY PC
 */
public class Data_siswaModel {

    private int nis;
    private String nama;
    private String kelas;
    private String jk;
    private String ttl;
    private String alamat;
    private int nohp;
    private Data_siswaListener listener;

    public Data_siswaListener getListener() {
        return listener;
    }

    public void setListener(Data_siswaListener listener) {
        this.listener = listener;
    }

    public int getNis() {
        return nis;
    }

    public void setNis(int nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getNohp() {
        return nohp;
    }

    public void setNohp(Integer nohp) {
        this.nohp = nohp;
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(data_siswa data_siswa) {
        if (listener != null) {
            listener.onInsert(data_siswa);
        }
    }

    protected void fireOnUpdate(data_siswa data_siswa) {
        if (listener != null) {
            listener.onUpdate(data_siswa);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertData_siswa() throws SQLException, data_siswaException {
        data_siswaDao dao = medikacomDatabase.getData_siswaDao();

        data_siswa data_siswa = new data_siswa();
        data_siswa.setNis(nis);
        data_siswa.setNama(nama);
        data_siswa.setKelas(kelas);
        data_siswa.setJk(jk);
        data_siswa.setTtl(ttl);
        data_siswa.setAlamat(alamat);
        data_siswa.setNohp(nohp);

        dao.insertData_siswa(data_siswa);
        fireOnInsert(data_siswa);

    }

    public void updateData_siswa() throws SQLException, data_siswaException {
        data_siswaDao dao = medikacomDatabase.getData_siswaDao();

        data_siswa data_siswa = new data_siswa();
        data_siswa.setNis(nis);
        data_siswa.setNama(nama);
        data_siswa.setKelas(kelas);
        data_siswa.setJk(jk);
        data_siswa.setTtl(ttl);
        data_siswa.setAlamat(alamat);
        data_siswa.setNohp(nohp);

        dao.updateData_siswa(data_siswa);
        fireOnUpdate(data_siswa);

    }

    public void deleteData_siswa() throws SQLException, data_siswaException {

        data_siswaDao dao = medikacomDatabase.getData_siswaDao();
        dao.deleteData_siswa(nis);
        fireOnDelete();
    }
    
    public void resetData_siswa() {
        setNis(0);
        setNama("");
        setKelas("");
        setTtl("");
        setAlamat("");
        setNohp(0);
    }
}
