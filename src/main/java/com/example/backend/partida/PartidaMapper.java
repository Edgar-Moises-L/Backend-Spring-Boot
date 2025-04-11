package com.example.backend.partida;

import com.example.backend.factura.Factura;
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
        dto.setFactura_id(partida.getFactura().getId());


        return dto;
    }

    public Partida toEntity(PartidaDTO dto) {
        Partida partida = new Partida();

        partida.setId(dto.getId());
        partida.setNombre(dto.getNombre());
        partida.setCantidad(dto.getCantidad());
        partida.setPrecio(dto.getPrecio());
        partida.setTotal(dto.getTotal());

        Factura factura = new Factura();
        factura.setId(dto.getFactura_id());
        partida.setFactura(factura);

        return partida;
    }
}
