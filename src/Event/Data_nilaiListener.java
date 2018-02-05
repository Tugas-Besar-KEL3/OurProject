/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event;

import Entity.data_nilai;
import Model.Data_nilaiModel;

/**
 *
 * @author MY PC
 */
public interface Data_nilaiListener {
    //diambil dari model

    public void onChange(Data_nilaiModel model);

    //diambil dari entity
    public void onInsert(data_nilai data_nilai);

    public void onUpdate(data_nilai data_nilai);

    public void onDelete();
}
