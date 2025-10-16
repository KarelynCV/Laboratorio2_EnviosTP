import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelos.Envio;
import modelos.EnvioAereo;
import modelos.EnvioMaritimo;
import modelos.EnvioTerrestre;

public class FrmEnvios extends JFrame {

    public String[] encabezados = new String[] { "Código", "Cliente", "Peso", "Distancia", "Tipo", "Costo" };

    private JTable tblEnvios;
    private JPanel pnlEditarEnvio;

    private JTextField txtNumero, txtCliente, txtPeso, txtDistancia;
    private JComboBox cmbTipoEnvio;

    public FrmEnvios() {
        setSize(600, 400);
        setTitle("Operador Logístico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JToolBar tbEnvios = new JToolBar();

        JButton btnAgregarEnvio = new JButton();
        btnAgregarEnvio.setIcon(new ImageIcon(getClass().getResource("/iconos/AgregarEnvio.png")));
        btnAgregarEnvio.setToolTipText("Agregar Envío");
        btnAgregarEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarEnvio();
            }
        });
        tbEnvios.add(btnAgregarEnvio);

        JButton btnQuitarEnvio = new JButton();
        btnQuitarEnvio.setIcon(new ImageIcon(getClass().getResource("/iconos/QuitarEnvio.png")));
        btnQuitarEnvio.setToolTipText("Quitar Envío");
        btnQuitarEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quitarEnvio();
            }
        });
        tbEnvios.add(btnQuitarEnvio);

                JPanel pnlEnvios = new JPanel();
        pnlEnvios.setLayout(new BoxLayout(pnlEnvios, BoxLayout.Y_AXIS));
 
        pnlEditarEnvio = new JPanel();
        pnlEditarEnvio.setPreferredSize(new Dimension(pnlEditarEnvio.getWidth(), 250)); 
        pnlEditarEnvio.setLayout(null);

        JLabel lblNumero = new JLabel("Número");
        lblNumero.setBounds(10, 10, 100, 25);
        pnlEditarEnvio.add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(110, 10, 100, 25);
        pnlEditarEnvio.add(txtNumero);

        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(10, 40, 100, 25);
        pnlEditarEnvio.add(lblCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(110, 40, 100, 25);
        pnlEditarEnvio.add(txtCliente);

        JLabel lblPeso = new JLabel("Peso");
        lblPeso.setBounds(10, 70, 100, 25);
        pnlEditarEnvio.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(110, 70, 100, 25);
        pnlEditarEnvio.add(txtPeso);

        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(220, 10, 100, 25);
        pnlEditarEnvio.add(lblTipo);

        cmbTipoEnvio = new JComboBox();
        cmbTipoEnvio.setBounds(320, 10, 100, 25);
        String[] opciones = new String[] { "Terrestre", "Aéreo", "Marítimo" };
        DefaultComboBoxModel mdlTipoEnvio = new DefaultComboBoxModel(opciones);
        cmbTipoEnvio.setModel(mdlTipoEnvio);
        pnlEditarEnvio.add(cmbTipoEnvio);

        JLabel lblDistancia = new JLabel("Distancia en Km");
        lblDistancia.setBounds(220, 40, 100, 25);
        pnlEditarEnvio.add(lblDistancia);

        txtDistancia = new JTextField();
        txtDistancia.setBounds(320, 40, 100, 25);
        pnlEditarEnvio.add(txtDistancia);

        JButton btnGuardarEnvio = new JButton("Guardar");
        btnGuardarEnvio.setBounds(220, 70, 100, 25);
        btnGuardarEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarEnvio();
            }
        });
        pnlEditarEnvio.add(btnGuardarEnvio);

        JButton btnCancelarEnvio = new JButton("Cancelar");
        btnCancelarEnvio.setBounds(320, 70, 100, 25);
        btnCancelarEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarEnvio();
            }
        });
        pnlEditarEnvio.add(btnCancelarEnvio);

        pnlEditarEnvio.setVisible(false); 
     
        tblEnvios = new JTable();
        JScrollPane spListaEnvios = new JScrollPane(tblEnvios);

        DefaultTableModel dtm = new DefaultTableModel(null, encabezados);
        tblEnvios.setModel(dtm);

        pnlEnvios.add(pnlEditarEnvio);
        pnlEnvios.add(spListaEnvios);

        JScrollPane spEnvios = new JScrollPane(pnlEnvios);
        spEnvios.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        getContentPane().add(tbEnvios, BorderLayout.NORTH);
        getContentPane().add(pnlEnvios, BorderLayout.CENTER);
    }

    public void agregarEnvio() {
        pnlEditarEnvio.setVisible(true);
    }

    public void quitarEnvio() {
        int filaSeleccionada = tblEnvios.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) tblEnvios.getModel();
            modelo.removeRow(filaSeleccionada);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un envío para eliminar.", "Aviso",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void guardarEnvio() {
        DefaultTableModel modelo = (DefaultTableModel) tblEnvios.getModel();

        String codigo = txtNumero.getText();
        String cliente = txtCliente.getText();
        String pesoStr = txtPeso.getText();
        String distanciaStr = txtDistancia.getText();
        String tipo = cmbTipoEnvio.getSelectedItem().toString();

        if (codigo.isEmpty() || cliente.isEmpty() || pesoStr.isEmpty() || distanciaStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes completar todos los campos.", "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        double peso, distancia;
        try {
            peso = Double.parseDouble(pesoStr);
            distancia = Double.parseDouble(distanciaStr);
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Peso y distancia deben ser valores numéricos.", "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el tipo correcto de envío
        Envio envio;
        switch (tipo) {
            case "Aéreo":
                envio = new EnvioAereo(codigo, cliente, peso, distancia);
                break;
            case "Marítimo":
                envio = new EnvioMaritimo(codigo, cliente, peso, distancia);
                break;
            default:
                envio = new EnvioTerrestre(codigo, cliente, peso, distancia);
                break;
        }

        // Calcular costo
        double costo = envio.calcularTarifa();

        // Agregar fila a la tabla
        modelo.addRow(new Object[] { codigo, cliente, peso, distancia, tipo, costo });

        // Limpiar campos
        txtNumero.setText("");
        txtCliente.setText("");
        txtPeso.setText("");
        txtDistancia.setText("");
        cmbTipoEnvio.setSelectedIndex(0);

        pnlEditarEnvio.setVisible(false);
    }

    public void cancelarEnvio() {
        pnlEditarEnvio.setVisible(false);
    }

    public static void main(String[] args) {
        FrmEnvios frm = new FrmEnvios();
        frm.setVisible(true);
    }
}