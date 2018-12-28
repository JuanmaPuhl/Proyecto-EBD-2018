/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import quick.dbtable.DBTable;


public class Atm extends javax.swing.JPanel {
     private DBTable tabla;
     private int nro_cuenta=0;
     private int nro_tarjeta=0;
     private Home h;
     private Color color1=new Color(59,89,152);
     private Color color3=new Color(175,189,212);
     private int aux=0;
     
    public Atm(Home h) {
        initComponents();
        this.h=h;
        tabla=new DBTable();
        tabla.setEditable(false);
        this.jPanel1.add(tabla);
        confirmacion.setLocationRelativeTo(null);
    }

    /**Metodo auxiliar para conectarme a la base de datos*/
     private void conectarBD()
    {
        try
        {
            /**Seteo todos los valores para conectarme*/
        String driver ="com.mysql.cj.jdbc.Driver";
        String servidor = "";
	String baseDatos = "banco";
	String usuario = "atm";
	String clave = "atm";
	String uriConexion = "jdbc:mysql://" + servidor + "/" + baseDatos+"?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone="+java.util.TimeZone.getDefault().getID();
        tabla.connectDatabase(driver, uriConexion, usuario, clave);
        }
        catch (SQLException ex)
         {
             JOptionPane.showMessageDialog(this,
                                           "Se produjo un error al intentar conectarse a la base de datos.\n" + ex.getMessage(),
                                           "Error",
                                           JOptionPane.ERROR_MESSAGE);
         }
         catch (ClassNotFoundException e)
         {
           JOptionPane.showMessageDialog(this,
                                           "Se produjo un error al intentar conectarse a la base de datos.\n" + e.getMessage(),
                                           "Error",
                                           JOptionPane.ERROR_MESSAGE);
         }
    }
    
     private void convertir(){
         int [] arreglo=new int[tabla.getRowCount()];
         int m=0;
         for(int i=0; i<tabla.getRowCount(); i++){
             if(tabla.getValueAt(i,2)!=null){
             String aux=tabla.getValueAt(i,2).toString();
             
             if(!aux.equals("Deposito")){
                 String aux2=tabla.getValueAt(i,3).toString();
                 double monto=Double.parseDouble(aux2);
                 
                 tabla.setValueAt((-1)*monto,i, 3);
             }
            }    
        }

     }
     
     /**Metodo auxiliar para actualizar tablas*/
     private void refrescarTabla(String query){
      try
      {    
    	  
    	  if(query!=null){
          tabla.setSelectSql(query);
          
    	  tabla.createColumnModelFromQuery();    	    
    	  for (int i = 0; i < tabla.getColumnCount(); i++)
    	  {  		   		  
    		 if(tabla.getColumn(i).getType()==Types.TIME){    		 
                     tabla.getColumn(i).setType(Types.CHAR);  
  	       	 }
    		  
    		 if(tabla.getColumn(i).getType()==Types.DATE){
    		    tabla.getColumn(i).setDateFormat("dd/MM/YYYY");
    		 }
          }  
    	     	     	  
    	  tabla.refresh();
    	 
          } 
      }
      catch (SQLException ex)
      {
         // en caso de error, se muestra la causa 
         JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                                       ex.getMessage() + "\n", 
                                       "Error al ejecutar la consulta.",
                                       JOptionPane.ERROR_MESSAGE);
      }
   }
     
     /**Metodo auxiliar para desconectar la base*/
   private void desconectarBD(){
         try{
            tabla.close();            
         }
         catch (SQLException ex){
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                                       ex.getMessage() + "\n", 
                                       "Error al ejecutar la consulta.",
                                       JOptionPane.ERROR_MESSAGE);
         }      
    }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transferencia = new javax.swing.JFrame();
        panelGeneral = new javax.swing.JPanel();
        panelUsuario = new javax.swing.JPanel();
        tfield_usuario = new javax.swing.JTextField();
        lbl_usuario = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JPanel();
        lbl_ingresar = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JPanel();
        lbl_cancelar = new javax.swing.JLabel();
        panelUsuario2 = new javax.swing.JPanel();
        tfield_usuario2 = new javax.swing.JTextField();
        lbl_usuario2 = new javax.swing.JLabel();
        jLabelErrorTransferencia = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        extraccion = new javax.swing.JFrame();
        panelGeneral2 = new javax.swing.JPanel();
        panelUsuario3 = new javax.swing.JPanel();
        tfield_usuario3 = new javax.swing.JTextField();
        lbl_usuario3 = new javax.swing.JLabel();
        btn_ingresar2 = new javax.swing.JPanel();
        lbl_ingresar2 = new javax.swing.JLabel();
        btn_cancelar2 = new javax.swing.JPanel();
        lbl_cancelar2 = new javax.swing.JLabel();
        jLabelErrorExtraccion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        confirmacion = new javax.swing.JFrame();
        panelGeneral3 = new javax.swing.JPanel();
        panelUsuario4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_ingresar3 = new javax.swing.JPanel();
        lbl_ingresar3 = new javax.swing.JLabel();
        btn_cancelar3 = new javax.swing.JPanel();
        lbl_cancelar3 = new javax.swing.JLabel();
        confirmacionExtraccion = new javax.swing.JFrame();
        panelGeneral4 = new javax.swing.JPanel();
        panelUsuario5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_ingresar4 = new javax.swing.JPanel();
        lbl_ingresar4 = new javax.swing.JLabel();
        btn_cancelar4 = new javax.swing.JPanel();
        lbl_cancelar4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        transferencia.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        transferencia.setAlwaysOnTop(true);
        transferencia.setBackground(new java.awt.Color(255, 255, 255));
        transferencia.setLocationByPlatform(true);
        transferencia.setUndecorated(true);
        transferencia.setPreferredSize(new java.awt.Dimension(543, 327));
        transferencia.setSize(new java.awt.Dimension(543, 322));
        transferencia.setLocationRelativeTo(null);

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));
        panelGeneral.setForeground(new java.awt.Color(255, 255, 255));

        panelUsuario.setBackground(new java.awt.Color(59, 89, 152));

        tfield_usuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tfield_usuario.setForeground(new java.awt.Color(255, 255, 255));
        tfield_usuario.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(255,255,255)));
        tfield_usuario.setCaretColor(new java.awt.Color(255, 255, 255));
        tfield_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfield_usuario.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        tfield_usuario.setOpaque(false);

        lbl_usuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Caja del destinatario:");

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuarioLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lbl_usuario)
                .addGap(52, 52, 52)
                .addComponent(tfield_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuarioLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfield_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_usuario))
                .addContainerGap())
        );

        btn_ingresar.setBackground(new java.awt.Color(59, 89, 152));
        btn_ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ingresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ingresarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ingresarMousePressed(evt);
            }
        });

        lbl_ingresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ingresar.setText("Aceptar");

        javax.swing.GroupLayout btn_ingresarLayout = new javax.swing.GroupLayout(btn_ingresar);
        btn_ingresar.setLayout(btn_ingresarLayout);
        btn_ingresarLayout.setHorizontalGroup(
            btn_ingresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ingresarLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lbl_ingresar)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        btn_ingresarLayout.setVerticalGroup(
            btn_ingresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_ingresarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_ingresar)
                .addContainerGap())
        );

        btn_cancelar.setBackground(new java.awt.Color(59, 89, 152));
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cancelarMousePressed(evt);
            }
        });

        lbl_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cancelar.setText("Cancelar");

        javax.swing.GroupLayout btn_cancelarLayout = new javax.swing.GroupLayout(btn_cancelar);
        btn_cancelar.setLayout(btn_cancelarLayout);
        btn_cancelarLayout.setHorizontalGroup(
            btn_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_cancelarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_cancelar)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        btn_cancelarLayout.setVerticalGroup(
            btn_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_cancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelUsuario2.setBackground(new java.awt.Color(59, 89, 152));

        tfield_usuario2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tfield_usuario2.setForeground(new java.awt.Color(255, 255, 255));
        tfield_usuario2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(255,255,255)));
        tfield_usuario2.setCaretColor(new java.awt.Color(255, 255, 255));
        tfield_usuario2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfield_usuario2.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        tfield_usuario2.setOpaque(false);

        lbl_usuario2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_usuario2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario2.setText("Monto a transferir:");

        javax.swing.GroupLayout panelUsuario2Layout = new javax.swing.GroupLayout(panelUsuario2);
        panelUsuario2.setLayout(panelUsuario2Layout);
        panelUsuario2Layout.setHorizontalGroup(
            panelUsuario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuario2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lbl_usuario2)
                .addGap(60, 60, 60)
                .addComponent(tfield_usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelUsuario2Layout.setVerticalGroup(
            panelUsuario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuario2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(panelUsuario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfield_usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_usuario2))
                .addContainerGap())
        );

        jLabelErrorTransferencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelErrorTransferencia.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorTransferencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErrorTransferencia.setText(" ");

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelUsuario2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabelErrorTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(panelUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelErrorTransferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout transferenciaLayout = new javax.swing.GroupLayout(transferencia.getContentPane());
        transferencia.getContentPane().setLayout(transferenciaLayout);
        transferenciaLayout.setHorizontalGroup(
            transferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        transferenciaLayout.setVerticalGroup(
            transferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        extraccion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        extraccion.setBackground(new java.awt.Color(255, 255, 255));
        extraccion.setLocationByPlatform(true);
        extraccion.setUndecorated(true);
        extraccion.setResizable(false);
        extraccion.setSize(new java.awt.Dimension(543, 208));
        extraccion.setLocationRelativeTo(null);

        panelGeneral2.setBackground(new java.awt.Color(255, 255, 255));
        panelGeneral2.setForeground(new java.awt.Color(255, 255, 255));

        panelUsuario3.setBackground(new java.awt.Color(59, 89, 152));

        tfield_usuario3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tfield_usuario3.setForeground(new java.awt.Color(255, 255, 255));
        tfield_usuario3.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(255,255,255)));
        tfield_usuario3.setCaretColor(new java.awt.Color(255, 255, 255));
        tfield_usuario3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfield_usuario3.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        tfield_usuario3.setOpaque(false);

        lbl_usuario3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_usuario3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario3.setText("Monto extraccion:");

        javax.swing.GroupLayout panelUsuario3Layout = new javax.swing.GroupLayout(panelUsuario3);
        panelUsuario3.setLayout(panelUsuario3Layout);
        panelUsuario3Layout.setHorizontalGroup(
            panelUsuario3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuario3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lbl_usuario3)
                .addGap(66, 66, 66)
                .addComponent(tfield_usuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        panelUsuario3Layout.setVerticalGroup(
            panelUsuario3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuario3Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(panelUsuario3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfield_usuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_usuario3))
                .addContainerGap())
        );

        btn_ingresar2.setBackground(new java.awt.Color(59, 89, 152));
        btn_ingresar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ingresar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ingresar2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ingresar2MousePressed(evt);
            }
        });

        lbl_ingresar2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ingresar2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ingresar2.setText("Aceptar");

        javax.swing.GroupLayout btn_ingresar2Layout = new javax.swing.GroupLayout(btn_ingresar2);
        btn_ingresar2.setLayout(btn_ingresar2Layout);
        btn_ingresar2Layout.setHorizontalGroup(
            btn_ingresar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ingresar2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lbl_ingresar2)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        btn_ingresar2Layout.setVerticalGroup(
            btn_ingresar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_ingresar2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_ingresar2)
                .addContainerGap())
        );

        btn_cancelar2.setBackground(new java.awt.Color(59, 89, 152));
        btn_cancelar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelar2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cancelar2MousePressed(evt);
            }
        });

        lbl_cancelar2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cancelar2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cancelar2.setText("Cancelar");

        javax.swing.GroupLayout btn_cancelar2Layout = new javax.swing.GroupLayout(btn_cancelar2);
        btn_cancelar2.setLayout(btn_cancelar2Layout);
        btn_cancelar2Layout.setHorizontalGroup(
            btn_cancelar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_cancelar2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(lbl_cancelar2)
                .addGap(31, 31, 31))
        );
        btn_cancelar2Layout.setVerticalGroup(
            btn_cancelar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_cancelar2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_cancelar2)
                .addContainerGap())
        );

        jLabelErrorExtraccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelErrorExtraccion.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorExtraccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErrorExtraccion.setText("  ");

        javax.swing.GroupLayout panelGeneral2Layout = new javax.swing.GroupLayout(panelGeneral2);
        panelGeneral2.setLayout(panelGeneral2Layout);
        panelGeneral2Layout.setHorizontalGroup(
            panelGeneral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuario3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelGeneral2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btn_ingresar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneral2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneral2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelErrorExtraccion, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        panelGeneral2Layout.setVerticalGroup(
            panelGeneral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneral2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelErrorExtraccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGeneral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_cancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ingresar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout extraccionLayout = new javax.swing.GroupLayout(extraccion.getContentPane());
        extraccion.getContentPane().setLayout(extraccionLayout);
        extraccionLayout.setHorizontalGroup(
            extraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        extraccionLayout.setVerticalGroup(
            extraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        extraccion.getAccessibleContext().setAccessibleDescription("");

        confirmacion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        confirmacion.setBackground(new java.awt.Color(255, 255, 255));
        confirmacion.setLocationByPlatform(true);
        confirmacion.setUndecorated(true);
        confirmacion.setSize(new java.awt.Dimension(543, 216));
        extraccion.setLocationRelativeTo(null);

        panelGeneral3.setBackground(new java.awt.Color(255, 255, 255));
        panelGeneral3.setForeground(new java.awt.Color(255, 255, 255));

        panelUsuario4.setBackground(new java.awt.Color(59, 89, 152));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("¿Está seguro/a que desea continuar?");

        javax.swing.GroupLayout panelUsuario4Layout = new javax.swing.GroupLayout(panelUsuario4);
        panelUsuario4.setLayout(panelUsuario4Layout);
        panelUsuario4Layout.setHorizontalGroup(
            panelUsuario4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuario4Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(118, 118, 118))
        );
        panelUsuario4Layout.setVerticalGroup(
            panelUsuario4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuario4Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42))
        );

        btn_ingresar3.setBackground(new java.awt.Color(59, 89, 152));
        btn_ingresar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ingresar3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ingresar3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ingresar3MousePressed(evt);
            }
        });

        lbl_ingresar3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ingresar3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ingresar3.setText("Confirmar");

        javax.swing.GroupLayout btn_ingresar3Layout = new javax.swing.GroupLayout(btn_ingresar3);
        btn_ingresar3.setLayout(btn_ingresar3Layout);
        btn_ingresar3Layout.setHorizontalGroup(
            btn_ingresar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ingresar3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lbl_ingresar3)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        btn_ingresar3Layout.setVerticalGroup(
            btn_ingresar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_ingresar3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_ingresar3)
                .addContainerGap())
        );

        btn_cancelar3.setBackground(new java.awt.Color(59, 89, 152));
        btn_cancelar3.setPreferredSize(new java.awt.Dimension(168, 42));
        btn_cancelar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelar3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelar3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cancelar3MousePressed(evt);
            }
        });

        lbl_cancelar3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cancelar3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cancelar3.setText("Cancelar");

        javax.swing.GroupLayout btn_cancelar3Layout = new javax.swing.GroupLayout(btn_cancelar3);
        btn_cancelar3.setLayout(btn_cancelar3Layout);
        btn_cancelar3Layout.setHorizontalGroup(
            btn_cancelar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_cancelar3Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(lbl_cancelar3)
                .addGap(52, 52, 52))
        );
        btn_cancelar3Layout.setVerticalGroup(
            btn_cancelar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_cancelar3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_cancelar3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGeneral3Layout = new javax.swing.GroupLayout(panelGeneral3);
        panelGeneral3.setLayout(panelGeneral3Layout);
        panelGeneral3Layout.setHorizontalGroup(
            panelGeneral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuario4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelGeneral3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_ingresar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelGeneral3Layout.setVerticalGroup(
            panelGeneral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneral3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panelGeneral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cancelar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ingresar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout confirmacionLayout = new javax.swing.GroupLayout(confirmacion.getContentPane());
        confirmacion.getContentPane().setLayout(confirmacionLayout);
        confirmacionLayout.setHorizontalGroup(
            confirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        confirmacionLayout.setVerticalGroup(
            confirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        confirmacionExtraccion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        confirmacionExtraccion.setBackground(new java.awt.Color(255, 255, 255));
        confirmacionExtraccion.setLocationByPlatform(true);
        confirmacionExtraccion.setUndecorated(true);
        confirmacionExtraccion.setSize(new java.awt.Dimension(543, 216));
        extraccion.setLocationRelativeTo(null);

        panelGeneral4.setBackground(new java.awt.Color(255, 255, 255));
        panelGeneral4.setForeground(new java.awt.Color(255, 255, 255));

        panelUsuario5.setBackground(new java.awt.Color(59, 89, 152));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("¿Está seguro/a que desea continuar?");

        javax.swing.GroupLayout panelUsuario5Layout = new javax.swing.GroupLayout(panelUsuario5);
        panelUsuario5.setLayout(panelUsuario5Layout);
        panelUsuario5Layout.setHorizontalGroup(
            panelUsuario5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuario5Layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(117, 117, 117))
        );
        panelUsuario5Layout.setVerticalGroup(
            panelUsuario5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuario5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        btn_ingresar4.setBackground(new java.awt.Color(59, 89, 152));
        btn_ingresar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ingresar4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ingresar4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ingresar4MousePressed(evt);
            }
        });

        lbl_ingresar4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ingresar4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ingresar4.setText("Confirmar");

        javax.swing.GroupLayout btn_ingresar4Layout = new javax.swing.GroupLayout(btn_ingresar4);
        btn_ingresar4.setLayout(btn_ingresar4Layout);
        btn_ingresar4Layout.setHorizontalGroup(
            btn_ingresar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ingresar4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lbl_ingresar4)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        btn_ingresar4Layout.setVerticalGroup(
            btn_ingresar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_ingresar4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_ingresar4)
                .addContainerGap())
        );

        btn_cancelar4.setBackground(new java.awt.Color(59, 89, 152));
        btn_cancelar4.setPreferredSize(new java.awt.Dimension(168, 42));
        btn_cancelar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelar4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelar4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cancelar4MousePressed(evt);
            }
        });

        lbl_cancelar4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cancelar4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cancelar4.setText("Cancelar");

        javax.swing.GroupLayout btn_cancelar4Layout = new javax.swing.GroupLayout(btn_cancelar4);
        btn_cancelar4.setLayout(btn_cancelar4Layout);
        btn_cancelar4Layout.setHorizontalGroup(
            btn_cancelar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_cancelar4Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(lbl_cancelar4)
                .addGap(52, 52, 52))
        );
        btn_cancelar4Layout.setVerticalGroup(
            btn_cancelar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_cancelar4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_cancelar4)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelGeneral4Layout = new javax.swing.GroupLayout(panelGeneral4);
        panelGeneral4.setLayout(panelGeneral4Layout);
        panelGeneral4Layout.setHorizontalGroup(
            panelGeneral4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuario5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelGeneral4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_ingresar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelGeneral4Layout.setVerticalGroup(
            panelGeneral4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneral4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelUsuario5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelGeneral4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cancelar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ingresar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout confirmacionExtraccionLayout = new javax.swing.GroupLayout(confirmacionExtraccion.getContentPane());
        confirmacionExtraccion.getContentPane().setLayout(confirmacionExtraccionLayout);
        confirmacionExtraccionLayout.setHorizontalGroup(
            confirmacionExtraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        confirmacionExtraccionLayout.setVerticalGroup(
            confirmacionExtraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(59, 89, 152));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("<html>\nMovimientos por </br>\nPeriodo\n</html>");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Saldo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("<html>Ultimos </br>\nMovimientos</html>");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/images/icons8_Exit_32px.png"))); // NOI18N
        jLabel2.setText("Salir");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(83, 83, 83))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(59, 89, 152));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel7MousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Realizar Transferencia");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel8MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Realizar Extraccion");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // consultar saldo
        this.consultarSaldo();
    }//GEN-LAST:event_jPanel5MousePressed

    /**Metodo auxiliar para mostrar las transacciones en cierto periodo*/
    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // movimiento por periodo
        try{
            /**Pido al usuario las fechas*/
            String fecha1 = JOptionPane.showInputDialog("Ingrese la fecha minima"); 
            String fecha2 = JOptionPane.showInputDialog("Ingrese la fecha maxima");
            if(!Fechas.validar(fecha1) && !Fechas.validar(fecha2) )
                JOptionPane.showMessageDialog(null, "Fecha/s Invalida/s.");
            else{
                /**Ahora una vez que se validaron, busco en la base las transacciones que cumplan los requisitos*/
                java.util.Date fecha_1=Fechas.convertirStringADate(fecha1);
                java.util.Date fecha_2=Fechas.convertirStringADate(fecha2);
                if(fecha_2.after(fecha_1)){
                    tabla.setMaximumRowCount(Integer.MAX_VALUE);
                    fecha1=Fechas.convertirDateAStringDB(fecha_1);
                    fecha2=Fechas.convertirDateAStringDB(fecha_2);
                    java.sql.Statement stmt = tabla.getConnection().createStatement();
                    String text="select fecha,hora,tipo,monto,cod_caja,destino from trans_cajas_ahorro WHERE '" +fecha1+"'<=fecha and fecha<='"+fecha2+ "' and nro_ca = " + nro_cuenta
                               +" ORDER BY fecha desc ,hora desc;";
                    this.refrescarTabla(text);//Refresco la tabla
                    convertir();
                }
                else
                    JOptionPane.showMessageDialog(null, "Las fechas ingresadas no son validas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                                       ex.getMessage() + "\n", 
                                       "Error al ejecutar la consulta.",
                                       JOptionPane.ERROR_MESSAGE); //Mostrar error
         }
    }//GEN-LAST:event_jPanel4MousePressed

    /**Metodo auxiliar para mostrar los ultimos movimientos*/
    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
            /**Se uso la opcion limit para setear el maximo de transacciones a 15*/
            tabla.setMaximumRowCount(15);
            String text="select fecha,hora,tipo,monto,cod_caja,destino from trans_cajas_ahorro where nro_ca="+nro_cuenta+" order by fecha desc,hora desc LIMIT 15;";
            refrescarTabla(text);
            convertir();
    }//GEN-LAST:event_jPanel6MousePressed

    /**Esto ocurre cuando se oculta*/
    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
       this.desconectarBD();
    }//GEN-LAST:event_formComponentHidden

    /**Esto ocurre cuando se hace visible*/
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
         conectarBD();
         this.refrescarTabla("select fecha,hora,tipo,monto,cod_caja,destino from trans_cajas_ahorro where nro_ca=-1;");
         tabla.removeAllRows();
    }//GEN-LAST:event_formComponentShown

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        h.cerrarSesion();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        h.oscurecer();
        this.transferencia.setVisible(true);
    }//GEN-LAST:event_jPanel7MousePressed

    private void jPanel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MousePressed
        h.oscurecer();
        this.extraccion.setVisible(true);
    }//GEN-LAST:event_jPanel8MousePressed

    private void btn_ingresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMouseEntered
        setColor(btn_ingresar);
    }//GEN-LAST:event_btn_ingresarMouseEntered

    private void btn_ingresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMouseExited
        btn_ingresar.setBackground(color1);
    }//GEN-LAST:event_btn_ingresarMouseExited

    /**Metodo auxiliar para mostrar error de Stored procedures*/
    private void mostrarError(int n){
        if(n==0)
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente.");
        if(n==1)
            JOptionPane.showMessageDialog(null, "No se encontro la cuenta destino", "Error", JOptionPane.ERROR_MESSAGE);
        if(n==2)
            JOptionPane.showMessageDialog(null, "La cuenta no tiene saldo suficiente para realizar la operacion.", "Error", JOptionPane.ERROR_MESSAGE);
        if(n==3)
            JOptionPane.showMessageDialog(null, "Error interno", "Error", JOptionPane.ERROR_MESSAGE);
        if(n==4)
            JOptionPane.showMessageDialog(null, "No se encontro el numero de tarjeta", "Error", JOptionPane.ERROR_MESSAGE);
        if(n==5)
            JOptionPane.showMessageDialog(null, "No se encontro la caja", "Error", JOptionPane.ERROR_MESSAGE);
    }
   
    private void btn_ingresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMousePressed
        if(tfield_usuario.getText().trim().equals("")){
            jLabelErrorTransferencia.setText("Ingrese la caja destino");
            jLabelErrorTransferencia.setVisible(true);
        }else
            if(tfield_usuario2.getText().trim().equals("")){
                jLabelErrorTransferencia.setText("Ingrese el monto");
                jLabelErrorTransferencia.setVisible(true);
            }
            else{
                confirmacion.setAlwaysOnTop(true);
                confirmacion.setVisible(true);
                transferencia.setVisible(false);
                jLabelErrorTransferencia.setText(" ");
            }
    }//GEN-LAST:event_btn_ingresarMousePressed

    private void btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseEntered
        setColor(btn_cancelar);
    }//GEN-LAST:event_btn_cancelarMouseEntered

    private void btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseExited
        btn_cancelar.setBackground(color1);
    }//GEN-LAST:event_btn_cancelarMouseExited

    private void btn_cancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMousePressed
        h.aclarar();
        transferencia.setVisible(false);
        this.tfield_usuario.setText("");
        this.tfield_usuario2.setText("");
    }//GEN-LAST:event_btn_cancelarMousePressed

    private void btn_ingresar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresar2MouseEntered
        setColor(btn_ingresar2);
    }//GEN-LAST:event_btn_ingresar2MouseEntered

    private void btn_ingresar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresar2MouseExited
        btn_ingresar2.setBackground(color1);
    }//GEN-LAST:event_btn_ingresar2MouseExited

    private void btn_ingresar2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresar2MousePressed
        if(tfield_usuario3.getText().trim().equals("")){
            jLabelErrorExtraccion.setText("Ingrese el monto");
        }
        else{
            confirmacionExtraccion.setLocationRelativeTo(null);
            confirmacionExtraccion.setAlwaysOnTop(true);
            confirmacionExtraccion.setVisible(true);
            extraccion.setVisible(false);
            jLabelErrorExtraccion.setText(" ");
        }
    }//GEN-LAST:event_btn_ingresar2MousePressed

    private void btn_cancelar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar2MouseEntered
       setColor(btn_cancelar2);
    }//GEN-LAST:event_btn_cancelar2MouseEntered

    private void btn_cancelar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar2MouseExited
        btn_cancelar2.setBackground(color1);
    }//GEN-LAST:event_btn_cancelar2MouseExited

    private void btn_cancelar2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar2MousePressed
        h.aclarar(); 
        extraccion.setVisible(false);
        this.tfield_usuario3.setText("");
    }//GEN-LAST:event_btn_cancelar2MousePressed

    private void btn_ingresar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresar3MouseEntered
        setColor(btn_ingresar3);
    }//GEN-LAST:event_btn_ingresar3MouseEntered

    private void btn_ingresar3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresar3MouseExited
        btn_ingresar3.setBackground(color1);
    }//GEN-LAST:event_btn_ingresar3MouseExited

    /**Accion del boton confirmar de transferencia*/
    private void btn_ingresar3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresar3MousePressed
         try {
             
             h.aclarar();
             confirmacion.setVisible(false);
             String destino= tfield_usuario.getText();
             this.tfield_usuario.setText("");
             int d=Integer.parseInt(destino);
             String monto=tfield_usuario2.getText();
             this.tfield_usuario2.setText("");
             float m=Float.parseFloat(monto);
             //Aca va el store procedure
             java.sql.Statement stmt = tabla.getConnection().createStatement();
             stmt.execute("call transferencia("+nro_tarjeta+","+d+","+m+","+100+",@A)");
             java.sql.ResultSet rs = stmt.executeQuery("select @A;");
             int error=-1;
             while(rs.next()){
                 error=rs.getInt(1);
             }
             stmt.close();
             mostrarError(error); 
             rs.close();
             if(tabla.getRowCount()>0)
                 tabla.refresh();
             convertir();
             this.consultarSaldo();
        }
        catch (SQLException ex) {
             Logger.getLogger(Atm.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NumberFormatException err){
              JOptionPane.showMessageDialog(null, "Error en el monto o la caja.");
        }
    }//GEN-LAST:event_btn_ingresar3MousePressed

    private void btn_cancelar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar3MouseEntered
        setColor(btn_cancelar3);   
    }//GEN-LAST:event_btn_cancelar3MouseEntered

    private void btn_cancelar3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar3MouseExited
        btn_cancelar3.setBackground(color1);
    }//GEN-LAST:event_btn_cancelar3MouseExited

    private void btn_cancelar3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar3MousePressed
        transferencia.setEnabled(true);
        transferencia.setVisible(true);
        confirmacion.setVisible(false);
        btn_cancelar3.setBackground(color1);
    }//GEN-LAST:event_btn_cancelar3MousePressed

    private void btn_ingresar4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresar4MouseEntered
        setColor(btn_ingresar4);
    }//GEN-LAST:event_btn_ingresar4MouseEntered

    private void btn_ingresar4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresar4MouseExited
        btn_ingresar4.setBackground(color1);
    }//GEN-LAST:event_btn_ingresar4MouseExited

    private void btn_ingresar4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresar4MousePressed
        try{
            extraccion.setEnabled(true);
            h.aclarar();
            extraccion.setVisible(false);
            confirmacionExtraccion.setVisible(false);
            String monto=tfield_usuario3.getText();
            this.tfield_usuario3.setText("");
            float m=Float.parseFloat(monto);
            //Aca va el store procedure
             java.sql.Statement stmt = tabla.getConnection().createStatement();
             stmt.execute("call extraccion("+nro_tarjeta+","+m+","+100+",@A)");
             java.sql.ResultSet rs = stmt.executeQuery("select @A;");
             int error=-1;
             while(rs.next()){
                 error=rs.getInt(1);    
             }
             stmt.close();
             mostrarError(error);

             rs.close();
             stmt.close();
             if(tabla.getRowCount()>0)
                 tabla.refresh();
             convertir();
             this.consultarSaldo();
        } 
        catch (SQLException ex){
             Logger.getLogger(Atm.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NumberFormatException ex){
          JOptionPane.showMessageDialog(null, "Error en el monto ingresado.");
        }
    }//GEN-LAST:event_btn_ingresar4MousePressed

    private void btn_cancelar4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar4MouseEntered
        setColor(btn_cancelar4);
    }//GEN-LAST:event_btn_cancelar4MouseEntered

    private void btn_cancelar4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar4MouseExited
        btn_cancelar4.setBackground(color1);
    }//GEN-LAST:event_btn_cancelar4MouseExited

    private void btn_cancelar4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar4MousePressed
        extraccion.setVisible(true);
        confirmacionExtraccion.setVisible(false);
    }//GEN-LAST:event_btn_cancelar4MousePressed
    public void setTarjeta(int n){
        this.nro_tarjeta=n;
    }
    public void setNro(int n){
       this.nro_cuenta=n;
    }
     void setColor(JPanel panel){
        panel.setBackground(color3);
    }
    
     /**Metodo auxiliar para consultar saldo*/
    private void consultarSaldo(){
        try{
            /**Pido el saldo */
            java.sql.Statement stmt = tabla.getConnection().createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("select DISTINCT saldo from trans_cajas_ahorro where nro_ca="+this.nro_cuenta);
            while(rs.next()){
                JOptionPane.showMessageDialog(null, "Su saldo actual es de: $"+rs.getInt("saldo"));
            }
            stmt.close();
            rs.close();
        }
        catch (SQLException ex) { 
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                                       ex.getMessage() + "\n", 
                                       "Error al ejecutar la consulta.",
                                       JOptionPane.ERROR_MESSAGE);  //Mostrar error
         }
    }
     
    /**Inicio codigo autogenerado*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_cancelar;
    private javax.swing.JPanel btn_cancelar2;
    private javax.swing.JPanel btn_cancelar3;
    private javax.swing.JPanel btn_cancelar4;
    private javax.swing.JPanel btn_ingresar;
    private javax.swing.JPanel btn_ingresar2;
    private javax.swing.JPanel btn_ingresar3;
    private javax.swing.JPanel btn_ingresar4;
    private javax.swing.JFrame confirmacion;
    private javax.swing.JFrame confirmacionExtraccion;
    private javax.swing.JFrame extraccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelErrorExtraccion;
    private javax.swing.JLabel jLabelErrorTransferencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_cancelar;
    private javax.swing.JLabel lbl_cancelar2;
    private javax.swing.JLabel lbl_cancelar3;
    private javax.swing.JLabel lbl_cancelar4;
    private javax.swing.JLabel lbl_ingresar;
    private javax.swing.JLabel lbl_ingresar2;
    private javax.swing.JLabel lbl_ingresar3;
    private javax.swing.JLabel lbl_ingresar4;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JLabel lbl_usuario2;
    private javax.swing.JLabel lbl_usuario3;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelGeneral2;
    private javax.swing.JPanel panelGeneral3;
    private javax.swing.JPanel panelGeneral4;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JPanel panelUsuario2;
    private javax.swing.JPanel panelUsuario3;
    private javax.swing.JPanel panelUsuario4;
    private javax.swing.JPanel panelUsuario5;
    private javax.swing.JTextField tfield_usuario;
    private javax.swing.JTextField tfield_usuario2;
    private javax.swing.JTextField tfield_usuario3;
    private javax.swing.JFrame transferencia;
    // End of variables declaration//GEN-END:variables
    /**Fin codigo autogenerado*/
}
