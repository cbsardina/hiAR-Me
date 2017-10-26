package com.arproject.arproject.service;

import com.arproject.arproject.model.Uzer;
import com.arproject.arproject.model.UzerItem;

public interface UzerService {

  // *** Uzer ***
    Uzer getUzerById(int id);
    Uzer addUzer(Uzer uzer);
    Uzer updateUzer(Uzer uzer);
    void deleteUzer(int id);

  // *** Item ***
    Uzer addItem(UzerItem uzerItem);
    Uzer deleteItem(int uzerId, int itemId);

  // *** DeleteAll ***
    void deleteAll();


}
