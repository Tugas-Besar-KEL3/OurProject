/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Data_siswaModel;
import View.SiswaView;
import javax.swing.JOptionPane;

/**
 *
 * @author MY PC
 */
public class Data_siswaController {

    private Data_siswaModel model;

    public void setModel(Data_siswaModel model) {
        this.model = model;
    }

    public void resetData_siswa(SiswaView view) {
        model.resetData_siswa();
    }

    public void insertData_siswa(SiswaView view) {
        Integer nis = Integer.parseInt(view.getTxtNisSiswa().getText());
        String nama = view.getTxtNamaSiswa().getText();
        String kelas = view.getTxtKelasSiswa().getText();
        String jk = view.getCbJK().getSelectedItem().toString();
        String ttl = view.getTxtTtlSiswa().getText();
        String alamat = view.getTxtAlamatSiswa().getText();
        Integer nohp = Integer.parseInt(view.getTxtNoTelpSiswa().getText());

        if (nis.equals("")) {
            JOptionPane.showMessageDialog(view, "NIS tidak boleh kosong");
        } else if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (kelas.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kelas tidak boleh kosong");
        } else if (nohp.equals("")) {
            JOptionPane.showMessageDialog(view, "No.Hp tidak boleh kosong");
        } else {
            model.setNis(nis);
            model.setNama(nama);
            model.setKelas(kelas);
            model.setJk(jk);
            model.setTtl(ttl);
            model.setAlamat(alamat);
            model.setNohp(nohp);
            try {
                model.insertData_siswa();
                JOptionPane.showMessageDialog(view, "Data siswa Berhasil Ditambahkan");
                model.resetData_siswa();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void updateData_siswa(SiswaView view) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTblSiswa().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }
        Integer nis = Integer.parseInt(view.getTxtNisSiswa().getText());
        String nama = view.getTxtNamaSiswa().getText();
        String kelas = view.getTxtKelasSiswa().getText();
        String jk = view.getCbJK().getSelectedItem().toString();
        String ttl = view.getTxtTtlSiswa().getText();
        String alamat = view.getTxtAlamatSiswa().getText();
        Integer nohp = Integer.parseInt(view.getTxtNoTelpSiswa().getText());

        if (nis.equals("")) {
            JOptionPane.showMessageDialog(view, "NIS tidak boleh kosong");
        } else if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (kelas.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kelas tidak boleh kosong");
        } else if (nohp.equals("")) {
            JOptionPane.showMessageDialog(view, "No.Hp tidak boleh kosong");
        } else {
            model.setNis(nis);
            model.setNama(nama);
            model.setKelas(kelas);
            model.setJk(jk);
            model.setTtl(ttl);
            model.setAlamat(alamat);
            model.setNohp(nohp);
            try {
                model.updateData_siswa();
                JOptionPane.showMessageDialog(view, "Data siswa Berhasil Diubah");
                model.resetData_siswa();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void deleteData_siswa(SiswaView view) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTblSiswa().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {

            Integer nis = Integer.parseInt(view.getTxtNisSiswa().getText());
            model.setNis(nis);

            try {
                model.deleteData_siswa();
                JOptionPane.showMessageDialog(view, "Data siswa berhasil di hapus");
                model.resetData_siswa();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
}
