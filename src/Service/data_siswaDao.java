/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.data_siswa;
import Error.data_siswaException;
import java.util.List;

/**
 *
 * @author MY PC
 */
public interface data_siswaDao {
    //CRUD
    //Get by nis

    public void insertData_siswa(data_siswa data_siswa) throws data_siswaException;

    public void updateData_siswa(data_siswa data_siswa) throws data_siswaException;

    public void deleteData_siswa(Integer nis) throws data_siswaException;

    //reload data_siswa
    public List<data_siswa> selectAllData_siswa() throws data_siswaException;

    public data_siswa getData_siswa(Integer nis) throws data_siswaException;

}
