package cl.rentacar.sucursales.controller;

import cl.rentacar.sucursales.model.Sucursal;
import cl.rentacar.sucursales.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Sucursal>> listarSucursales() {
        return ResponseEntity.ok(sucursalService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> obtenerSucursal(@PathVariable Long id) {
        Sucursal sucursal = sucursalService.obtenerPorId(id);
        if (sucursal != null) {
            return ResponseEntity.ok(sucursal);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sucursal> crearSucursal(@RequestBody Sucursal sucursal) {
        return new ResponseEntity<>(sucursalService.guardar(sucursal), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSucursal(@PathVariable Long id) {
        sucursalService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}