/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author JDiego
 */
class ButtonEditor extends DefaultCellEditor {
    private JButton button;
     private JTable table;

    public ButtonEditor(JTable table) {
        super(new JTextField());
        this.table = table;
        button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Manejar el evento de clic aquí
                int filaClickeada = table.getSelectedRow(); // Obtén la fila seleccionada
                System.out.println("Botón clickeado en fila " + filaClickeada);
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        button.setText(value.toString());
        return button;
    }
}