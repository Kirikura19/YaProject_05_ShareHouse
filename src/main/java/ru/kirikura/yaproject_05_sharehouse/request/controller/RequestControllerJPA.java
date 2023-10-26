package ru.kirikura.yaproject_05_sharehouse.request.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;
import ru.kirikura.yaproject_05_sharehouse.request.service.RequestServiceJPA;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/requests")
public class RequestControllerJPA {
    RequestServiceJPA requestService;

    @GetMapping()
    public List<Request> findAll() {
        return requestService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Request> findById(@PathVariable long id) {
        return requestService.findById(id);
    }

    @PostMapping
    public Request save(@RequestBody Request request) {
        return requestService.save(request);
    }

    @PatchMapping
    public Request update(Request request) {
        return requestService.update(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        requestService.deleteById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Request request) {
        requestService.delete(request);
    }
}
