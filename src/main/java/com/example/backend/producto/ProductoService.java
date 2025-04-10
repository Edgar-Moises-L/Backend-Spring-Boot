package com.example.backend.producto;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductoDTO> getAll() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductoDTO getById(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el id '" + id + "'"));
        return productoMapper.toDTO(producto);
    }

    @Transactional
    public ProductoDTO addProducto(ProductoDTO productoDTO) {
        Producto producto = productoMapper.toEntity(productoDTO);
        validarProducto(producto);
        Producto productoNuevo = productoRepository.save(producto);

        return productoMapper.toDTO(productoNuevo);
    }

    @Transactional
    public ProductoDTO updateProducto(ProductoDTO productoDTO, Long id) {
        Producto productoGuardado = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el id '" + id + "'"));

        Producto productoNuevo = productoMapper.toEntity(productoDTO);
        validarProducto(productoNuevo);

        productoGuardado.setNombre(productoNuevo.getNombre());
        productoGuardado.setCantidad(productoNuevo.getCantidad());
        productoGuardado.setPrecio(productoNuevo.getPrecio());

        productoRepository.save(productoGuardado);

        return productoMapper.toDTO(productoGuardado);
    }

    @Transactional
    public void deleteProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("No se encontro el Producto con id '" + id + "'");
        }
        productoRepository.deleteById(id);
    }


    private void validarProducto(Producto producto) {
        if (producto.getCodigo() == null || producto.getCodigo().trim().isEmpty()) {
            throw new RuntimeException("El codigo no puede estar vacio.");
        }

        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new RuntimeException("El nombre no puede estar vacio.");
        }

        if (producto.getPrecio() == null || producto.getPrecio() <= 0) {
            throw new RuntimeException("El precio debe tener un valor mayor a 0.");
        }

        if (producto.getCantidad() == null || producto.getCantidad() <= 0) {
            throw new RuntimeException("La cantidad debe tener un valor mayor a 0.");
        }


    }
}
