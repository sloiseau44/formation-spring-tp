package com.training.springcore.service;

import com.training.springcore.model.Captor;

import java.util.HashSet;
import java.util.Set;

public class CaptorServiceImpl implements CaptorService{

    @Override
    public Set<Captor> findBySite(String siteId) {
        Set<Captor> captors = new HashSet<>();
        if (siteId == null) {
            return captors;
        }
        captors.add(new Captor("Capteur A"));
        return captors;
    }
}
