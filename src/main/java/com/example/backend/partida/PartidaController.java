package com.example.backend.partida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidas")
public class PartidaController {
    @Autowired
    PartidaService partidaService;

    @GetMapping
    public List<PartidaDTO> getAll() {
        return partidaService.getAll();
    }

    @GetMapping("/{id}")
    public PartidaDTO getById(@PathVariable Long id) {
        return partidaService.getById(id);
    }

    @PostMapping
    public PartidaDTO addPartida(@RequestBody PartidaDTO partidaDTO) {
        return partidaService.addPartida(partidaDTO);
    }

    @DeleteMapping("/{id}")
    public void deletedPartida(@PathVariable Long id) {
         partidaService.deletedPartida(id);
    }
}
