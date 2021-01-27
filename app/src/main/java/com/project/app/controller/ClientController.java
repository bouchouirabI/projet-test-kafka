package com.project.app.controller;

import com.project.app.entity.Client;
import com.project.app.provider.ClientProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("clients")
public class ClientController {

    private final ClientProvider clientProvider;

    @PostMapping
    public ResponseEntity add(@RequestBody Client client){
        clientProvider.add(client);
        return new ResponseEntity(HttpStatus.OK);
    }
}
