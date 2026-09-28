/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import Logica.Calculadora;
import javax.swing.JOptionPane;
/**
 *
 * @author cdval
 */
public class CalculadoraDeNotas {
    public static void main(String[] args) {

        
        int n = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese el numero de estudiantes")
        );

        Calculadora[] estudiantes = new Calculadora[n];

        for (int i = 0; i < n; i++) {
            String nombre = JOptionPane.showInputDialog(
                    "Estudiante " + (i + 1) + "\nIngrese su Nombre"
            );
            String id = JOptionPane.showInputDialog(
                    "Estudiante " + (i + 1) + "\nIngrese su ID"
            );
            double notad = leerNota("Estudiante " + (i + 1) + "\nDigite la nota de Desarrollo", 0.0, 5.0);
            double notam = leerNota("Estudiante " + (i + 1) + "\nDigite la nota de Matemáticas", 0.0, 5.0);

            estudiantes[i] = new Calculadora(id, nombre, notad, notam);
        }

    for (int i = 0; i < n; i++) {
            estudiantes[i].calcularDefinitiva();
            estudiantes[i].mostrarNota();
        }

        
        double notaLimite = leerNota("Digite la nota limite (entre 0.0 y 4.9)", 0.0, 4.9);
        String reporte = "Estudiantes con definitiva superior a " + notaLimite + ":\n";
        boolean hayEstudiantes = false;
        for (int i = 0; i < n; i++) {
            if (estudiantes[i].superaNotaLimite(notaLimite)) {
                reporte += estudiantes[i].obtenerDatos() + "\n";
                hayEstudiantes = true;
            }
        }
        if (!hayEstudiantes) {
            reporte += "Ningun estudiante supera la nota limite.";
        }
        JOptionPane.showMessageDialog(null, reporte);

        
        double cifra = leerNota("Digite la cifra a incrementar (entre 0.0 y 0.5)", 0.0, 0.5);
        String incremento = "Notas de desarrollo despues del incremento:\n";
        for (int i = 0; i < n; i++) {
            estudiantes[i].incrementarNotaDesarrollo(cifra);
            incremento += estudiantes[i].getNombre() + ": "
                    + String.format("%.2f", estudiantes[i].getNotaDesarrollo()) + "\n";
        }
        JOptionPane.showMessageDialog(null, incremento);
    }

}
