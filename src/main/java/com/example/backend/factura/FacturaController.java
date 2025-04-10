package com.example.backend.factura;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @GetMapping
    public List<FacturaDTO> getAll() {
        return facturaService.getAll();
    }

    @GetMapping("/{id}")
    public FacturaDTO getById(@PathVariable Long id) {
        return facturaService.getById(id);
    }

    @PostMapping
    public FacturaDTO addFactura(@RequestBody FacturaDTO facturaDTO) {
        return facturaService.addFactura(facturaDTO);
    }

    @DeleteMapping("/{id}")
    public void deletedFactura(@PathVariable Long id) {
        facturaService.deletedFactura(id);
    }
}
