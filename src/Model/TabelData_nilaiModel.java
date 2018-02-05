/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.data_nilai;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MY PC
 */
public class TabelData_nilaiModel extends AbstractTableModel {

    private List<data_nilai> list = new ArrayList<data_nilai>();

    public void setList(List<data_nilai> list) {
        this.list = list;
    }

    public boolean add(data_nilai e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public data_nilai get(int index) {
        return list.get(index);
    }

    public data_nilai set(int index, data_nilai element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public data_nilai remove(int index) {
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
                return "KODEMAPEL";
            case 2:
                return "UTS";
            case 3:
                return "UAS";
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNis();
            case 1:
                return list.get(rowIndex).getKodemapel();
            case 2:
                return list.get(rowIndex).getUts();
            case 3:
                return list.get(rowIndex).getUas();
            default:
                return null;
        }
    }

}
