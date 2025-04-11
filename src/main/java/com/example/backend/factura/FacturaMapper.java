package com.example.backend.factura;

import com.example.backend.partida.Partida;
import com.example.backend.partida.PartidaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FacturaMapper {

    @Autowired
    private PartidaMapper partidaMapper;

    public FacturaDTO toDTO(Factura factura) {
        FacturaDTO dto = new FacturaDTO();

        dto.setId(factura.getId());
        dto.setFolio(factura.getFolio());
        dto.setFechaExpedicion(factura.getFechaExpedicion());
        dto.setSubtotal(factura.getSubtotal());
        dto.setTotal(factura.getTotal());

        if (factura.getPartidas() != null) {
            dto.setPartidas(factura.getPartidas().stream()
                    .map(partidaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public Factura toEntity(FacturaDTO dto) {
        Factura factura = new Factura();

        factura.setId(dto.getId());
        factura.setFolio(dto.getFolio());
        factura.setFechaExpedicion(dto.getFechaExpedicion());
        factura.setSubtotal(dto.getSubtotal());
        factura.setTotal(dto.getTotal());

        if (dto.getPartidas() != null) {
            List<Partida> partidas = dto.getPartidas().stream()
                    .map(partidaDTO -> {
                        Partida partida = partidaMapper.toEntity(partidaDTO);
                        partida.setFactura(factura);
                        return partida;
                    }).collect(Collectors.toList());
            factura.setPartidas(partidas);
        }

        return factura;
    }

}
