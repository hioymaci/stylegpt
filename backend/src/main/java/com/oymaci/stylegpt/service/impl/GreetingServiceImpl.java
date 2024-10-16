package com.oymaci.stylegpt.service.impl;

import com.oymaci.stylegpt.entity.Greeting;
import com.oymaci.stylegpt.repository.GreetingRepository;
import com.oymaci.stylegpt.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private GreetingRepository repository;

    @Override
    public Optional<Greeting> findById(Integer id) {
        return repository.findById(id);
    }
}
