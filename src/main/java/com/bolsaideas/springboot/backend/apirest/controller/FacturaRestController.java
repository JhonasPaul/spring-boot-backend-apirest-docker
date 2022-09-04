package com.bolsaideas.springboot.backend.apirest.controller;

import com.bolsaideas.springboot.backend.apirest.model.entity.Factura;
import com.bolsaideas.springboot.backend.apirest.model.entity.Producto;
import com.bolsaideas.springboot.backend.apirest.model.service.iClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api")
public class FacturaRestController {

    /*en la interrfaz estan los metodos del crud de factura*/
    @Autowired
    private iClienteService clienteService;

    /*4.- LISTAR FACTURAS*/
    @GetMapping("/facturas/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Factura listarFacturaPorId(@PathVariable Long id) {
        return clienteService.listarFacturaPorId(id);
    }


    /*3.- eliminar factura  -->frontend(facturaService)*/
    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarFactura(@PathVariable Long id) {
        clienteService.eliminarFactura(id);
    }

    /*se puede probar en el postman*/
    /*4.- CREAR FACTURA autocomplete --> app.module.ts*/
    @GetMapping("/facturas/filtrar-productos/{term}")
    public List<Producto> filtrarProductos(@PathVariable String term){
        return clienteService.findProductoByName(term);
    }
}
