package com.example.backend.partida;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartidaService {
    private static final Logger log = LoggerFactory.getLogger(PartidaService.class);
    @Autowired
    PartidaRepository partidaRepository;

    @Autowired
    PartidaMapper partidaMapper;

    public List<PartidaDTO> getAll() {
        return partidaRepository.findAll().stream()
                .map(partidaMapper::toDTO).collect(Collectors.toList());
    }

    public PartidaDTO getById(Long id) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro la partida con el id '" + id + "'"));
        return partidaMapper.toDTO(partida);
    }

    public PartidaDTO addPartida(PartidaDTO partidaDTO) {
        Partida partida = partidaMapper.toEntity(partidaDTO);
        validarPartida(partida);
        Partida partidaNueva = partidaRepository.save(partida);
        return partidaMapper.toDTO(partidaNueva);
    }

    public void deletedPartida(Long id) {
        if (!partidaRepository.existsById(id)) {
            throw new RuntimeException("No se encontro la partida con el id '" + id + "'");
        }
        partidaRepository.deleteById(id);
    }

    private void validarPartida(Partida partida) {
        if(partida.getNombre()==null || partida.getNombre().trim().isEmpty()){
            throw new RuntimeException("El nombre del producto no puede estar bacio");
        }

        if(partida.getCantidad() == null || partida.getCantidad() <= 0){
            throw new RuntimeException("La cantidad de producto no puede ser 0");
        }

        if(partida.getPrecio() == null || partida.getPrecio() <= 0){
            throw new RuntimeException("El precio del producto no puede ser 0");
        }

        if(partida.getTotal() == null || partida.getTotal() <= 0){
            throw new RuntimeException("El total de la compra no puede ser 0");
        }
    }
}
