package EjemploAbstract;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablaPersonas extends AbstractTableModel {
    private String[] columnas = {"ID", "Nombre", "Edad"}; // Creamos columnas
    private ArrayList<Persona> personas = new ArrayList<>(); // Lista de datos

    public ModeloTablaPersonas() {
        // Agregar algunos datos al inicio
        personas.add(new Persona(1, "Matías", 28)); // Agregamos datos al constructor
        personas.add(new Persona(2, "Leo", 34));
        personas.add(new Persona(3, "Pedro", 21));
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

    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }

    public void agregarPersona(Persona persona){
        personas.add(persona);
        fireTableRowsInserted(personas.size() - 1, personas.size() - 1);
    }
}
