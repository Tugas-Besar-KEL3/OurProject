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
public class data_mapel {

    private String kode_mapel;
    private String mapel;
    private String prog_keahlian;
    private String kelas;
    private String kurikulum;

    public data_mapel() {

    }

    public data_mapel(String kode_mapel, String mapel, String prog_keahlian, String kelas, String kurikulum) {
        this.kode_mapel = kode_mapel;
        this.mapel = mapel;
        this.prog_keahlian = prog_keahlian;
        this.kelas = kelas;
        this.kurikulum = kurikulum;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.kode_mapel);
        hash = 73 * hash + Objects.hashCode(this.mapel);
        hash = 73 * hash + Objects.hashCode(this.prog_keahlian);
        hash = 73 * hash + Objects.hashCode(this.kelas);
        hash = 73 * hash + Objects.hashCode(this.kurikulum);
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
        final data_mapel other = (data_mapel) obj;
        if (!Objects.equals(this.kode_mapel, other.kode_mapel)) {
            return false;
        }
        if (!Objects.equals(this.mapel, other.mapel)) {
            return false;
        }
        if (!Objects.equals(this.prog_keahlian, other.prog_keahlian)) {
            return false;
        }
        if (!Objects.equals(this.kelas, other.kelas)) {
            return false;
        }
        if (!Objects.equals(this.kurikulum, other.kurikulum)) {
            return false;
        }
        return true;
    }

    public String getKode_mapel() {
        return kode_mapel;
    }

    public void setKode_mapel(String kode_mapel) {
        this.kode_mapel = kode_mapel;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getProg_keahlian() {
        return prog_keahlian;
    }

    public void setProg_keahlian(String prog_keahlian) {
        this.prog_keahlian = prog_keahlian;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKurikulum() {
        return kurikulum;
    }

    public void setKurikulum(String kurikulum) {
        this.kurikulum = kurikulum;
    }

}
