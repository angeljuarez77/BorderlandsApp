package com.example.server.controller;
import com.example.server.model.Characters;
import com.example.server.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
//http://localhost:8080/characters

public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping
    public Iterable<Characters> getCharacters() {
        return characterService.getCharacters();
    }

    @GetMapping("/{id}")
    public Characters findCharacterById(@PathVariable Long id) {
        return characterService.findCharacterById(id);
    }

    @PostMapping
    public Characters createCharacter(@RequestBody Characters characters) {
        return characterService.createCharacter(characters);
    }

    @PatchMapping("/{id}")
    public Characters updateCharacter(@RequestBody Characters characters) {
        return characterService.updateCharacter(characters);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCharacter(@RequestParam Long id) {
        return characterService.deleteCharacter(id);
    }
}
