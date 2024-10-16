package com.oymaci.stylegpt.service;


import com.oymaci.stylegpt.entity.Greeting;

import java.util.Optional;

public interface GreetingService {

    Optional<Greeting> findById(Integer id);
}
