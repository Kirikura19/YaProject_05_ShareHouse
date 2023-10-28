package ru.kirikura.yaproject_05_sharehouse.request.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_sharehouse.request.exception.RequestNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;
import ru.kirikura.yaproject_05_sharehouse.request.repository.RequestRepository;

@AllArgsConstructor
@Component
@Data
public class RequestValidation {
    RequestRepository requestRepository;

    public Request checkIsRequestExists(long itemId) {
        return requestRepository.findById(itemId).orElseThrow(()
                -> new RequestNotFoundException("Request is not exists"));
    }
}