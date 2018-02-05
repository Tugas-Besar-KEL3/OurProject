/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.data_pengajar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MY PC
 */
public class TabelData_pengajarModel extends AbstractTableModel {

    private List<data_pengajar> list = new ArrayList<data_pengajar>();

    public void setList(List<data_pengajar> list) {
        this.list = list;
    }

    public boolean add(data_pengajar e) {

        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public data_pengajar get(int index) {
        return list.get(index);
    }

    public data_pengajar set(int index, data_pengajar element) {

        try {
            return list.set(index, element);
        } finally {
            //karena set merubah, jadi pake fireTablRowsUpdate
            fireTableRowsUpdated(index, index);
        }

    }

    public data_pengajar remove(int index) {

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
                return "ID PENGAJAR";
            case 1:
                return "NAMA";
            case 2:
                return "JK";
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
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIdpengajar();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getJk();
            default:
                return null;
        }
    }
}
