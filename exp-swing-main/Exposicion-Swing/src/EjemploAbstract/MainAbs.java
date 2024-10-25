package EjemploAbstract;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainAbs extends JFrame {
        public static void main(String[] args) {
            // Creación del MODELO
            ModeloTablaPersonas modelo = new ModeloTablaPersonas();

            // Creación de panel y boton
            JPanel panel = new JPanel(); // Creamos un panel para que este contenga el boton
            JButton botonAgregar = new JButton("Agregar"); // Creación del botón
            panel.add(botonAgregar); // Agregamos el botón al panel

            // Llama al metodo para cuando se le haga clic al botón
            botonAgregar.addActionListener(e -> {
                modelo.agregarPersona(new Persona(modelo.getRowCount() + 1, "Nombre agregado", 15));
            });

            // Crear la JTable con el modelo y ScrollPane
            JTable tabla = new JTable(modelo);
            JScrollPane tablaFinal = new JScrollPane(tabla);

            // Crear un JFrame(ventana) donde agregamos la tabla con el ScrollPane y el panel
            JFrame ventana = new JFrame("Ejemplo AbstractTableModel");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.add(tablaFinal, BorderLayout.CENTER); // Esto indica que va al medio
            ventana.add(panel, BorderLayout.PAGE_END);

            // Configurar tamaño y mostrar
            ventana.setSize(400, 200);
            ventana.setVisible(true);
        }
}
