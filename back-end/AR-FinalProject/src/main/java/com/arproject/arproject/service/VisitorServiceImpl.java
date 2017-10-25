package com.arproject.arproject.service;

import com.arproject.arproject.model.Visitor;
import com.arproject.arproject.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

  // *** Visitor Methods ***
    @Transactional
    @Override
    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Transactional(readOnly = true)
    @Override
    public Visitor findByEmail(String email) {
        List<Visitor> allVisitors = visitorRepository.findAll();

        for (Visitor visitor: allVisitors) {
            if(visitor.getVisitorEmail().equals(email)) {
                return visitor;
            }
        }
        return null;
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

    @Transactional
    @Override
    public void deleteAll() {
        visitorRepository.deleteAll();
    }
}
