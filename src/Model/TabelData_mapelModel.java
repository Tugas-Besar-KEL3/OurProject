/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.data_mapel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MY PC
 */
public class TabelData_mapelModel extends AbstractTableModel {

    private List<data_mapel> list = new ArrayList<data_mapel>();

    public void setList(List<data_mapel> list) {
        this.list = list;
    }

    public boolean add(data_mapel e) {

        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public data_mapel get(int index) {
        return list.get(index);
    }

    public data_mapel set(int index, data_mapel element) {

        try {
            return list.set(index, element);
        } finally {
            //karena set merubah, jadi pake fireTablRowsUpdate
            fireTableRowsUpdated(index, index);
        }

    }

    public data_mapel remove(int index) {

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
                return "KODEMAPEL";
            case 1:
                return "IDPENGAJAR";
            case 2:
                return "MAPEL";
            case 3:
                return "PKEAHLIAN";
            case 4:
                return "KURIKULUM";
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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getKodemapel();
            case 1:
                return list.get(rowIndex).getIdpengajar();
            case 2:
                return list.get(rowIndex).getMapel();
            case 3:
                return list.get(rowIndex).getPkeahlian();
            case 4:
                return list.get(rowIndex).getKurikulum();
            default:
                return null;
        }
    }

}
