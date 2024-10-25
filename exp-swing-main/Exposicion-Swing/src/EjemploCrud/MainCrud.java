package EjemploCrud;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainCrud extends JFrame {
    private final JTable tabla;  // Declarado como final
    private final ModeloTablaPersonas modelo;  // Declarado como final

    public MainCrud() {
        // Configuración del frame
        this.setTitle("CRUD con JTable");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Crear el modelo personalizado de la tabla
        modelo = new ModeloTablaPersonas();
        tabla = new JTable(modelo);

        // Agregar la tabla en un JScrollPane
        this.add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Crear botones para CRUD
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        this.add(panelBotones, BorderLayout.SOUTH);

        // Acción para agregar una fila
        btnAgregar.addActionListener(e -> {
            // Agregar una nueva persona al modelo
            modelo.agregarPersona(new Persona(modelo.getIdColumna(modelo.getRowCount()-1, 0) + 1, JOptionPane.showInputDialog("Ingresa nombre:"), Integer.parseInt(JOptionPane.showInputDialog("Ingresa edad: "))));
        });

        // Acción para eliminar la fila seleccionada
        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = tabla.getSelectedRow();
            if (filaSeleccionada != -1) {
                modelo.eliminarPersona(filaSeleccionada);  // Eliminar la fila en el modelo
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
            }
        });

        // Configurar tamaño y mostrar
        this.setSize(400, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainCrud());
    }
}

// Clase Persona



