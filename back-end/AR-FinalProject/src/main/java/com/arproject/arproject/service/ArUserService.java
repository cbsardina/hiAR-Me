package com.arproject.arproject.service;

import com.arproject.arproject.model.ArUser;
import com.arproject.arproject.model.ArUserObject;

public interface ArUserService {

  // *** ArUser ***
    ArUser findArUserById(int id);
    ArUser findByUserName(String userName);
    ArUser addArUser(ArUser arUser);
    ArUser updateArUser(ArUser arUser);
    void deleteArUser(int id);

    // -- for development --
    void deleteAllArUsers();

  // *** ArUserObject ***
    ArUser addNewObject(ArUserObject arUserObject);
    ArUser deleteObject(int arUserId, int fileId);
}
