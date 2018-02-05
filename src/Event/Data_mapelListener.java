/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event;

import Entity.data_mapel;
import Model.Data_mapelModel;

/**
 *
 * @author MY PC
 */
public interface Data_mapelListener {

    //diambil dari model
    public void onChange(Data_mapelModel model);

    //diambil dari entity
    public void onInsert(data_mapel data_mapel);

    public void onUpdate(data_mapel data_mapel);

    public void onDelete();
}

