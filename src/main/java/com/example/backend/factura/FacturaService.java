package com.example.backend.factura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private FacturaMapper facturaMapper;

    public List<FacturaDTO> getAll() {
        return facturaRepository.findAll().stream()
                .map(facturaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FacturaDTO getById(Long id) {
        Factura factura = facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro la factura con el id '" + id + "'"));
        return facturaMapper.toDTO(factura);
    }

    public FacturaDTO addFactura(FacturaDTO facturaDTO) {
        Factura factura = facturaMapper.toEntity(facturaDTO);
        validarFactura(factura);
        Factura facturaNueva = facturaRepository.save(factura);

        return facturaMapper.toDTO(facturaNueva);
    }

    public void deletedFactura(Long id) {
        if (!facturaRepository.existsById(id)) {
            throw new RuntimeException("No se encontro la factura con el id '" + id + "'");
        }
        facturaRepository.deleteById(id);
    }

    private void validarFactura(Factura factura) {

//        if (factura.getFolio() == null || factura.getFolio().trim().isEmpty()) {
//            throw new RuntimeException("El folio no puede estar bacio");
//        }
//
//        if (factura.getFechaExpedicion() == null) {
//            throw new RuntimeException("La fecha no puede estar bacia");
//        }
//
//        if (factura.getSubtotal() == null || factura.getSubtotal() <= 0) {
//            throw new RuntimeException("El subtotal no puede ser menor a 0");
//        }
//
//        if (factura.getTotal() == null || factura.getTotal() <= 0) {
//            throw new RuntimeException("El total no puede ser menor a 0");
//        }
    }

}

