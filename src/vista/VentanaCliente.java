package vista;

import modelo.Cliente;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class VentanaCliente extends JFrame {
    
    //Estuctura de datos y control de índice
    private ArrayList<Cliente> listaClientes;
    private int indiceActual = 0;

    //Etiquetas para identificar los campos de texto
    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;
    private JLabel puntosLabel;

    //Text fields para introducir números (ahora son de Swing: JTextField)
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField puntosField;

    private JButton atrasButton;
    private JButton delanteButton;

    public VentanaCliente() {
        super("Gestión de Clientes");

        //Lo que pasa si cerramos la ventana (sustituye al WindowListener
        //con windowClosing y System.exit(0) de la versión anterior).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Iniciar la estructura de datos y añadir 3 clientes precargados
        listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(1, "Amador Moreno", 19, 727.0));
        listaClientes.add(new Cliente(2, "Adán Morales", 20, 50.50));
        listaClientes.add(new Cliente(3, "Luis Delgado", 19, 10.01));

        //Crea las etiquetas.
        numeroLabel = new JLabel("Número: ");
        nombreLabel = new JLabel("Nombre: ");
        edadLabel = new JLabel("Edad: ");
        puntosLabel = new JLabel("Puntos: ");

        //Campo donde vamos a introducir el número
        numeroField = new JTextField(10);
        numeroField.setEditable(false);

        //Campo que nos muestra el doble del numero introducido
        nombreField = new JTextField(10);
        nombreField.setEditable(false);
        nombreField.setForeground(Color.red);
                
        edadField = new JTextField(10);
        edadField.setEditable(false);
        edadField.setForeground(Color.blue);
        
        puntosField = new JTextField(10);
        puntosField.setEditable(false);
        puntosField.setForeground(Color.orange);
        
        //Lógica del botón "Atrás"
        atrasButton = new JButton("Atrás");
        atrasButton.setMnemonic(KeyEvent.VK_I);
        atrasButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                if (indiceActual > 0) {
                    indiceActual--;
                    mostrarClienteActual();
                }
                System.out.println("Atrás");
            }
        });
        
        //Lógica del botón "Siguiente"
        delanteButton = new JButton("Siguiente");
        delanteButton.setMnemonic(KeyEvent.VK_I);
        delanteButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                if (indiceActual < listaClientes.size() - 1) {
                    indiceActual++;
                    mostrarClienteActual();
                }
                System.out.println("Siguiente");
            }
        });

        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);
        labelPane.add(puntosLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        fieldPane.add(puntosField);
        
        //Dispone los botones de atrás y siguiente
        JPanel botonesPane = new JPanel();
        botonesPane.setLayout(new GridLayout(1, 0));
        botonesPane.add(atrasButton);
        botonesPane.add(delanteButton);

        //Incluye los dos paneles en otro panel,
        //etiquetas a la izquierda
        //y campos de texto a la derecha.
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
               BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(labelPane, BorderLayout.CENTER);
        contentPane.add(fieldPane, BorderLayout.EAST);
        contentPane.add(botonesPane, BorderLayout.SOUTH);

        setContentPane(contentPane);  //this.setContentPane(contentPane);
          // es set, o sea, machado el contenedor del objeto "Doble", hijo de JFrame
          
        mostrarClienteActual();

    }
    
    public void mostrarClienteActual() {
        Cliente c = listaClientes.get(indiceActual);
        
        //Usamos los métodos "get" del modelo
        numeroField.setText(String.valueOf(c.getNumero()));
        nombreField.setText(c.getNombre());
        edadField.setText(String.valueOf(c.getEdad()));
        puntosField.setText(String.valueOf(c.getPuntos()));
        
        //Activar o desactivar botones según los clientes que existan
        atrasButton.setEnabled(indiceActual > 0);
        delanteButton.setEnabled(indiceActual < listaClientes.size() - 1);
        
    }

    public static void main(String[] args) {

        // Toda la interfaz Swing se crea en el hilo de eventos (receta: se hace siempre así).
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final VentanaCliente app = new VentanaCliente();
                
                app.pack();
                app.setVisible(true);
            }
        });
    }
}
