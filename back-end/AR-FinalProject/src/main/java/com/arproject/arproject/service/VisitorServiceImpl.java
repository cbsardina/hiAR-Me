package com.arproject.arproject.service;

import com.arproject.arproject.model.Visitor;
import com.arproject.arproject.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

/** * * * * * * * *
                 *** VISITOR METHODS ***
 */
    @Transactional
    @Override
    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Transactional(readOnly = true)
    @Override
    public Visitor getVisitor(int id) {
        return visitorRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

/** * * * * * * * *
                 *** DELETE ALL ***
 */
    @Transactional
    @Override
    public void deleteAll() {
        visitorRepository.deleteAll();
    }
}
