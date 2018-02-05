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
public class data_nilai {

    public Integer nis;
    public String kodemapel;
    public Integer uts;
    public Integer uas;

    public data_nilai() {
    }

    public data_nilai(Integer nis, String kodemapel, Integer uts, Integer uas) {
        this.nis = nis;
        this.kodemapel = kodemapel;
        this.uts = uts;
        this.uas = uas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nis);
        hash = 29 * hash + Objects.hashCode(this.kodemapel);
        hash = 29 * hash + Objects.hashCode(this.uts);
        hash = 29 * hash + Objects.hashCode(this.uas);
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
        final data_nilai other = (data_nilai) obj;
        if (!Objects.equals(this.kodemapel, other.kodemapel)) {
            return false;
        }
        if (!Objects.equals(this.nis, other.nis)) {
            return false;
        }
        if (!Objects.equals(this.uts, other.uts)) {
            return false;
        }
        if (!Objects.equals(this.uas, other.uas)) {
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

    public String getKodemapel() {
        return kodemapel;
    }

    public void setKodemapel(String kodemapel) {
        this.kodemapel = kodemapel;
    }

    public Integer getUts() {
        return uts;
    }

    public void setUts(Integer uts) {
        this.uts = uts;
    }

    public Integer getUas() {
        return uas;
    }

    public void setUas(Integer uas) {
        this.uas = uas;
    }

}
