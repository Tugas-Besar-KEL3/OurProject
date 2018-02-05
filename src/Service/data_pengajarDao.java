/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.data_pengajar;
import Error.data_pengajarException;
import java.util.List;

/**
 *
 * @author MY PC
 */
public interface data_pengajarDao {
    //CRUD
    //Get by idpengajar

    public void insertData_pengajar(data_pengajar data_pengajar) throws data_pengajarException;

    public void updateData_pengajar(data_pengajar data_pengajar) throws data_pengajarException;

    public void deleteData_pengajar(Integer idpengajar) throws data_pengajarException;

    //reload data_pengajar
    public List<data_pengajar> selectAllData_pengajar() throws data_pengajarException;

    public data_pengajar getData_pengajar(Integer idpengajar) throws data_pengajarException;

}
