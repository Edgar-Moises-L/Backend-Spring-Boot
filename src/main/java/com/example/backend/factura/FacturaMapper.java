package com.example.backend.factura;

import org.springframework.stereotype.Component;

@Component
public class FacturaMapper {

    public FacturaDTO toDTO(Factura factura) {
        FacturaDTO dto = new FacturaDTO();

        dto.setId(factura.getId());
        dto.setFolio(factura.getFolio());
        dto.setFechaExpedicion(factura.getFechaExpedicion());
        dto.setSubtotal(factura.getSubtotal());
        dto.setTotal(factura.getTotal());

        return dto;
    }

    public Factura toEntity(FacturaDTO dto) {
        Factura factura = new Factura();

        factura.setId(dto.getId());
        factura.setFolio(dto.getFolio());
        factura.setFechaExpedicion(dto.getFechaExpedicion());
        factura.setSubtotal(dto.getSubtotal());
        factura.setTotal(dto.getTotal());

        return factura;
    }

}
