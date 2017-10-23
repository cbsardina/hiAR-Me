package com.arproject.arproject.service;

import com.arproject.arproject.model.ArUserFile;
import com.arproject.arproject.model.GenericUser;
import com.arproject.arproject.repository.ArUserFileRepository;
import com.arproject.arproject.repository.GenericUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenericUserImpl implements GenericUserService {


    @Autowired
    GenericUserRepository genericUserRepository;

    @Autowired
    ArUserFileRepository arUserFileRepository;

// ========== GenericUser Methods ==========
  // ----- Find GenericUser Methods -----
    @Override
    public GenericUser getGenUserByUserName(String username) {
        List<GenericUser> allGenUsers = genericUserRepository.findAll();

        for(GenericUser genUser: allGenUsers) {
            if(genUser.getUserName().equals(username)) {
                return genUser;
            }
        }
        return null;
    }

    @Override
    public GenericUser findGenUserById(int id) {
        return genericUserRepository.findOne(id);
    }

    @Override
    public List<GenericUser> getAllGenUsers() {
        return genericUserRepository.findAll();
    }

  // ----- Add and Update GenericUser -----
    @Override
    public GenericUser addGenericUser(GenericUser genericUser) {
        return genericUserRepository.save(genericUser);
    }

    @Transactional
    @Override
    public GenericUser updateGenericUser(GenericUser genericUser) {
        return genericUserRepository.save(genericUser);
    }

  // ----- Delete GenericUser Method -----
    @Transactional
    @Override
    public void deleteGenUser(int id) {
        genericUserRepository.delete(id);
    }

// ========== ArUserFile in GenericUser Methods ==========
    @Override
    public GenericUser addNewFile(ArUserFile arUserFile) {
            arUserFileRepository.save(arUserFile);
        GenericUser genUser = genericUserRepository.findOne(arUserFile.getGenericUser().getId());
            genUser.getGenericUserFiles().add(arUserFile);
            genericUserRepository.save(genUser);

        return findGenUserById(arUserFile.getGenericUser().getId());
    }

    @Override
    public GenericUser deleteFile(int genericUserId, int fileId) {
        ArUserFile arUserFile = arUserFileRepository.findOne(fileId);
            arUserFileRepository.delete(fileId);
        GenericUser genericUser = genericUserRepository.findOne(genericUserId);
            genericUser.getGenericUserFiles().remove(arUserFile);
            genericUserRepository.save(genericUser);

        return findGenUserById(genericUserId);
    }
}
