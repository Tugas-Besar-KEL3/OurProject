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
public class data_pengajar {

    private Integer idpengajar;
    private String nama;
    private String jk;

    public data_pengajar() {

    }

    public data_pengajar(Integer idpengajar, String nama, String jk) {
        this.idpengajar = idpengajar;
        this.nama = nama;
        this.jk = jk;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.idpengajar);
        hash = 19 * hash + Objects.hashCode(this.nama);
        hash = 19 * hash + Objects.hashCode(this.jk);
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
        final data_pengajar other = (data_pengajar) obj;
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.jk, other.jk)) {
            return false;
        }
        if (!Objects.equals(this.idpengajar, other.idpengajar)) {
            return false;
        }
        return true;
    }

    public Integer getIdpengajar() {
        return idpengajar;
    }

    public void setIdpengajar(Integer idpengajar) {
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
    
}
