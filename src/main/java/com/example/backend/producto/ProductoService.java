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

    public List<ProductoDTO> getAll(){
        return productoRepository.findAll().stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductoDTO getById(Long id){
         Producto producto = productoRepository.findById(id).orElse(null);
         return productoMapper.toDTO(producto);
    }

    @Transactional
    public ProductoDTO addProducto(ProductoDTO productoDTO){
        Producto producto = productoMapper.toEntity(productoDTO);
        Producto productoNuevo = productoRepository.save(producto);

        return productoMapper.toDTO(productoNuevo);
    }

    @Transactional
    public void deleteProducto(Long id){
        productoRepository.deleteById(id);
    }

}
