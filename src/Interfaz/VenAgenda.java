/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.Models.Medico;
import java.awt.Color;
import java.sql.ResultSet;
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

/**
 *
 * @author FliaSalinasRodriguez
 */
public class VenAgenda extends javax.swing.JFrame {

    /**
     * Creates new form calendar
     * prioritarias : 40 minutos
     * primera vez : 30 minutos
     * lectura de exámenes : 15 minutos
     * control : 15 minutos
     */
    
    private int dia;
    private int mes;
    private int año;
    private Medico medico;
    private ArrayList<Integer> dias_citas = new ArrayList<Integer>();
    private ArrayList<Time> inicios_citas = new ArrayList<Time>();
    private ArrayList<Time> fines_citas = new ArrayList<Time>();
    private ArrayList<String> tipos_citas = new ArrayList<String>();
    private ArrayList<String> estados_citas = new ArrayList<String>();
    
    public VenAgenda(Medico medico){ 
        Calendar c = Calendar.getInstance();

        this.medico = medico;
        //insertar_citas(id);
        initComponents();
        setTitle("Agenda médico");
        setLocationRelativeTo(null);
        setVisible(true);
        
        /*
        ConsultasBD bd = new ConsultasBD();
        ResultSet med = bd.obtenerMedico(id);
        ResultSet usu = bd.obtenerUsuario(id);
        ResultSet esp = null;
        ResultSet cons = null;
        ResultSet sede = null;
        ResultSet ag = bd.obtenerAgenda(id);
        while(ag.next()){
             c.setTime(ag.getDate("f_fecha_ini"));
             dia = c.get(Calendar.DAY_OF_WEEK);
             mes = c.get(Calendar.MONTH)+1;
             año = c.get(Calendar.YEAR);
             this.TxtFechaInicio.setText(1+"-"+mes+"-"+año);
        }
          
        while(med.next()){
            esp = bd.obtenerEspecialidad(med.getInt("k_id_especialidad"));
           
        while(esp.next()){
             cons = bd.obtenerConsultorio(esp.getInt("k_id_especialidad"));
             this.TxtEspecialidad.setText(esp.getString("n_nombre_esp"));
             }
        while(cons.next()){
             sede = bd.obtenerSede(cons.getString("k_id_sede"));
             this.TxtConsultorio.setText(""+cons.getInt("k_numero_consultorio"));   
            }
        while(sede.next()){
            this.TxtSede.setText(sede.getString("k_id_sede"));
            }
        }
        
        while(usu.next()){
        this.TxtMedico.setText(usu.getString("n_nombre")+" "+usu.getString("n_apellido"));
        }
        while(esp.next()){
        this.TxtEspecialidad.setText(esp.getString("n_nombre_esp"));
        }*/
        
        
        
        this.TxtConsultorio.setEditable(false);
        this.TxtMedico.setEditable(false);
        this.TxtEspecialidad.setEditable(false);
        this.TxtFechaInicio.setEditable(false);
        this.TxtFechaFin.setEditable(false);
        this.TxtSede.setEditable(false);
        table();
              
    }

    public void insertar_citas(int id) throws SQLException{
        /*ResultSet ob_ag = bd.obtenerAgenda(id);
        ResultSet ob_all_ag = bd.obtenerAgendas();
        
        while(ob_all_ag.next()){
            ResultSet med = bd.obtenerUsuario(id);
            while(med.next()){
                if(ob_all_ag.getInt("k_id_medico") == -1){
                     bd.crearAgenda(id, med.getString("k_tipo_id"));
                     ob_ag = bd.obtenerAgenda(id);
                     break; 
                }
                break;
            }
            
        }
       
        
        int id_agenda = 0;
        while(ob_ag.next()){
          id_agenda = ob_ag.getInt("k_id_agenda");
        }
        ResultSet ob_ci = bd.obtenerCitas(id_agenda); 

        
        while(ob_ci.next()){
            dias_citas.add(ob_ci.getInt("q_dia"));
            inicios_citas.add(ob_ci.getTime("f_hora_inicial"));
            fines_citas.add(ob_ci.getTime("f_hora_final"));
            tipos_citas.add(ob_ci.getString("i_tipo_cita"));
            estados_citas.add(ob_ci.getString("i_estado_cita"));
   
        } */

    }
    
    
    public void table(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String[] columnas = new String[7];
        columnas[0]="Lunes";
        columnas[1]="Martes";
        columnas[2]="Miércoles";
        columnas[3]="Jueves";
        columnas[4]="Viernes";
        columnas[5]="Sábado";
        columnas[6]="Domingo";
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
        
        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            cant = 31;
        }
        else{
            if(mes == 2){
                cant = 29;
            }
            else{
                cant = 30;
            }
        }
        
        for(int k = 1; k < 6;k++){
                int x = 0;
                switch(k){
                    case 1:
                        x = dia-2;
                        break;
                    default:
                        x = 0;
                        break;
                }
                for(int j = x; j < 7; j++){
                    if(i==cant+1) break;
                    this.TxtFechaFin.setText(i+"/"+mes+"/"+año);
                    switch(k){
                        case 1:
                            fila1[j]=Integer.toString(i);
                            i++;
                            break;
                        case 2:
                            fila2[j]=Integer.toString(i);
                            i++;
                            break;
                        case 3:
                            fila3[j]=Integer.toString(i);
                            i++;
                            break;
                        case 4:
                            fila4[j]=Integer.toString(i);
                            i++;
                            break;
                        case 5:
                            fila5[j]=Integer.toString(i);
                            i++;
                            break;
                    }
                    
                }
            }
        
        
    for(int k = 1; k < 6;k++){
                int x = 0;
                switch(k){
                    case 1:
                        x = dia-2;
                        break;
                    default:
                        x = 0;
                        break;
                }
        for(int p = x; p < 7; p++){
            for(int z: dias_citas){
                try{
                if(z == Integer.parseInt(fila1[p])){
                    String value = fila1[p];
                    fila1[p]=
                        "<html>"
                        +value
                        +"<br>"
                        + "Hora inicio: "+inicios_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Hora Fin: "+fines_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Estado cita: "+estados_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Tipo cita: "+tipos_citas.get(dias_citas.indexOf(z))
                        + "</html>";
                }
                }catch(Exception e){
                    
                }
            }
        }
        
        for(int p = 0; p < 7; p++){
            for(int z: dias_citas){
                try{
                if(z == Integer.parseInt(fila2[p])){
                    String value = fila2[p];
                    fila2[p]=
                        "<html>"
                        +value
                        +"<br>"
                        + "Hora inicio: "+inicios_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Hora Fin: "+fines_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Estado cita: "+estados_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Tipo cita: "+tipos_citas.get(dias_citas.indexOf(z))
                        + "</html>";
                }
                }catch(Exception e){
                    
                }
            }
        }
                
        for(int p = 0; p < 7; p++){
            for(int z: dias_citas){
                try{
                if(z == Integer.parseInt(fila3[p])){
                    String value = fila3[p];
                    fila3[p]=
                        "<html>"
                        +value
                        +"<br>"
                        + "Hora inicio: "+inicios_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Hora Fin: "+fines_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Estado cita: "+estados_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Tipo cita: "+tipos_citas.get(dias_citas.indexOf(z))
                        + "</html>";
                }
                }catch(Exception e){
                    
                }
            }
        }
                        
        for(int p = 0; p < 7; p++){
            for(int z: dias_citas){
                try{
                if(z == Integer.parseInt(fila4[p])){
                    String value = fila4[p];
                    fila4[p]=
                        "<html>"
                        +value
                        +"<br>"
                        + "Hora inicio: "+inicios_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Hora Fin: "+fines_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Estado cita: "+estados_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Tipo cita: "+tipos_citas.get(dias_citas.indexOf(z))
                        + "</html>";
                }
                }catch(Exception e){
                    
                }
            }
        }
                                
        for(int p = 0; p < 7; p++){
            for(int z: dias_citas){
                try{
                if(z == Integer.parseInt(fila5[p])){
                    String value = fila5[p];
                    fila5[p]=
                        "<html>"
                        +value
                        +"<br>"
                        + "Hora inicio: "+inicios_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Hora Fin: "+fines_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Estado cita: "+estados_citas.get(dias_citas.indexOf(z))
                        +"<br>"
                        + "Tipo cita: "+tipos_citas.get(dias_citas.indexOf(z))
                        + "</html>";
                }
                }catch(Exception e){
                    
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
        
        
        
        
        this.TblCalendar.setModel(model);
        this.TblCalendar.setRowHeight(145);
        this.TblCalendar.setGridColor(Color.BLACK);
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setVerticalAlignment(SwingConstants.TOP);
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tcr.setBorder(null);
        
        
        this.TblCalendar.getColumnModel().getColumn(0).setCellRenderer(tcr);
        this.TblCalendar.getColumnModel().getColumn(1).setCellRenderer(tcr);
        this.TblCalendar.getColumnModel().getColumn(2).setCellRenderer(tcr);
        this.TblCalendar.getColumnModel().getColumn(3).setCellRenderer(tcr);
        this.TblCalendar.getColumnModel().getColumn(4).setCellRenderer(tcr);
        this.TblCalendar.getColumnModel().getColumn(5).setCellRenderer(tcr);
        this.TblCalendar.getColumnModel().getColumn(6).setCellRenderer(tcr);
        
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
        TblCalendar = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TblCalendar.setFont(new java.awt.Font("Sitka Small", 0, 11)); // NOI18N
        TblCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblCalendar.setGridColor(new java.awt.Color(0, 0, 0));
        TblCalendar.setRowHeight(125);
        jScrollPane1.setViewportView(TblCalendar);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                            .addComponent(BtnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(TxtSede))))
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
                .addComponent(BtnRegresar)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JTable TblCalendar;
    private javax.swing.JTextField TxtConsultorio;
    private javax.swing.JTextField TxtEspecialidad;
    private javax.swing.JTextField TxtFechaFin;
    private javax.swing.JTextField TxtFechaInicio;
    private javax.swing.JTextField TxtMedico;
    private javax.swing.JTextField TxtSede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
