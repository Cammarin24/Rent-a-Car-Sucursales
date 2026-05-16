package cl.rentacar.sucursales.controller;

import cl.rentacar.sucursales.model.Empleado;
import cl.rentacar.sucursales.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.obtenerTodos());
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable String rut) {
        Empleado empleado = empleadoService.obtenerPorRut(rut);
        if (empleado != null) {
            return ResponseEntity.ok(empleado);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        return new ResponseEntity<>(empleadoService.guardar(empleado), HttpStatus.CREATED);
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable String rut) {
        empleadoService.eliminar(rut);
        return ResponseEntity.noContent().build();
    }
}