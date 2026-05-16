package cl.rentacar.sucursales.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @Column(name = "rut_empleado", length = 20)
    private String rutEmpleado; // Llave primaria según el diagrama

    @Column(name = "nombre_empleado", nullable = false, length = 100)
    private String nombreEmpleado;

    @Column(name = "apellido_empleado", nullable = false, length = 100)
    private String apellidoEmpleado;

    @Column(nullable = false, length = 50)
    private String cargo;

    // Relación: Muchos empleados pertenecen a una sucursal
    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;
}