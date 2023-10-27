package ru.kirikura.yaproject_05_sharehouse.request.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;
import ru.kirikura.yaproject_05_sharehouse.request.repository.RequestRepository;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RequestServiceJPA {
    RequestRepository requestRepository;

    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    public Optional<Request> findById(long id) {
        return requestRepository.findById(id);
    }

    public Request save(Request request) {
        return requestRepository.save(request);
    }

    public Request update(Request request) {
        return requestRepository.save(request);
    }

    public void deleteById(long id) {
        requestRepository.deleteById(id);
    }

    public void delete(Request request) {
        requestRepository.delete(request);
    }
}
