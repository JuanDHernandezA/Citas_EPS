package Interfaz;

import Logica.DAO.AgendaDAO;
import Logica.DAO.CitaDAO;
import Logica.DAO.ConsultorioDAO;
import Logica.DAO.EspecialidadDAO;
import Logica.DAO.EstadoDAO;
import Logica.DAO.JornadaConsultorioDAO;
import Logica.DAO.SedeDAO;
import Logica.Models.Agenda;
import Logica.Models.Cita;
import Logica.Models.Consultorio;
import Logica.Models.Especialidad;
import Logica.Models.Estado;
import Logica.Models.Medico;
import Logica.Models.Sede;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Time;
import java.util.List;

public class VenAgenda extends javax.swing.JFrame {

    AgendaDAO agendaDAO = new AgendaDAO();
    EspecialidadDAO espDAO = new EspecialidadDAO();
    JornadaConsultorioDAO jcDAO = new JornadaConsultorioDAO();
    ConsultorioDAO conDAO = new ConsultorioDAO();
    SedeDAO sedeDAO = new SedeDAO();
    CitaDAO citaDAO = new CitaDAO();
    EstadoDAO estadoDAO = new EstadoDAO();

    Agenda agenda = new Agenda();
    Especialidad esp = new Especialidad();
    Consultorio consultorio = new Consultorio();
    Sede sede = new Sede();
    List<Cita> citas;
    List<Estado> estados;

    private int dia;
    private int mes;
    private int año;
    private Medico medico;
    private ArrayList<Integer> dias_citas = new ArrayList<Integer>();
    private ArrayList<Time> inicios_citas = new ArrayList<Time>();
    private ArrayList<Time> fines_citas = new ArrayList<Time>();
    private ArrayList<String> tipos_citas = new ArrayList<String>();
    private ArrayList<String> estados_citas = new ArrayList<String>();///////////////////////////////////////////////////////////////

    public VenAgenda(Medico medico) {
        Calendar c = Calendar.getInstance();

        this.medico = medico;

        initComponents();
        setTitle("Agenda médico");
        setLocationRelativeTo(null);
        setVisible(true);

        try {
            agenda = agendaDAO.obtenerAgendaMed(medico);
            this.TxtFechaInicio.setText(agenda.getFecha_inicio().toString());
            this.TxtFechaFin.setText(agenda.getFecha_fin().toString());

            esp = espDAO.obtenerEspecialidad(medico.getEspecialidad().getId());
            this.TxtEspecialidad.setText(esp.getNombre());

            consultorio = conDAO.obtenerConsultorio(jcDAO.obtenerJCMed(medico).getConsultorio().getId());
            this.TxtConsultorio.setText(consultorio.getNumero() + "");

            sede = sedeDAO.obtenerSede(consultorio.getSede().getId());
            this.TxtSede.setText(sede.getNombre());

            this.TxtMedico.setText(medico.getNombre() + " " + medico.getApellido());

            this.TxtConsultorio.setEditable(false);
            this.TxtMedico.setEditable(false);
            this.TxtEspecialidad.setEditable(false);
            this.TxtFechaInicio.setEditable(false);
            this.TxtFechaFin.setEditable(false);
            this.TxtSede.setEditable(false);

            citas = citaDAO.obtenerCitas(agenda.getId());
            estados = estadoDAO.obtenerEstados();

            dia = agenda.getFecha_inicio().getDayOfWeek().getValue();
            mes = agenda.getFecha_inicio().getMonthValue();
            año = agenda.getFecha_inicio().getYear();

        } catch (Exception e) {
            System.out.println("error sql");
            System.out.println(e);
        }

        tabla();
    }

    public void insertar_citas() {
        for (Cita cita : citas) {
            dias_citas.add(cita.getFecha().toLocalDate().getDayOfWeek().getValue());
            inicios_citas.add(Time.valueOf(cita.getHora_inicio()));
            fines_citas.add(Time.valueOf(cita.getHora_fin()));
            //estados_citas.add(cita.getEstado().getId());
        }
    }

    public void tabla() {

        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("Fecha");
        model.addColumn("Hora Inicio");
        model.addColumn("Hora Fin");
        model.addColumn("Estado");
        //model.addColumn("Atender");

        for (Cita cita : citas) {

            for (Estado estado : estados) {
                if (cita.getEstado().getId() == estado.getId()) {
                    cita.getEstado().setEstado(estado.getEstado());
                }
            }

            model.addRow(new Object[]{cita.getFecha(), cita.getHora_inicio(), cita.getHora_fin(), cita.getEstado().getEstado()});
        }

        tblCitas.setModel(model);

        this.tblCitas.setModel(model);
        this.tblCitas.setRowHeight(50);
        this.tblCitas.setGridColor(Color.BLACK);

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setVerticalAlignment(SwingConstants.CENTER);
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr.setBorder(null);

        this.tblCitas.getColumnModel().getColumn(0).setCellRenderer(tcr);
        this.tblCitas.getColumnModel().getColumn(1).setCellRenderer(tcr);
        this.tblCitas.getColumnModel().getColumn(2).setCellRenderer(tcr);
        this.tblCitas.getColumnModel().getColumn(3).setCellRenderer(tcr);

        //tblCitas.getColumn("Atender").setCellRenderer(new ButtonRenderer());
        //tblCitas.getColumn("Atender").setCellEditor(new ButtonEditor(tblCitas));
    }

    public void table() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] columnas = new String[7];
        columnas[0] = "Lunes";
        columnas[1] = "Martes";
        columnas[2] = "Miércoles";
        columnas[3] = "Jueves";
        columnas[4] = "Viernes";
        columnas[5] = "Sábado";
        columnas[6] = "Domingo";
        model.setColumnIdentifiers(columnas);

        String[] fila1 = new String[7];
        String[] fila2 = new String[7];
        String[] fila3 = new String[7];
        String[] fila4 = new String[7];
        String[] fila5 = new String[7];

        fila1[0] = "";
        fila1[1] = "";
        fila1[2] = "";
        fila1[3] = "";
        fila1[4] = "";
        fila1[5] = "";
        fila1[6] = "";

        fila2[0] = "";
        fila2[1] = "";
        fila2[2] = "";
        fila2[3] = "";
        fila2[4] = "";
        fila2[5] = "";
        fila2[6] = "";

        fila3[0] = "";
        fila3[1] = "";
        fila3[2] = "";
        fila3[3] = "";
        fila3[4] = "";
        fila3[5] = "";
        fila3[6] = "";

        fila4[0] = "";
        fila4[1] = "";
        fila4[2] = "";
        fila4[3] = "";
        fila4[4] = "";
        fila4[5] = "";
        fila4[6] = "";

        fila5[0] = "";
        fila5[1] = "";
        fila5[2] = "";
        fila5[3] = "";
        fila5[4] = "";
        fila5[5] = "";
        fila5[6] = "";

        int i = 1;
        int cant = 0;

        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            cant = 31;
        } else {
            if (mes == 2) {
                cant = 29;
            } else {
                cant = 30;
            }
        }

        for (int k = 1; k < 6; k++) {
            int x = 0;
            switch (k) {
                case 1:
                    x = dia + 1;
                    break;
                default:
                    x = 0;
                    break;
            }
            for (int j = x; j < 7; j++) {
                if (i == cant + 1) {
                    break;
                }
                //this.TxtFechaFin.setText(i + "/" + mes + "/" + año);
                switch (k) {
                    case 1:
                        fila1[j] = Integer.toString(i);
                        i++;
                        break;
                    case 2:
                        fila2[j] = Integer.toString(i);
                        i++;
                        break;
                    case 3:
                        fila3[j] = Integer.toString(i);
                        i++;
                        break;
                    case 4:
                        fila4[j] = Integer.toString(i);
                        i++;
                        break;
                    case 5:
                        fila5[j] = Integer.toString(i);
                        i++;
                        break;
                }
            }
        }

        for (int k = 1; k < 6; k++) {
            int x = 0;
            switch (k) {
                case 1:
                    x = dia + 1;
                    break;
                default:
                    x = 0;
                    break;
            }
            for (int p = x; p < 7; p++) {
                for (int z : dias_citas) {

                    try {
                        if (z == Integer.parseInt(fila1[p])) {
                            String value = fila1[p];
                            fila1[p] = "<html>" + value + "<br> Hora inicio: " + inicios_citas.get(dias_citas.indexOf(z)) + "<br>" + "Hora Fin: " + fines_citas.get(dias_citas.indexOf(z)) + "</html>";
                        }
                    } catch (Exception e) {

                    }
                }
            }

            for (int p = 0; p < 7; p++) {
                for (int z : dias_citas) {
                    try {
                        if (z == Integer.parseInt(fila2[p])) {
                            String value = fila2[p];
                            fila2[p]
                                    = "<html>"
                                    + value
                                    + "<br>"
                                    + "Hora inicio: " + inicios_citas.get(dias_citas.indexOf(z))
                                    + "<br>"
                                    + "Hora Fin: " + fines_citas.get(dias_citas.indexOf(z))
                                    + "</html>";
                        }
                    } catch (Exception e) {

                    }
                }
            }

            for (int p = 0; p < 7; p++) {
                for (int z : dias_citas) {
                    try {
                        if (z == Integer.parseInt(fila3[p])) {
                            String value = fila3[p];
                            fila3[p]
                                    = "<html>"
                                    + value
                                    + "<br>"
                                    + "Hora inicio: " + inicios_citas.get(dias_citas.indexOf(z))
                                    + "<br>"
                                    + "Hora Fin: " + fines_citas.get(dias_citas.indexOf(z))
                                    + "<br>"
                                    + "Estado cita: " + estados_citas.get(dias_citas.indexOf(z))
                                    + "<br>"
                                    + "Tipo cita: " + tipos_citas.get(dias_citas.indexOf(z))
                                    + "</html>";
                        }
                    } catch (Exception e) {

                    }
                }
            }

            for (int p = 0; p < 7; p++) {
                for (int z : dias_citas) {
                    try {
                        if (z == Integer.parseInt(fila4[p])) {
                            String value = fila4[p];
                            fila4[p]
                                    = "<html>"
                                    + value
                                    + "<br>"
                                    + "Hora inicio: " + inicios_citas.get(dias_citas.indexOf(z))
                                    + "<br>"
                                    + "Hora Fin: " + fines_citas.get(dias_citas.indexOf(z))
                                    + "<br>"
                                    + "Estado cita: " + estados_citas.get(dias_citas.indexOf(z))
                                    + "<br>"
                                    + "Tipo cita: " + tipos_citas.get(dias_citas.indexOf(z))
                                    + "</html>";
                        }
                    } catch (Exception e) {

                    }
                }
            }

            for (int p = 0; p < 7; p++) {
                for (int z : dias_citas) {
                    try {
                        if (z == Integer.parseInt(fila5[p])) {
                            String value = fila5[p];
                            fila5[p]
                                    = "<html>"
                                    + value
                                    + "<br>"
                                    + "Hora inicio: " + inicios_citas.get(dias_citas.indexOf(z))
                                    + "<br>"
                                    + "Hora Fin: " + fines_citas.get(dias_citas.indexOf(z))
                                    + "<br>"
                                    + "Estado cita: " + estados_citas.get(dias_citas.indexOf(z))
                                    + "<br>"
                                    + "Tipo cita: " + tipos_citas.get(dias_citas.indexOf(z))
                                    + "</html>";
                        }
                    } catch (Exception e) {

                    }
                }
            }
        }
        /*

        
        
        
        fila1[3] = "<html>"
                +"4<br>"
                + "De: 8:30<br>"
                + "A: 9:20<br>"
                + "Tipo: Prioritaria<br>"
                + "<br>"
                +"De: 11:30<br>"
                + "A: 11:50<br>"
                + "Tipo: Control<br>"
                + "</html>";
        
        fila1[4] = "<html>"
                +"5<br>"
                + "De: 14:30<br>"
                + "A: 14:50<br>"
                + "Tipo: Control<br>"
                + "<br>"
                +"De: 16:30<br>"
                + "A: 16:50<br>"
                + "Tipo: Lectura de exámenes<br>"
                + "</html>";
        
        fila2[3] = "<html>"
                +"11<br>"
                + "De: 10:45<br>"
                + "A: 11:05<br>"
                + "Tipo: Lectura de exámenes<br>"
                + "<br>"
                +"De: 11:45<br>"
                + "A: 12:25<br>"
                + "Tipo: Primera vez<br>"
                + "</html>";
        
        fila2[4] = "<html>"
                +"12<br>"
                + "De: 15:30<br>"
                + "A: 16:10<br>"
                + "Tipo: Primera vez<br>"
                + "<br>"
                +"De: 17:45<br>"
                + "A: 18:05<br>"
                + "Tipo: Control<br>"
                + "</html>";
        
        fila3[3] = "<html>"
                +"18<br>"
                + "De: 8:50<br>"
                + "A: 9:40<br>"
                + "Tipo: Prioritaria<br>"
                + "<br>"
                +"De: 11:30<br>"
                + "A: 11:50<br>"
                + "Tipo: Control<br>"
                + "</html>";
        
        fila3[4] = "<html>"
                +"19<br>"
                + "De: 14:40<br>"
                + "A: 15:00<br>"
                + "Tipo: Lectura de exámenes<br>"
                + "<br>"
                +"De: 16:30<br>"
                + "A: 16:50<br>"
                + "Tipo: Control<br>"
                + "</html>";
        
        fila4[3] = "<html>"
                +"25<br>"
                + "De: 10:30<br>"
                + "A: 11:00<br>"
                + "Tipo: Prioritaria<br>"
                + "<br>"
                +"De: 11:30<br>"
                + "A: 11:50<br>"
                + "Tipo: Lectura de exámenes<br>"
                + "</html>";
        
        fila4[4] = 
                 "<html>"
                +"26<br>"
                +"De: 15:30<br>"
                + "A: 15:50<br>"
                + "Tipo: Control<br>"
                + "<br>"
                +"De: 16:45<br>"
                + "A: 17:05<br>"
                + "Tipo: Control<br>"
                + "</html>";
         */

        model.addRow(fila1);
        model.addRow(fila2);
        model.addRow(fila3);
        model.addRow(fila4);
        model.addRow(fila5);

        this.tblCitas.setModel(model);
        this.tblCitas.setRowHeight(145);
        this.tblCitas.setGridColor(Color.BLACK);

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setVerticalAlignment(SwingConstants.TOP);
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tcr.setBorder(null);

        this.tblCitas.getColumnModel().getColumn(0).setCellRenderer(tcr);
        this.tblCitas.getColumnModel().getColumn(1).setCellRenderer(tcr);
        this.tblCitas.getColumnModel().getColumn(2).setCellRenderer(tcr);
        this.tblCitas.getColumnModel().getColumn(3).setCellRenderer(tcr);
        this.tblCitas.getColumnModel().getColumn(4).setCellRenderer(tcr);
        this.tblCitas.getColumnModel().getColumn(5).setCellRenderer(tcr);
        this.tblCitas.getColumnModel().getColumn(6).setCellRenderer(tcr);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtMedico = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtEspecialidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtFechaInicio = new javax.swing.JTextField();
        TxtFechaFin = new javax.swing.JTextField();
        BtnRegresar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        TxtConsultorio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtSede = new javax.swing.JTextField();
        btnAtender = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCitas.setFont(new java.awt.Font("Sitka Small", 0, 11)); // NOI18N
        tblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Hora Inicio", "Hora Fin", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCitas.setGridColor(new java.awt.Color(0, 0, 0));
        tblCitas.setRowHeight(125);
        tblCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCitas);
        if (tblCitas.getColumnModel().getColumnCount() > 0) {
            tblCitas.getColumnModel().getColumn(0).setResizable(false);
            tblCitas.getColumnModel().getColumn(1).setResizable(false);
            tblCitas.getColumnModel().getColumn(2).setResizable(false);
            tblCitas.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel1.setText("Agenda de citas");

        jLabel2.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N
        jLabel2.setText("Médico:");

        TxtMedico.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N
        TxtMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMedicoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N
        jLabel3.setText("Especialidad:");

        TxtEspecialidad.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel4.setText("Periodo:");

        jLabel5.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N
        jLabel5.setText("Desde:");

        jLabel6.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N
        jLabel6.setText("Hasta:");

        TxtFechaInicio.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N

        TxtFechaFin.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N

        BtnRegresar.setText("Regresar al menú");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N
        jLabel7.setText("Consultorio:");

        TxtConsultorio.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Sitka Small", 0, 10)); // NOI18N
        jLabel8.setText("Sede:");

        TxtSede.setFont(new java.awt.Font("Sitka Small", 0, 11)); // NOI18N

        btnAtender.setText("Atender Cita");
        btnAtender.setEnabled(false);
        btnAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(291, 291, 291)
                                .addComponent(btnAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(TxtConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(TxtMedico)
                                                .addComponent(TxtEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))))
                                    .addGap(52, 52, 52)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtFechaFin)
                                        .addComponent(TxtFechaInicio)
                                        .addComponent(TxtSede)))))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TxtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(TxtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(TxtSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRegresar)
                    .addComponent(btnAtender))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMedicoActionPerformed

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        try {
            VenMenuMedico md = new VenMenuMedico(medico);
            /*ConsultasBD bd = new ConsultasBD();
            bd.actualizarEstadoAgenda("cerrado", this.getId_medico());
            md.setVisible(true);*/
            dispose();
        } catch (Exception ex) {
            System.out.println("Error SQL :v");
            System.out.println(ex);
        }

    }//GEN-LAST:event_BtnRegresarActionPerformed

    private void btnAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtenderActionPerformed

    private void tblCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCitasMouseClicked

        System.out.println(tblCitas.getSelectedRow());
        System.out.println(tblCitas.getValueAt(tblCitas.getSelectedRow(), 3));
        
        if(tblCitas.getValueAt(tblCitas.getSelectedRow(), 3).equals("AGENDADA")){
            btnAtender.setEnabled(true);
        }
    }//GEN-LAST:event_tblCitasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JTextField TxtConsultorio;
    private javax.swing.JTextField TxtEspecialidad;
    private javax.swing.JTextField TxtFechaFin;
    private javax.swing.JTextField TxtFechaInicio;
    private javax.swing.JTextField TxtMedico;
    private javax.swing.JTextField TxtSede;
    private javax.swing.JButton btnAtender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCitas;
    // End of variables declaration//GEN-END:variables
}
