/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event;

import Entity.data_pengajar;
import Model.Data_pengajarModel;

/**
 *
 * @author MY PC
 */
public interface Data_pengajarListener {
        //diambil dari model
    public void onChange(Data_pengajarModel model);

    //diambil dari entity
    public void onInsert(data_pengajar data_pengajar);

    public void onUpdate(data_pengajar data_pengajar);

    public void onDelete();
}
