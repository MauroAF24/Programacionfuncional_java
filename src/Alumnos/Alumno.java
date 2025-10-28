package Alumnos;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Alumno {
    private String nombre;
    private double nota;
    private String curso;
}
