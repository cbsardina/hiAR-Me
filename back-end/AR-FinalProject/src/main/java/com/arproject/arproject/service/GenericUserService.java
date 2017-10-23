package com.arproject.arproject.service;

import com.arproject.arproject.model.ArUserFile;
import com.arproject.arproject.model.GenericUser;

import java.util.List;

public interface GenericUserService {

  // *** GenericUser ***
    GenericUser addGenericUser(GenericUser genericUser);
    GenericUser getGenUserByUserName(String username);
    GenericUser findGenUserById(int id);
    GenericUser updateGenericUser(GenericUser genericUser);
    List<GenericUser> getAllGenUsers();

  // *** ArUserFile in GenericUser ***
    GenericUser addNewFile(ArUserFile arUserFile);
    GenericUser deleteFile(int genericUserId, int fileId);

  // *** Delete generic user ***
    void deleteGenUser(int id);

}
