package cl.rentacar.sucursales.service;

import cl.rentacar.sucursales.model.Sucursal;
import java.util.List;

public interface SucursalService {
    List<Sucursal> obtenerTodas();
    Sucursal obtenerPorId(Long id);
    Sucursal guardar(Sucursal sucursal);
    void eliminar(Long id);
}