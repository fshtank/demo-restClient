package com.dev2life.demoRestClient;


import com.dev2life.demoRestClient.model.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@Service
public class RestClientService {
    private final RestClient restClient;

    public RestClientService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("https://fshtank.org").build();
    }

    public UserDTO someRestCall(String name) {
        return this.restClient.get().uri("/demobox/details", name).retrieve().body(UserDTO.class);
    }
}
