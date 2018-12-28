package GUI;

import java.sql.SQLException;
import java.sql.Types;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import quick.dbtable.DBTable;

public class Admin extends javax.swing.JPanel {
    private DBTable tabla;
    private Home h;
    
    public Admin(Home h) {
        initComponents();
        this.h=h;
        tabla=new DBTable();
        tabla.setEditable(false);
        this.paraDBTable.add(tabla);
    }
    
    public void iniciarAdmin(String usr, String pass) throws SQLException{
        conectarBD(usr,pass);
        this.cargarTablas(); 
        this.jTextArea2.setText("");
        tabla.setSelectSql("select tipo_doc as A, tipo_doc as B, tipo_doc as C, tipo_doc as D from Cliente where nro_doc=-1;");
        tabla.createColumnModelFromQuery();
        tabla.removeAllRows();
    }

    private void conectarBD(String usr, String pass) throws SQLException{
        String driver ="com.mysql.cj.jdbc.Driver";
        String servidor = "localhost:3306";
	String baseDatos = "banco";
	String uriConexion = "jdbc:mysql://" + servidor + "/" + baseDatos+"?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone="+java.util.TimeZone.getDefault().getID();
        try {
            tabla.connectDatabase(driver, uriConexion, usr, pass);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,
                                           "Se produjo un error al intentar conectarse a la base de datos.\n" + ex.getMessage(),
                                           "Error",
                                           JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanelAdmin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScroll = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        paraDBTable = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Introduzca la sentencia en código SQL");

        jPanelAdmin.setBackground(new java.awt.Color(216, 223, 234));
        jPanelAdmin.setInheritsPopupMenu(true);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Atributos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/images/icons8_List_15px.png"))); // NOI18N
        jLabel1.setText("Seleccion de tablas");

        jScroll.setViewportView(jList1);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37))
        );
        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/images/icons8_Circled_Play_32px_1.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        paraDBTable.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(paraDBTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paraDBTable, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
       this.refrescarTabla(this.jTextArea2.getText());
    }//GEN-LAST:event_jLabel4MousePressed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        try{
            this.jList1.removeAll();
            DefaultListModel modelo = new DefaultListModel();
            String s=(String) this.jComboBox1.getSelectedItem();
            if(s!=null){
            java.sql.Statement stmt = tabla.getConnection().createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("DESCRIBE "+s+";");
            while(rs.next())
            modelo.addElement(rs.getString("Field"));
            this.jList1.setModel(modelo);
            stmt.close();
            rs.close();
            }
        }
        catch (SQLException ex){
            // en caso de error, se muestra la causa
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                ex.getMessage() + "\n",
                "Error al ejecutar la consulta.",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        this.desconectarBD();
    }//GEN-LAST:event_formComponentHidden
    
  
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JScrollPane jScroll;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JPanel paraDBTable;
    // End of variables declaration//GEN-END:variables

private void cargarTablas(){
    try{
        this.jComboBox1.removeAllItems();
        java.sql.Statement stmt = tabla.getConnection().createStatement();
        java.sql.ResultSet rs = stmt.executeQuery("show tables");
        while(rs.next())
            this.jComboBox1.addItem(rs.getString(1));
        rs.close();
        stmt.close();
        this.jComboBox1.repaint();
    }
     catch (SQLException ex){
         // en caso de error, se muestra la causa
         JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                                       ex.getMessage() + "\n", 
                                       "Error al ejecutar la consulta.",
                                       JOptionPane.ERROR_MESSAGE);   
      }
}
private void refrescarTabla(String query){
      try{
        if(query!=null && query.trim()!=""){
    	 if(query.toLowerCase().startsWith("select")){
             tabla.setSelectSql(query);
             tabla.createColumnModelFromQuery();    
             for (int i = 0; i < tabla.getColumnCount(); i++){  		   		  
    		 if(tabla.getColumn(i).getType()==Types.TIME){    		 
                    tabla.getColumn(i).setType(Types.CHAR);  
  	       	 }
    		 if(tabla.getColumn(i).getType()==Types.DATE){
    		    tabla.getColumn(i).setDateFormat("dd/MM/YYYY");
    		 }
               }     	  
            tabla.refresh();
         }
         else{
              java.sql.Statement stmt = tabla.getConnection().createStatement();
              stmt.execute(query);
              stmt.close();
              tabla.cleanup();
              if(tabla.getRowCount()>0)
                  tabla.refresh();
              this.cargarTablas();
         }
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
          }  
       }
      catch (SQLException ex){
         // en caso de error, se muestra la causa
         JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                                       ex.getMessage() + "\n", 
                                       "Error al ejecutar la consulta.",
                                       JOptionPane.ERROR_MESSAGE); 
      }
   }
    private void desconectarBD(){
         try{
            tabla.close();            
         }
         catch (SQLException ex){
            JOptionPane.showMessageDialog(this,
                                           "Se produjo un error al intentar conectarse a la base de datos.\n" + ex.getMessage(),
                                           "Error",
                                           JOptionPane.ERROR_MESSAGE);
         }      
    }
    
}


