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

    private String kodemapel;
    private Integer idpengajar;
    private String mapel;
    private String pkeahlian;
    private String kurikulum;

    public data_mapel() {
    }

    public data_mapel(String kodemapel, Integer idpengajar, String mapel, String pkeahlian, String kurikulum) {
        this.kodemapel = kodemapel;
        this.idpengajar = idpengajar;
        this.mapel = mapel;
        this.pkeahlian = pkeahlian;
        this.kurikulum = kurikulum;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.kodemapel);
        hash = 23 * hash + Objects.hashCode(this.idpengajar);
        hash = 23 * hash + Objects.hashCode(this.mapel);
        hash = 23 * hash + Objects.hashCode(this.pkeahlian);
        hash = 23 * hash + Objects.hashCode(this.kurikulum);
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
        if (!Objects.equals(this.kodemapel, other.kodemapel)) {
            return false;
        }
        if (!Objects.equals(this.mapel, other.mapel)) {
            return false;
        }
        if (!Objects.equals(this.pkeahlian, other.pkeahlian)) {
            return false;
        }
        if (!Objects.equals(this.kurikulum, other.kurikulum)) {
            return false;
        }
        if (!Objects.equals(this.idpengajar, other.idpengajar)) {
            return false;
        }
        return true;
    }

    public String getKodemapel() {
        return kodemapel;
    }

    public void setKodemapel(String kodemapel) {
        this.kodemapel = kodemapel;
    }

    public Integer getIdpengajar() {
        return idpengajar;
    }

    public void setIdpengajar(Integer idpengajar) {
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


}
