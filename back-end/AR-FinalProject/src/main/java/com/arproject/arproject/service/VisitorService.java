package com.arproject.arproject.service;

import com.arproject.arproject.model.Visitor;

import java.util.List;

public interface VisitorService {

    Visitor addVisitor(Visitor visitor);
    Visitor getVisitor(int id);
    List<Visitor> getAllVisitors();

  // --- for development ---
    void deleteAll();

}
