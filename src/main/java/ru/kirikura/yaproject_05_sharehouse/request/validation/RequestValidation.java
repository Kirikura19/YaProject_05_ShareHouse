package ru.kirikura.yaproject_05_sharehouse.request.validation;

import ru.kirikura.yaproject_05_sharehouse.request.exception.RequestNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;
import ru.kirikura.yaproject_05_sharehouse.request.repository.RequestRepository;

public class RequestValidation {
    static RequestRepository requestRepository;
    public static Request checkIsRequestExists(long itemId) {
        return requestRepository.findById(itemId).orElseThrow(()
                -> new RequestNotFoundException("Request is not exists"));
    }
}