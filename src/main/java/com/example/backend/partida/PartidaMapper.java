package com.example.backend.partida;

import org.springframework.stereotype.Component;

@Component
public class PartidaMapper {

    public PartidaDTO toDTO(Partida partida) {
        PartidaDTO dto = new PartidaDTO();

        dto.setId(partida.getId());
        dto.setNombre(partida.getNombre());
        dto.setCantidad(partida.getCantidad());
        dto.setPrecio(partida.getPrecio());
        dto.setTotal(partida.getTotal());

        return dto;
    }

    public Partida toEntity(PartidaDTO dto) {
        Partida partida = new Partida();

        partida.setId(dto.getId());
        partida.setNombre(dto.getNombre());
        partida.setCantidad(dto.getCantidad());
        partida.setPrecio(dto.getPrecio());
        partida.setTotal(dto.getTotal());

        return partida;
    }
}
