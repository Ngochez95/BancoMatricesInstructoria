package bancomatrices;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BancoMatrices {

    public static void main(String[] args) {
        Object banco[][] = new Object[25][3];
        boolean estado = true, busquedaUser = false;
        int opcion, contadorCuenta = 0, posicion = 0;
        double efectivo;
        String salida = "", nombre, historial, busqueda;
        JTextArea hoja = new JTextArea();
        salida += "Cliente\tefectivo\thistorial\n";
        for (int fila = 0; fila < 25; fila++) {
            for (int columna = 0; columna < 1; columna++) {
                if (banco[fila][columna] == null) {
                    banco[fila][columna] = "sin nombre";
                }
            }
        }
        for (int fila = 0; fila < 25; fila++) {
            for (int columna = 0; columna < 2; columna++) {
                if (banco[fila][columna] == null) {
                    banco[fila][columna] = 0.0;
                }
            }
        }
        for (int fila = 0; fila < 25; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (banco[fila][columna] == null) {
                    banco[fila][columna] = "sin historial";
                }
            }
        }

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Banco UES\n1-Ver cuentas\n2-Crear cuenta\n3-Ingreso de efectivo\n4-Retiro de efectivo"));

            switch (opcion) {
                case 1:
                    for (int fila = 0; fila < 25; fila++) {
                        for (int columna = 0; columna < 3; columna++) {
                            salida += banco[fila][columna] + "\t";
                        }
                        salida += "\n";
                    }
                    hoja.setText(salida);
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 2:
                    nombre = JOptionPane.showInputDialog("ingrese el nombre del cliente #" + (contadorCuenta + 1));
                    banco[contadorCuenta][0] = nombre;
                    efectivo = Double.parseDouble(JOptionPane.showInputDialog("ingrese su efectivo inicial"));
                    if (efectivo < 0) {
                        JOptionPane.showMessageDialog(null, "error, La cantidad debe de ser mayor a cero");
                    } else {
                        banco[contadorCuenta][1] = efectivo;
                        historial = "Creación de cuenta del cliente: " + nombre + " con saldo inicial de $" + efectivo;
                        banco[contadorCuenta][2] = historial;
                        contadorCuenta++;
                        historial = "";

                    }

                    break;
                case 3:
                    busqueda = JOptionPane.showInputDialog("ingrese su nombre de usuario");
                    for (int fila = 0; fila < 25; fila++) {
                        if (String.valueOf(banco[fila][0]).equals(busqueda)) {
                            busquedaUser = true;
                            posicion = fila;

                        }
                    }
                    if (busquedaUser) {
                        efectivo = Double.parseDouble(JOptionPane.showInputDialog("usuario " + banco[posicion][0] + "\n ingrese la cantidad que desea abonar a su cuenta"));
                        if (efectivo<0) {
                            JOptionPane.showMessageDialog(null, "Error!\nIngrese una cantidad válida");
                        } else {
                            banco[posicion][1] = Double.parseDouble(String.valueOf(banco[posicion][1])) + efectivo;
                            historial = "El cliente: " + banco[posicion][0] + " hizo un abono de $" + efectivo;
                            banco[posicion][2] = historial;
                            historial = "";
                        }
                    }
                    break;
                case 4:
                    busqueda = JOptionPane.showInputDialog("ingrese su nombre de usuario");
                    for (int fila = 0; fila < 25; fila++) {
                        if (String.valueOf(banco[fila][0]).equals(busqueda)) {
                            busquedaUser = true;
                            posicion = fila;

                        }
                    }
                    if (busquedaUser) {
                        efectivo = Double.parseDouble(JOptionPane.showInputDialog("usuario " + banco[posicion][0] + "\n ingrese la cantidad que desea retirar"));
                        if (Double.parseDouble(String.valueOf(banco[posicion][1])) < efectivo) {
                            JOptionPane.showMessageDialog(null, "Error!\nNo dispone de la cantidad necesario para realizar el retiro");
                        } else {
                            banco[posicion][1] = Double.parseDouble(String.valueOf(banco[posicion][1])) - efectivo;
                            historial = "El cliente: " + banco[posicion][0] + " hizo un retiro de $" + efectivo;
                            banco[posicion][2] = historial;
                            historial = "";
                        }
                    }
                    break;
                case 5:
                    break;

            }
            busqueda="";
            salida = "";
            hoja.setText("");
            busquedaUser=false;
        } while (estado);

    }

}
