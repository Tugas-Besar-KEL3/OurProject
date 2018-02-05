/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.data_siswa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MY PC
 */
public class TabelData_siswaModel extends AbstractTableModel {

    private List<data_siswa> list = new ArrayList<data_siswa>();

    public void setList(List<data_siswa> list) {
        this.list = list;
    }

    public boolean add(data_siswa e) {

        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public data_siswa get(int index) {
        return list.get(index);
    }

    public data_siswa set(int index, data_siswa element) {

        try {
            return list.set(index, element);
        } finally {
            //karena set merubah, jadi pake fireTablRowsUpdate
            fireTableRowsUpdated(index, index);
        }

    }

    public data_siswa remove(int index) {

        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NIS";
            case 1:
                return "NAMA";
            case 2:
                return "KELAS";
            case 3:
                return "JK";
            case 4:
                return "TTL";
            case 5:
                return "ALAMAT";
            case 6:
                return "NOHP";
            default:
                return null;
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNis();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getKelas();
            case 3:
                return list.get(rowIndex).getJk();
            case 4:
                return list.get(rowIndex).getTtl();
            case 5:
                return list.get(rowIndex).getAlamat();
            case 6:
                return list.get(rowIndex).getNohp();
            default:
                return null;
        }
    }

}
