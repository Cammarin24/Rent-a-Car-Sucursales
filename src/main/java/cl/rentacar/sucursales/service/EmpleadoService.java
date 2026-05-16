package cl.rentacar.sucursales.service;

import cl.rentacar.sucursales.model.Empleado;
import java.util.List;

public interface EmpleadoService {
    List<Empleado> obtenerTodos();
    Empleado obtenerPorRut(String rut);
    Empleado guardar(Empleado empleado);
    void eliminar(String rut);
}