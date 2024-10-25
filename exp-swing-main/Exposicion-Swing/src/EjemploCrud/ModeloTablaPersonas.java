package EjemploCrud;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

// Modelo de tabla con métodos para agregar y eliminar filas
public class ModeloTablaPersonas extends AbstractTableModel {
    private String[] columnas = {"ID", "Nombre", "Edad"};
    private ArrayList<Persona> personas = new ArrayList<>();

    public ModeloTablaPersonas() {
        personas.add(new Persona(1, "Carlos", 28));
        personas.add(new Persona(2, "María", 34));
    }

    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Persona persona = personas.get(fila);
        switch (columna) {
            case 0: return persona.getId();
            case 1: return persona.getNombre();
            case 2: return persona.getEdad();
        }
        return null;
    }

    public int getIdColumna(int fila, int columna) {
        Persona persona = personas.get(fila);
        return persona.getId();
    }

    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }

    // Metodo para agregar una nueva fila
    public void agregarPersona(Persona persona) {
        personas.add(persona);
        fireTableRowsInserted(personas.size() - 1, personas.size() - 1);  // Notificar a la tabla
    }

    // Metodo para eliminar una fila
    public void eliminarPersona(int fila) {
        personas.remove(fila);
        fireTableRowsDeleted(fila, fila);  // Notificar a la tabla
    }
}
