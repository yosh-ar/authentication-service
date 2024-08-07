package com.example.Service_auth.controllers.games;

import com.example.Service_auth.commons.constans.ApiPathConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.GAME_ROUTE)
@RestController
public class GameController {
    @GetMapping
    ResponseEntity<String> getGameWelcome(){
        return ResponseEntity.ok("Bienvenido al jueg");
    }
}
