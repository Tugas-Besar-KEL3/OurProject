/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event;

import Entity.data_siswa;
import Model.Data_siswaModel;

/**
 *
 * @author MY PC
 */
public interface Data_siswaListener {
        public void onChange(Data_siswaModel model);

    //diambil dari entity
    public void onInsert(data_siswa data_siswa);

    public void onUpdate(data_siswa data_siswa);

    public void onDelete();
}
