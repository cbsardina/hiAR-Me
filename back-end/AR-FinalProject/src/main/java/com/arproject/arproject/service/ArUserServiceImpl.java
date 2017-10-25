package com.arproject.arproject.service;

import com.arproject.arproject.model.ArUser;
import com.arproject.arproject.model.ArUserObject;
import com.arproject.arproject.repository.ArUserRepository;
import com.arproject.arproject.repository.ArUserObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArUserServiceImpl implements ArUserService {

    @Autowired
    ArUserRepository arUserRepository;

    @Autowired
    ArUserObjectRepository arUserObjectRepository;

// ========== ArUser Methods ==========
    private ArUser getArUser(int id) {
        ArUser arUser = arUserRepository.findOne(id);
        arUser.getArUserObjects().size();
        return arUser;
    }


//   ----- Find user Methods -----
    @Override
    @Transactional(readOnly = true)
    public ArUser getArUserById(int id) {
        return getArUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ArUser findByUserName(String userName) {
        List<ArUser> allArUsers = arUserRepository.findAll();

        for(ArUser aUser:allArUsers) {
            if (aUser.getUserName().equals(userName)) {
                return aUser;
            }
        }
        return null;
    }

    // ----- Add and Update ArUser -----
    @Transactional
    @Override
    public ArUser addArUser(ArUser arUser) {
        return arUserRepository.save(arUser);
    }

    @Transactional
    @Override
    public ArUser updateArUser(ArUser arUser) {
        return arUserRepository.save(arUser);
    }

  // ----- Delete User and All Users -----
    @Transactional
    @Override
    public void deleteArUser(int id) {
        arUserRepository.delete(id);
    }

    @Transactional
    @Override
    public void deleteAllArUsers() {
        arUserRepository.deleteAll();
    }

// ========== ArUserObject Methods ==========

//   ----- User addNewObject ---
    @Transactional
    @Override
    public ArUser addNewObject(ArUserObject arUserObject) {
        arUserObject = arUserObjectRepository.save(arUserObject);
        ArUser arUser = arUserRepository.findOne(arUserObject.getArUser().getId());
            arUser.getArUserObjects().add(arUserObject);
            arUserRepository.save(arUser);

        return getArUser(arUserObject.getArUser().getId());

    }

  // ----- User deleteObject -----
    @Transactional
    @Override
    public ArUser deleteObject(int arUserId, int objectId) {
        ArUserObject arUserObject = arUserObjectRepository.findOne(objectId);
            arUserObjectRepository.delete(objectId);
        ArUser arUser = arUserRepository.findOne(arUserId);
            arUser.getArUserObjects().remove(arUserObject);
            arUserRepository.save(arUser);

        return getArUser(arUserId);
    }

}
