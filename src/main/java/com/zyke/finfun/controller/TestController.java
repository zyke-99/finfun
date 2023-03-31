package com.zyke.finfun.controller;

import com.zyke.finfun.model.TestEntity;
import com.zyke.finfun.repository.TestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestRepository testRepository;

    @GetMapping
    public List<TestEntity> getAll() {

        return testRepository.findAll();
    }

    @PostMapping
    public void store(@RequestBody TestEntity testEntity) {

        testRepository.save(testEntity);
    }
}
