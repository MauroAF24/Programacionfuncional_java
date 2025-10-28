import java.util.*;
import Alumnos.Alumno;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Alumno> alumnos = Arrays.asList(
                new Alumno("Juan",8.5,"3k9"),
                new Alumno("Luis",7.0,"3k9"),
                new Alumno("Julieta",9.5,"3k9"),
                new Alumno("Camila",8.0,"3k10"),
                new Alumno("Eduardo",9.0,"3k10"),
                new Alumno("Tiziano",10.0,"3k10")
        );

        //Punto 1 Aprobados con una superior a 7,ordenados y en mayúscula
        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >=7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .toList();

        System.out.println("Aprobados"+aprobados);

        //Punto 2 Promedio General
        double promediogeneral= alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);

        System.out.println("Promedio general: " + promediogeneral);


        //Punto 3 Agrupamos por curso
        Map<String,List<Alumno>> agrupados = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        System.out.println("Alumnos agrupados por curso");
        agrupados.forEach((curso,lista)->
                System.out.println(curso + "->"+ lista));

        //Punto 4 top 3 mejores promedios
        List<Alumno> top3= alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .toList();

        System.out.println("TOP 3 de mejores promedios");
        top3.forEach(System.out::println);

    }
}