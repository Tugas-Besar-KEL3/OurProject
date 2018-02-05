/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Data_mapelModel;
import View.MapelView;
import javax.swing.JOptionPane;

/**
 *
 * @author MY PC
 */
public class Data_mapelController {

    private Data_mapelModel model;

    public void setModel(Data_mapelModel model) {
        this.model = model;
    }

    public void resetData_mapel(MapelView view) {
        model.resetData_mapel();
    }

    public void insertData_mapel(MapelView view) {
        String kodemapel = view.getTxtKodeMapel().getText();
        Integer idpengajar = Integer.parseInt(view.getCbIdPengajar().getSelectedItem().toString());
        String mapel = view.getTxtMapel().getText();
        String pkeahlian = view.getTxtJurusan().getText();
        String kurikulum = view.getTxtKurikulum().getText();

        if (kodemapel.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode mapel masih kosong");
        } else if (kodemapel.length() < 5) {
            JOptionPane.showMessageDialog(view, "Kode mapel tidak boleh kurang dari 5");
        } else if (mapel.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Mata pelajaran masih kosong");
        } else if (pkeahlian.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Program keahlian masih kosong");
        } else if (kurikulum.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kurikulum masih kosong");
        } else {
            model.setKodemapel(kodemapel);
            model.setIdpengajar(idpengajar);
            model.setMapel(mapel);
            model.setPkeahlian(pkeahlian);
            model.setKurikulum(kurikulum);
            try {
                model.insertData_mapel();
                JOptionPane.showMessageDialog(view, "Data mapel Berhasil Ditambahkan");
                model.resetData_mapel();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void updateData_mapel(MapelView view) {

        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTblMapel().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }
        String kodemapel = view.getTxtKodeMapel().getText();

        Integer idpengajar = Integer.parseInt(view.getCbIdPengajar().getSelectedItem().toString());
        String mapel = view.getTxtMapel().getText();
        String pkeahlian = view.getTxtJurusan().getText();
        String kurikulum = view.getTxtKurikulum().getText();
        if (kodemapel.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode mapel masih kosong");
        } else if (kodemapel.length() < 5) {
            JOptionPane.showMessageDialog(view, "Kode mapel tidak boleh kurang dari 5");
        } else if (mapel.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Mata pelajaran masih kosong");
        } else if (pkeahlian.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Program keahlian masih kosong");
        } else if (kurikulum.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kurikulum masih kosong");
        } else {
            model.setKodemapel(kodemapel);
            model.setIdpengajar(idpengajar);
            model.setMapel(mapel);
            model.setPkeahlian(pkeahlian);
            model.setKurikulum(kurikulum);
        }
        try {
            model.updateData_mapel();
            JOptionPane.showMessageDialog(view, "Data Mapel Berhasil Di Ubah");
            model.resetData_mapel();
        } catch (Throwable throwable) {
            JOptionPane.showMessageDialog(view, new Object[]{
                "Terjadi error di database dengan pesan ", throwable.getMessage()
            });
        }
    }

    public void deleteData_mapel(MapelView view) {

        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTblMapel().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {

            String kodemapel = view.getTxtKodeMapel().getText();
            model.setKodemapel(kodemapel);

            try {
                model.deleteData_mapel();
                JOptionPane.showMessageDialog(view, "Data Mapel Berhasil Di Hapus");
                model.resetData_mapel();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
}
