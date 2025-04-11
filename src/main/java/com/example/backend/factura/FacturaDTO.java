package com.example.backend.factura;

import com.example.backend.partida.PartidaDTO;

import java.util.Date;
import java.util.List;

public class FacturaDTO {
    private Long id;
    private String folio;
    private Date fechaExpedicion;
    private Double subtotal;
    private Double total;
    private List<PartidaDTO> partidas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public List<PartidaDTO> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidaDTO> partidas) {
        this.partidas = partidas;
    }
}
