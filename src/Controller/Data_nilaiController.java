/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Data_nilaiModel;
import View.NilaiView;
import javax.swing.JOptionPane;

/**
 *
 * @author MY PC
 */
public class Data_nilaiController {

    private Data_nilaiModel model;

    public void setModel(Data_nilaiModel model) {
        this.model = model;
    }

    public void resetData_nilai(NilaiView view) {
        model.resetData_nilai();
    }

    public void insertData_nilai(NilaiView view) {
        Integer nis = Integer.parseInt(view.getComboboxNis().getSelectedItem().toString());
        String kodemapel = view.getComboboxKodeMapel().getSelectedItem().toString();
        Integer uts = Integer.parseInt(view.getTxtNilaiUts().getText());
        Integer uas = Integer.parseInt(view.getTxtNilaiUas().getText());

        if (uts.equals("")) {
            JOptionPane.showMessageDialog(view, "Nilai UTS masih kosong!");
        } else if (uas.equals("")) {
            JOptionPane.showMessageDialog(view, "Nilai UAS masih kosong!");
        } else {
            model.setNis(nis);
            model.setKodemapel(kodemapel);
            model.setUts(uts);
            model.setUas(uas);
            try {
                model.insertData_nilai();
                JOptionPane.showMessageDialog(view, "Data nilai berhasil ditambahkan!");
                model.resetData_nilai();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error pada database dengan pesan", throwable.getMessage()});
            }
        }
    }

    public void updateData_nilai(NilaiView view) {
        if (view.getTblNilai().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan dipilih!");
            return;
        }
        Integer nis = Integer.parseInt(view.getComboboxNis().getSelectedItem().toString());

        String kodemapel = view.getComboboxKodeMapel().getSelectedItem().toString();
        Integer uts = Integer.parseInt(view.getTxtNilaiUts().getText());
        Integer uas = Integer.parseInt(view.getTxtNilaiUas().getText());

        if (uts.equals("")) {
            JOptionPane.showMessageDialog(view, "Nilai UTS masih kosong!");
        } else if (uas.equals("")) {
            JOptionPane.showMessageDialog(view, "Nilai UAS masih kosong!");
        } else {
            model.setNis(nis);
            model.setKodemapel(kodemapel);
            model.setUts(uts);
            model.setUas(uas);
            try {
                model.updateData_nilai();
                JOptionPane.showMessageDialog(view, "Data nilai berhasil diubah!");
                model.resetData_nilai();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error pada database dengan pesan", throwable.getMessage()});
            }
        }
    }

    public void deleteData_nilai(NilaiView view) {
        if (view.getTblNilai().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan dihapus!");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Apakah anda yakin akan menghapus?") == JOptionPane.OK_OPTION) {

            Integer nis = Integer.parseInt(view.getComboboxNis().getSelectedItem().toString());
            model.setNis(nis);
            try {
                model.updateData_nilai();
                JOptionPane.showMessageDialog(view, "Data nilai berhasil diubah!");
                model.resetData_nilai();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error pada database dengan pesan", throwable.getMessage()});
            }
        }
    }
}
