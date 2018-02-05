/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author MY PC
 */
public class data_siswa {

    private Integer nis;
    private String nama;
    private String kelas;
    private String jk;
    private String ttl;
    private String alamat;
    private Integer nohp;

    public data_siswa() {
    }

    public data_siswa(Integer nis, String nama, String kelas, String jk, String ttl, String alamat, Integer nohp) {
        this.nis = nis;
        this.nama = nama;
        this.kelas = kelas;
        this.jk = jk;
        this.ttl = ttl;
        this.alamat = alamat;
        this.nohp = nohp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.nis);
        hash = 17 * hash + Objects.hashCode(this.nama);
        hash = 17 * hash + Objects.hashCode(this.kelas);
        hash = 17 * hash + Objects.hashCode(this.jk);
        hash = 17 * hash + Objects.hashCode(this.ttl);
        hash = 17 * hash + Objects.hashCode(this.alamat);
        hash = 17 * hash + Objects.hashCode(this.nohp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final data_siswa other = (data_siswa) obj;
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.kelas, other.kelas)) {
            return false;
        }
        if (!Objects.equals(this.jk, other.jk)) {
            return false;
        }
        if (!Objects.equals(this.ttl, other.ttl)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        if (!Objects.equals(this.nis, other.nis)) {
            return false;
        }
        if (!Objects.equals(this.nohp, other.nohp)) {
            return false;
        }
        return true;
    }

    public Integer getNis() {
        return nis;
    }

    public void setNis(Integer nis) {
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

}
