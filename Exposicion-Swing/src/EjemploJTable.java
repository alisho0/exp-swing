import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EjemploJTable {
    public static void main(String[] args) {
        // Creamos los datos de la tabla
        String[][] datos = {
                {"1", "Carlos", "28"},
                {"2", "María", "34"},
                {"3", "Pedro", "21"}
        };

        // Nombres de las columnas
        String[] columnas = {"ID", "Nombre", "Edad"};

        // Creación de tabla
        JTable tabla = new JTable(datos, columnas); // Parametros (int, int) o (Object[][], Object[])

        // Crear un JFrame y JScrollPane
        JFrame ventana = new JFrame("Ejemplo de JTable Simple");
        JScrollPane tablaFinal = new JScrollPane(tabla);
        ventana.add(tablaFinal);

        // Configuración de tamaño, mostrar y operación de CLOSE
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

