/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.data_mapel;
import Exception.data_mapelException;
import java.util.List;

/**
 *
 * @author MY PC
 */
public interface data_mapelDao {

    //CRUD
    //Get by kode_mapel
    public void insertData_mapel(data_mapel data_mapel) throws data_mapelException;

    public void updateData_mapel(data_mapel data_mapel) throws data_mapelException;

    public void deleteData_mapel(String kode_mapel) throws data_mapelException;

    //reload data_mapel 
    public List<data_mapel> selectAllData_mapel() throws data_mapelException;
}
