package com.example.backend.producto;

import com.example.backend.partida.PartidaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> getAll() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ProductoDTO getById(@PathVariable Long id) {
        return productoService.getById(id);
    }

    @PostMapping
    public ProductoDTO addProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.addProducto(productoDTO);
    }

    @PutMapping("/{id}")
    public ProductoDTO updateProducto(@RequestBody ProductoDTO productoDTO, @PathVariable Long id){
        return productoService.updateProducto(productoDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }

}
