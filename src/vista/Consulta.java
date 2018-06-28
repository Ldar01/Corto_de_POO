/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.ProductoDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame {

    public JLabel lblCodigo, lblPrecio, lblNombre, lblCantidad, lblTipo, lblDisponibilidad;

    public JTextField codigo, precio, nombre, cantidad;
    public JComboBox tipo;

    ButtonGroup existencia = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;

    public JPanel table;

    public JButton buscar, eliminar, insertar, limpiar, actualizar;

    private static final int ANCHOC = 130, ALTOC = 30;

    DefaultTableModel tm;

    public Consulta() {
        super("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblCodigo);
        container.add(lblPrecio);
        container.add(lblNombre);
        container.add(lblCantidad);
        container.add(lblTipo);
        container.add(lblDisponibilidad);
        container.add(codigo);
        container.add(precio);
        container.add(tipo);
        container.add(nombre);
        container.add(cantidad);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(600, 600);
        eventos();
    }

    public final void agregarLabels() {
        lblCodigo = new JLabel("Codigo: ");
        lblPrecio = new JLabel("Precio: ");
        lblNombre = new JLabel("Nombre: ");
        lblCantidad = new JLabel("Cantidad: ");
        lblTipo = new JLabel("Tipo: ");
        lblDisponibilidad = new JLabel("Disponibilidad: ");
        lblCodigo.setBounds(10, 10, ANCHOC, ALTOC);
        lblPrecio.setBounds(10, 60, ANCHOC, ALTOC);
        lblNombre.setBounds(10, 100, ANCHOC, ALTOC);
        lblCantidad.setBounds(10, 140, ANCHOC, ALTOC);
        lblTipo.setBounds(10, 180, ANCHOC, ALTOC);
        lblDisponibilidad.setBounds(10, 240, ANCHOC, ALTOC);

    }

    public final void formulario() {
        codigo = new JTextField();
        precio = new JTextField();
        tipo = new JComboBox();
        nombre = new JTextField();
        cantidad = new JTextField();
        si = new JRadioButton("Si", true);
        no = new JRadioButton("No");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");

        table = new JPanel();

        tipo.addItem("Fruta");
        tipo.addItem("Verdura");
        tipo.addItem("Bebida");
        tipo.addItem("Dulce");

        existencia = new ButtonGroup();
        existencia.add(si);
        existencia.add(no);

        codigo.setBounds(140, 10, ANCHOC, ALTOC);
        precio.setBounds(140, 60, ANCHOC, ALTOC);
        tipo.setBounds(140, 180, ANCHOC, ALTOC);
        nombre.setBounds(140, 100, ANCHOC, ALTOC);
        cantidad.setBounds(140, 140, ANCHOC, ALTOC);
        si.setBounds(140, 240, 50, ALTOC);
        no.setBounds(210, 240, 50, ALTOC);

        buscar.setBounds(300, 10, ANCHOC, ALTOC);
        insertar.setBounds(10, 310, ANCHOC, ALTOC);
        actualizar.setBounds(150, 310, ANCHOC, ALTOC);
        eliminar.setBounds(300, 310, ANCHOC, ALTOC);
        limpiar.setBounds(450, 310, ANCHOC, ALTOC);
        resultados = new JTable();
        table.setBounds(10, 350, 500, 200);
        table.add(new JScrollPane(resultados));
    }

    public void llenarTabla() {
        tm = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    case 4:
                        return Integer.class;
                    case 5:
                        return Double.class;
                    default:
                        return Boolean.class;
                }
            }
        };

        tm.addColumn("Codigo");
        tm.addColumn("Nombre");
        tm.addColumn("Tipo");
        tm.addColumn("Disponibilidad");
        tm.addColumn("Precio");
        tm.addColumn("Cantidad");

        ProductoDao fd = new ProductoDao();
        ArrayList<Producto> filtros = fd.readAll();

        for (Producto fi : filtros) {
            tm.addRow(new Object[]{fi.getCodigo(), fi.getNombre(), fi.getTipo(), fi.isDisponibilidad(), fi.getPrecio(), fi.getCantidad()});
        }
        resultados.setModel(tm);
    }

    public void eventos() {
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                Producto f = new Producto(codigo.getText(), nombre.getText(), tipo.getSelectedItem().toString(), true, Double.parseDouble(precio.getText()), Integer.parseInt(cantidad.getText()));

                if (no.isSelected()) {
                    f.setDisponibilidad(false);
                }

                if (fd.create(f)) {
                    JOptionPane.showMessageDialog(null, "Filtro registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de crear el filtro");
                }

            }

        });

        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                Producto f = new Producto(codigo.getText(), Integer.parseInt(cantidad.getText()), Double.parseDouble(precio.getText()));

                if (no.isSelected()) {
                    f.setDisponibilidad(false);
                }

                if (fd.update(f)) {
                    JOptionPane.showMessageDialog(null, "Filtro modificado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de modificar el filtro");
                }

            }

        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();

                if (fd.delete(codigo.getText())) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de eliminar el producto");
                }

            }

        });

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                Producto f = fd.read(codigo.getText());

                if (f == null) {
                    JOptionPane.showMessageDialog(null, "El producto buscado no se ha encontrado");
                } else {
                    System.out.println(f);
                    codigo.setText(f.getCodigo());
                    //tipo.setSelectedItem(f.getTipo());
                    nombre.setText(f.getNombre());
                    cantidad.setText(String.valueOf(f.getCantidad()));

                    if (f.isDisponibilidad()) {
                        si.setSelected(true);
                    } else {
                        no.setSelected(true);
                    }
                }

            }

        });

        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

    }

    public void limpiarCampos() {
        codigo.setText("");
        precio.setText("");
        cantidad.setText("");
        tipo.setSelectedItem("Fruta");
        nombre.setText("");
        no.setSelected(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }
}
