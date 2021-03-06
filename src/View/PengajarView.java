/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Data_pengajarController;
import Entity.data_pengajar;
import Error.data_pengajarException;
import Event.Data_pengajarListener;
import Model.Data_pengajarModel;
import Model.TabelData_pengajarModel;
import Service.data_pengajarDao;
import database.medikacomDatabase;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY PC
 */
public class PengajarView extends javax.swing.JPanel implements Data_pengajarListener, ListSelectionListener {

    private TabelData_pengajarModel tabelModel;
    private Data_pengajarModel model;
    private Data_pengajarController controller;

    Connection conn = medikacomDatabase.getConnection();

    public PengajarView() throws SQLException {
        tabelModel = new TabelData_pengajarModel();

        model = new Data_pengajarModel();
        model.setListener(this);

        controller = new Data_pengajarController();
        controller.setModel(model);

        initComponents();
        tblPengajar.getSelectionModel().addListSelectionListener(this);

        tblPengajar.setModel(tabelModel);
    }

    public JTable getTblPengajar() {
        return tblPengajar;
    }

    public JTextField getTxtIDPengajar() {
        return txtIDPengajar;
    }

    public JTextField getTxtNamaPengajar() {
        return txtNamaPengajar;
    }

    public JComboBox<String> getCbJenisKelamin() {
        return cbJenisKelamin;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DataPengajar = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPengajar = new javax.swing.JTable();
        buttonAdd1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtNamaPengajar = new javax.swing.JTextField();
        txtIDPengajar = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        buttonEdit1 = new javax.swing.JButton();
        buttonDelete1 = new javax.swing.JButton();
        buttonReset1 = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();
        cbJenisKelamin = new javax.swing.JComboBox<>();
        btnLihatData = new javax.swing.JButton();

        DataPengajar.setBackground(new java.awt.Color(0, 153, 0));
        DataPengajar.setPreferredSize(new java.awt.Dimension(522, 350));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 0));
        jLabel24.setText("PENGOLAHAN DATA PENGAJAR");

        tblPengajar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblPengajar);

        buttonAdd1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        buttonAdd1.setText("Tambah Data");
        buttonAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdd1ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 0));
        jLabel25.setText("Jenis Kelamin");

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 0));
        jLabel26.setText("Nama");

        txtNamaPengajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPengajarActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 0));
        jLabel27.setText("ID Pengajar");

        buttonEdit1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        buttonEdit1.setText("Ubah Data");
        buttonEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEdit1ActionPerformed(evt);
            }
        });

        buttonDelete1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        buttonDelete1.setText("Hapus Data");
        buttonDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDelete1ActionPerformed(evt);
            }
        });

        buttonReset1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        buttonReset1.setText("Reset Data");
        buttonReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReset1ActionPerformed(evt);
            }
        });

        btnBack1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnBack1.setText("Kembali");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        cbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Jenis Kelamin -", "Laki-laki", "Perempuan", " " }));

        btnLihatData.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnLihatData.setText("Lihat Data");
        btnLihatData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DataPengajarLayout = new javax.swing.GroupLayout(DataPengajar);
        DataPengajar.setLayout(DataPengajarLayout);
        DataPengajarLayout.setHorizontalGroup(
            DataPengajarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPengajarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataPengajarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jLabel24)
                    .addGroup(DataPengajarLayout.createSequentialGroup()
                        .addGroup(DataPengajarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DataPengajarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaPengajar)
                            .addComponent(txtIDPengajar)
                            .addComponent(cbJenisKelamin, 0, 246, Short.MAX_VALUE)))
                    .addGroup(DataPengajarLayout.createSequentialGroup()
                        .addComponent(buttonAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLihatData, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DataPengajarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DataPengajarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel27)
                    .addContainerGap(716, Short.MAX_VALUE)))
        );
        DataPengajarLayout.setVerticalGroup(
            DataPengajarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPengajarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(txtIDPengajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(DataPengajarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaPengajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(DataPengajarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cbJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DataPengajarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd1)
                    .addComponent(buttonEdit1)
                    .addComponent(buttonDelete1)
                    .addComponent(buttonReset1)
                    .addComponent(btnBack1)
                    .addComponent(btnLihatData))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(DataPengajarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DataPengajarLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel27)
                    .addContainerGap(348, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DataPengajar, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DataPengajar, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdd1ActionPerformed
        // TODO add your handling code here:
        controller.insertData_pengajar(this);
    }//GEN-LAST:event_buttonAdd1ActionPerformed

    private void txtNamaPengajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPengajarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPengajarActionPerformed

    private void buttonEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEdit1ActionPerformed
        // TODO add your handling code here:
        controller.updateData_pengajar(this);
        if (tblPengajar.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }
        Integer idpengajar = Integer.parseInt(txtIDPengajar.getText());

        String nama = txtNamaPengajar.getText();
        String jk = cbJenisKelamin.getSelectedItem().toString();

        if (idpengajar.equals("")) {
            JOptionPane.showMessageDialog(null, "Id pengajar tidak boleh kosong");
        } else if (idpengajar <= 6) {
            JOptionPane.showMessageDialog(null, "Id pengajar tidak boleh kurang dari 6");
        } else if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
        } else {
            model.setIdpengajar(idpengajar);
            model.setNama(nama);
            model.setJk(jk);
            try {
                model.updateData_pengajar();
                JOptionPane.showMessageDialog(null, "Data pengajar Berhasil Diubah");
                model.resetData_pengajar();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(null, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }//GEN-LAST:event_buttonEdit1ActionPerformed

    private void buttonDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDelete1ActionPerformed
        // TODO add your handling code here:
        controller.deleteData_pengajar(this);
        int ok = JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan mengupdate data ini?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql="delete from data_pengajar where idpengajar='"+txtIDPengajar.getText()+"'";
                PreparedStatement st=conn.prepareStatement(sql);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Update data sukses!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Update data gagal!");
            }
        }
    }//GEN-LAST:event_buttonDelete1ActionPerformed

    private void buttonReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReset1ActionPerformed
        // TODO add your handling code here:
        controller.resetData_pengajar(this);
        txtIDPengajar.setText("");
        txtNamaPengajar.setText("");
    }//GEN-LAST:event_buttonReset1ActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        HomeView HV = new HomeView();
        HV.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnLihatDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatDataActionPerformed
        // TODO add your handling code here:
        try {
            Object[] rows = {"ID PENGAJAR", "NAMA", "JK"};
            DefaultTableModel dtm = new DefaultTableModel(null, rows);
            tblPengajar.setModel(dtm);
            tblPengajar.setBorder(null);
            jScrollPane5.setVisible(true);
            jScrollPane5.setViewportView(tblPengajar);
            int idpengajar = 1;
            String nama = "", jk = "";
            try {
                String sql = "select * from data_pengajar";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    idpengajar = rs.getInt("idpengajar");
                    nama = rs.getString("nama");
                    jk = rs.getString("jk");

                    String[] tampil = {"" + idpengajar++, nama, jk};
                    dtm.addRow(tampil);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Query Salah " + e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLihatDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataPengajar;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnLihatData;
    private javax.swing.JButton buttonAdd1;
    private javax.swing.JButton buttonDelete1;
    private javax.swing.JButton buttonEdit1;
    private javax.swing.JButton buttonReset1;
    private javax.swing.JComboBox<String> cbJenisKelamin;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblPengajar;
    private javax.swing.JTextField txtIDPengajar;
    private javax.swing.JTextField txtNamaPengajar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(Data_pengajarModel model) {
        txtIDPengajar.setText(model.getIdpengajar() + "");
        txtNamaPengajar.setText(model.getNama());
        cbJenisKelamin.setSelectedItem(model.getJk());
    }

    @Override
    public void onInsert(data_pengajar data_pengajar) {
        tabelModel.add(data_pengajar);
    }

    @Override
    public void onUpdate(data_pengajar data_pengajar) {
        int index3 = tblPengajar.getSelectedRow();
        tabelModel.set(index3, data_pengajar);
    }

    @Override
    public void onDelete() {
        int index3 = tblPengajar.getSelectedRow();
        tabelModel.remove(index3);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        try {
            data_pengajar model3 = tabelModel.get(tblPengajar.getSelectedRow());
            txtIDPengajar.setText(model3.getIdpengajar() + "");
            txtNamaPengajar.setText(model3.getNama());
            cbJenisKelamin.setSelectedItem(model3.getJk());
        } catch (IndexOutOfBoundsException exception) {
        }
    }

    public void loadDatabase() throws SQLException, data_pengajarException {
        data_pengajarDao dao = medikacomDatabase.getData_pengajarDao();
        tabelModel.setList(dao.selectAllData_pengajar());
    }

}
