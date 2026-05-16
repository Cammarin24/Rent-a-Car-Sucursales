package cl.rentacar.sucursales.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long idSucursal;

    @Column(name = "nombre_sucursal", nullable = false, length = 100)
    private String nombreSucursal;

    @Column(name = "direccion_sucursal", nullable = false, length = 255)
    private String direccionSucursal;

    @Column(name = "telefono_sucursal", length = 20)
    private String telefonoSucursal;
}