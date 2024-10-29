package ru.agaev.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agaev.springcourse.models.Status;
import ru.agaev.springcourse.repositories.StatusesRepository;

import java.util.List;

@Service
public class StatusesService {

    @Autowired
    private StatusesRepository statusesRepository;

    public List<Status> findAll() {
        return statusesRepository.findAll(); // Метод для получения всех статусов
    }

    public Status getStatusById(int id) {
        return statusesRepository.findById(id).orElse(null);
    }

    public Status getStatusByName(String statusName) {
        return statusesRepository.findByStatusName(statusName);
    }
}
