package com.example.backend.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> GetAll(){
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ProductoDTO GetById(@PathVariable Long id){
        return productoService.getById(id);
    }

    @PostMapping
    public ProductoDTO addProducto(@RequestBody ProductoDTO productoDTO){
        return productoService.addProducto(productoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id){
       productoService.deleteProducto(id);
    }

}
