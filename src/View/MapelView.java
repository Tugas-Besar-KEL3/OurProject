/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Data_mapelController;
import Entity.data_mapel;
import Error.data_mapelException;
import Event.Data_mapelListener;
import Model.Data_mapelModel;
import Model.TabelData_mapelModel;
import Service.data_mapelDao;
import database.medikacomDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author MY PC
 */
public final class MapelView extends javax.swing.JPanel implements Data_mapelListener, ListSelectionListener {

    private TabelData_mapelModel tabelModel;
    private Data_mapelModel model;
    private Data_mapelController controller;
    private medikacomDatabase db = new medikacomDatabase();

    public void tampil_combo() throws SQLException {
        try{
            Connection con= medikacomDatabase.getConnection();
            Statement stt = con.createStatement();
            String sql = "select idpengajar from data_pengajar order by idpengajar asc";
            ResultSet res = stt.executeQuery(sql);
            
            while(res.next()){
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                
                cbIdPengajar.addItem((String) ob[0]);
            }
            res.close(); stt.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public MapelView() throws SQLException {
        tabelModel = new TabelData_mapelModel();

        model = new Data_mapelModel();
        model.setListener(this);

        controller = new Data_mapelController();
        controller.setModel(model);

        initComponents();
        tampil_combo();
        tblMapel.getSelectionModel().addListSelectionListener(this);

        tblMapel.setModel(tabelModel);
    }

    public JComboBox<String> getCbIdPengajar() {
        return cbIdPengajar;
    }

    public JTable getTblMapel() {
        return tblMapel;
    }

    public JTextField getTxtJurusan() {
        return txtJurusan;
    }

    public JTextField getTxtKodeMapel() {
        return txtKodeMapel;
    }

    public JTextField getTxtKurikulum() {
        return txtKurikulum;
    }

    public JTextField getTxtMapel() {
        return txtMapel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DataMapel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMapel = new javax.swing.JTable();
        txtKodeMapel = new javax.swing.JTextField();
        txtMapel = new javax.swing.JTextField();
        txtJurusan = new javax.swing.JTextField();
        txtKurikulum = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        cbIdPengajar = new javax.swing.JComboBox<>();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        DataMapel.setBackground(new java.awt.Color(0, 153, 0));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 0));
        jLabel18.setText("PENGOLAHAN DATA MATA PELAJARAN");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 0));
        jLabel19.setText("Kode Mata Pelajaran");

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 0));
        jLabel20.setText("ID Pengajar");

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 0));
        jLabel21.setText("Mata Pelajaran");

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 0));
        jLabel22.setText("Prog. Keahlian");

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 0));
        jLabel23.setText("Kurikulum ");

        tblMapel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblMapel);

        txtKodeMapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeMapelActionPerformed(evt);
            }
        });

        txtJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJurusanActionPerformed(evt);
            }
        });

        buttonAdd.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        buttonAdd.setText("Tambah Data");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        cbIdPengajar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih ID Pengajar-" }));
        cbIdPengajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdPengajarActionPerformed(evt);
            }
        });

        buttonEdit.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        buttonEdit.setText("Ubah Data");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonDelete.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        buttonDelete.setText("Hapus Data");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonReset.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        buttonReset.setText("Reset Data");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DataMapelLayout = new javax.swing.GroupLayout(DataMapel);
        DataMapel.setLayout(DataMapelLayout);
        DataMapelLayout.setHorizontalGroup(
            DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataMapelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataMapelLayout.createSequentialGroup()
                        .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(DataMapelLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtKodeMapel))
                            .addGroup(DataMapelLayout.createSequentialGroup()
                                .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel23))
                                .addGap(44, 44, 44)
                                .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtJurusan, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                    .addComponent(txtMapel, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                    .addComponent(txtKurikulum, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                    .addComponent(cbIdPengajar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataMapelLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(304, 304, 304)))
                        .addContainerGap(239, Short.MAX_VALUE))
                    .addGroup(DataMapelLayout.createSequentialGroup()
                        .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(DataMapelLayout.createSequentialGroup()
                                    .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel18)))
                        .addGap(0, 8, Short.MAX_VALUE))))
        );
        DataMapelLayout.setVerticalGroup(
            DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataMapelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(11, 11, 11)
                .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtKodeMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbIdPengajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DataMapelLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(3, 3, 3))
                    .addComponent(txtJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtKurikulum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataMapelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonEdit)
                    .addComponent(buttonDelete)
                    .addComponent(buttonReset)
                    .addComponent(btnBack))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DataMapel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DataMapel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodeMapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeMapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeMapelActionPerformed

    private void txtJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJurusanActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
        controller.insertData_mapel(this);
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        // TODO add your handling code here:
        controller.updateData_mapel(this);
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO add your handling code here:
        controller.deleteData_mapel(this);
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
        controller.resetData_mapel(this);
        txtKodeMapel.setText("");
        txtMapel.setText("");
        txtJurusan.setText("");
        txtKurikulum.setText("");
    }//GEN-LAST:event_buttonResetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        HomeView HV = new HomeView();
        HV.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cbIdPengajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdPengajarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIdPengajarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataMapel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonReset;
    private javax.swing.JComboBox<String> cbIdPengajar;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblMapel;
    private javax.swing.JTextField txtJurusan;
    private javax.swing.JTextField txtKodeMapel;
    private javax.swing.JTextField txtKurikulum;
    private javax.swing.JTextField txtMapel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(Data_mapelModel model) {
        txtKodeMapel.setText(model.getKodemapel() + "");
        cbIdPengajar.setSelectedItem(model.getIdpengajar());
        txtMapel.setText(model.getMapel());
        txtJurusan.setText(model.getPkeahlian());
        txtKurikulum.setText(model.getKurikulum());
    }

    @Override
    public void onInsert(data_mapel data_mapel) {
        tabelModel.add(data_mapel);
    }

    @Override
    public void onUpdate(data_mapel data_mapel) {
        int index = tblMapel.getSelectedRow();
        tabelModel.set(index, data_mapel);
    }

    @Override
    public void onDelete() {
        int index = tblMapel.getSelectedRow();
        tabelModel.remove(index);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        try {
            data_mapel model = tabelModel.get(tblMapel.getSelectedRow());
            txtKodeMapel.setText(model.getKodemapel() + "");
            cbIdPengajar.setSelectedItem(model.getIdpengajar());
            txtMapel.setText(model.getMapel());
            txtJurusan.setText(model.getPkeahlian());
            txtKurikulum.setText(model.getKurikulum());
        } catch (IndexOutOfBoundsException exception) {
        }
    }

    public void loadDatabase() throws SQLException, data_mapelException {
        data_mapelDao dao = medikacomDatabase.getData_mapelDao();
        tabelModel.setList(dao.selectAllData_mapel());
    }
}
