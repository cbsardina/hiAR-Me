package com.arproject.arproject.service;

import com.arproject.arproject.model.Uzer;
import com.arproject.arproject.model.UzerItem;
import com.arproject.arproject.repository.UzerRepository;
import com.arproject.arproject.repository.UzerItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@Transactional
public class UzerServiceImpl implements UzerService {

    @Autowired
    UzerRepository uzerRepository;

    @Autowired
    UzerItemRepository uzerItemRepository;

    /** * * * * * * * *
            *** USER METHODS ***
 */
    @Override
    public Uzer getUzerByEmail(String email) {
        List<Uzer> allUzers = uzerRepository.findAll();
        for(Uzer uzer: allUzers) {
            if (uzer.getUserEmail().equals(email)) {
                return uzer;
            }
        }
        return null;
    }

    @Override
    public Uzer getUzerById(int id) {
        return uzerRepository.findOne(id);
    }

    @Transactional
    @Override
    public Uzer addUzer(Uzer uzer) { return uzerRepository.save(uzer); }

//    HashSalt hs = new HashSalt();
//    String encPass = hs.encrypt(newUzer.getUserPass());
//        newUzer.setUserPass(encPass);

    @Transactional
    @Override
    public Uzer updateUzer(Uzer uzer) {
        return uzerRepository.save(uzer);
    }

    @Transactional
    @Override
    public void deleteUzer(int id) {
        Uzer uzer = this.getUSER(id);
        uzerItemRepository.delete(uzer.getUserItems());
        uzerRepository.delete(id);
    }

/** * * * * * * * *
             *** ITEM METHODS ***
 */
    @Transactional
    @Override
    public Uzer addItem(UzerItem uzerItem) {
        uzerItemRepository.save(uzerItem);
        Uzer uzer = uzerRepository.findOne(uzerItem.getUzer().getId());
        uzer.getUserItems().add(uzerItem);
        uzerRepository.save(uzer);
        return getUSER(uzerItem.getUzer().getId());
    }

    @Transactional
    @Override
    public Uzer deleteItem(int uzerId, int itemId) {
        UzerItem uzerItem = uzerItemRepository.findOne(itemId);
        uzerItemRepository.delete(itemId);
        Uzer uzer = uzerRepository.findOne(uzerId);
        uzer.getUserItems().remove(uzerItem);
        uzerRepository.save(uzer);
        return uzer;
    }

/** * * * * * * * *
            *** DELETE ALL FOR DEVELOPMENT ***
 */
    @Transactional
    @Override
    public void deleteAll() {
        uzerItemRepository.deleteAll();
        uzerRepository.deleteAll();
    }

/** * * * * * * * *
            *** PRIVATE METHODS ***
     */
    // --- private getUSER - pulls in Lazy fetch for items ---
    private Uzer getUSER(int id) {
        Uzer uzer = uzerRepository.findOne(id);
        uzer.getUserItems().size();
        return uzer;
    }

    // --- hash user password ---
    private byte[] makeDigest(String value, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest msgDgst = MessageDigest.getInstance("SHA-256");
        msgDgst.update(salt);
        return msgDgst.digest(value.getBytes());
    }
}
