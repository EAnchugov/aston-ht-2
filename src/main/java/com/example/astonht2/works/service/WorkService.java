package com.example.astonht2.works.service;

import com.example.astonht2.works.model.Work;
import com.example.astonht2.works.repositry.WorkRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkService {
    private final WorkRepository repository;

    public WorkService(WorkRepository repository) {
        this.repository = repository;
    }

    public Work create() {
        return repository.create();
    }
    public Work getById(Long id) {
        return repository.getById(id);
    }
}
