/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Data_pengajarModel;
import View.PengajarView;
import javax.swing.JOptionPane;

/**
 *
 * @author MY PC
 */
public class Data_pengajarController {

    private Data_pengajarModel model;

    public void setModel(Data_pengajarModel model) {
        this.model = model;
    }

    public void resetData_pengajar(PengajarView view) {
        model.resetData_pengajar();
    }

    public void insertData_pengajar(PengajarView view) {
        Integer idpengajar = Integer.parseInt(view.getTxtIDPengajar().getText());
        String nama = view.getTxtNamaPengajar().getText();
        String jk = view.getCbJenisKelamin().getSelectedItem().toString();
        if (idpengajar.equals("")) {
            JOptionPane.showMessageDialog(view, "Id pengajar tidak boleh kosong");
        } else if (idpengajar <= 6) {
            JOptionPane.showMessageDialog(view, "Id pengajar tidak boleh kurang dari 6");
        } else if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else {
            model.setIdpengajar(idpengajar);
            model.setNama(nama);
            model.setJk(jk);
            try {
                model.insertData_pengajar();
                JOptionPane.showMessageDialog(view, "Data pengajar Berhasil Ditambahkan");
                model.resetData_pengajar();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void updateData_pengajar(PengajarView view) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTblPengajar().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }
        Integer idpengajar = Integer.parseInt(view.getTxtIDPengajar().getText());

        String nama = view.getTxtNamaPengajar().getText();
        String jk = view.getCbJenisKelamin().getSelectedItem().toString();

        if (idpengajar.equals("")) {
            JOptionPane.showMessageDialog(view, "Id pengajar tidak boleh kosong");
        } else if (idpengajar <= 6) {
            JOptionPane.showMessageDialog(view, "Id pengajar tidak boleh kurang dari 6");
        } else if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else {
            model.setIdpengajar(idpengajar);
            model.setNama(nama);
            model.setJk(jk);
            try {
                model.updateData_pengajar();
                JOptionPane.showMessageDialog(view, "Data pengajar Berhasil Diubah");
                model.resetData_pengajar();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void deleteData_pengajar(PengajarView view) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTblPengajar().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {

            Integer idpengajar = Integer.parseInt(view.getTxtIDPengajar().getText());
            model.setIdpengajar(idpengajar);

            try {
                model.deleteData_pengajar();
                JOptionPane.showMessageDialog(view, "Data pengajar berhasil di hapus");
                model.resetData_pengajar();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
}
