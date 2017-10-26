package com.arproject.arproject.service;

import com.arproject.arproject.model.Uzer;
import com.arproject.arproject.model.UzerItem;
import com.arproject.arproject.repository.UzerRepository;
import com.arproject.arproject.repository.UzerItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    // --- private getUSER - pulls in Lazy fetch for items ---
    private Uzer getUSER(int id) {
        Uzer uzer = uzerRepository.findOne(id);
        uzer.getUzerItems().size();
        return uzer;
    }

    @Override
    public Uzer getUzerById(int id) {
        return uzerRepository.findOne(id);
    }

    @Override
    public Uzer addUzer(Uzer uzer) {
        return uzerRepository.save(uzer);
    }

    @Override
    public Uzer updateUzer(Uzer uzer) {
        return uzerRepository.save(uzer);
    }

    @Override
    public void deleteUzer(int id) {
        Uzer uzer = this.getUSER(id);
        uzerItemRepository.delete(uzer.getUzerItems());
        uzerRepository.delete(id);
    }

/** * * * * * * * *
             *** ITEM METHODS ***
 */

    @Override
    public Uzer addItem(UzerItem uzerItem) {
        uzerItemRepository.save(uzerItem);
        Uzer uzer = uzerRepository.findOne(uzerItem.getUzer().getId());
        uzer.getUzerItems().add(uzerItem);
        uzerRepository.save(uzer);
        return getUSER(uzerItem.getUzer().getId());
    }

    @Override
    public Uzer deleteItem(int uzerId, int itemId) {
        UzerItem uzerItem = uzerItemRepository.findOne(itemId);
        uzerItemRepository.delete(itemId);
        Uzer uzer = uzerRepository.findOne(uzerId);
        uzer.getUzerItems().remove(uzerItem);
        uzerRepository.save(uzer);
        return uzer;
    }

/** * * * * * * * *
            *** DELETE ALL FOR DEVELOPMENT ***
 */

    @Override
    public void deleteAll() {
        uzerItemRepository.deleteAll();
        uzerRepository.deleteAll();
    }
}
