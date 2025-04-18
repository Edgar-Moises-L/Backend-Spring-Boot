package com.example.backend.factura;

import com.example.backend.partida.Partida;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 5, unique = true)
    private String folio;

    @Column(name = "fecha_expedicion")
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;

    @Column(nullable = false)
    private Double subtotal;

    @Column(nullable = false)
    private Double total;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Partida> partidas;



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

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
}
