package cl.rentacar.sucursales.service;

import cl.rentacar.sucursales.model.Empleado;
import cl.rentacar.sucursales.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado obtenerPorRut(String rut) {
        return empleadoRepository.findById(rut).orElse(null);
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminar(String rut) {
        empleadoRepository.deleteById(rut);
    }
}