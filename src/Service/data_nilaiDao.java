/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.data_nilai;
import Error.data_nilaiException;
import java.util.List;

/**
 *
 * @author MY PC
 */
public interface data_nilaiDao {
        //CRUD
    //Get by nis

    public void insertData_nilai(data_nilai data_nilai) throws data_nilaiException;

    public void updateData_nilai(data_nilai data_nilai) throws data_nilaiException;

    public void deleteData_nilai(Integer nis) throws data_nilaiException;

    //reload data_nilai
    public List<data_nilai> selectAllData_nilai() throws data_nilaiException;

    public data_nilai getData_nilai(Integer nis) throws data_nilaiException;

}
