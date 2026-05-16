package cl.rentacar.sucursales.service;

import cl.rentacar.sucursales.model.Sucursal;
import cl.rentacar.sucursales.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;

    @Override
    public List<Sucursal> obtenerTodas() {
        return sucursalRepository.findAll();
    }

    @Override
    public Sucursal obtenerPorId(Long id) {
        return sucursalRepository.findById(id).orElse(null);
    }

    @Override
    public Sucursal guardar(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public void eliminar(Long id) {
        sucursalRepository.deleteById(id);
    }
}