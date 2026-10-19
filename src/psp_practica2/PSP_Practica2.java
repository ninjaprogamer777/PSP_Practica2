package psp_practica2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PSP_Practica2 extends JFrame
{

    //Etiquetas para identificar los campos de texto
    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;

    //Text fields para introducir números (ahora son de Swing: JTextField)
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;

    private JButton atrasButton;
    private JButton delanteButton;

    public PSP_Practica2() {
        super("Doble");

        //Lo que pasa si cerramos la ventana (sustituye al WindowListener
        //con windowClosing y System.exit(0) de la versión anterior).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crea las etiquetas.
        numeroLabel = new JLabel("Número: ");
        nombreLabel = new JLabel("Nombre: ");
        edadLabel = new JLabel("Edad: ");

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
        
        atrasButton = new JButton("Atrás");
        atrasButton.setMnemonic(KeyEvent.VK_I);
        atrasButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                System.out.println("Atrás");
            }
        });
        
        delanteButton = new JButton("Siguiente");
        delanteButton.setMnemonic(KeyEvent.VK_I);
        delanteButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                System.out.println("Siguiente");
            }
        });

        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        
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

    }

    public static void main(String[] args) {

        // Toda la interfaz Swing se crea en el hilo de eventos (receta: se hace siempre así).
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final PSP_Practica2 app = new PSP_Practica2();
                
                app.pack();
                app.setVisible(true);
            }
        });
    }



}
