/*
This class interacts with GameMap class. That on clicking buttons actions are defined 
in GameMap like verify map and all that.
 */
package static_ui;

/**
 *
 * @author shivam
 */
public class LoadMap extends javax.swing.JFrame {

    /**
     * Creates new form LoadMap
     */
    public LoadMap() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoadMapOK = new javax.swing.JButton();
        LoadMapSave = new javax.swing.JButton();
        LoadMapEdit = new javax.swing.JButton();
        LoadMapScrollPane1 = new javax.swing.JScrollPane();
        LoadMapTable1 = new javax.swing.JTable();
        LoadMapVerify = new javax.swing.JButton();
        LoadMapAddContinent = new javax.swing.JButton();
        LoadMapAddCountry = new javax.swing.JButton();
        LoadMapScrollPane2 = new javax.swing.JScrollPane();
        LoadMapTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoadMapOK.setText("OK");

        LoadMapSave.setText("Save");

        LoadMapEdit.setText("Edit");

        LoadMapTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        LoadMapScrollPane1.setViewportView(LoadMapTable1);

        LoadMapVerify.setText("Verify");

        LoadMapAddContinent.setText("Add Continent");

        LoadMapAddCountry.setText("Add Country");

        LoadMapTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        LoadMapScrollPane2.setViewportView(LoadMapTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(LoadMapVerify)
                .addGap(61, 61, 61)
                .addComponent(LoadMapAddContinent)
                .addGap(32, 32, 32)
                .addComponent(LoadMapAddCountry)
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LoadMapScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(LoadMapScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LoadMapSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoadMapEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoadMapOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoadMapOK)
                        .addGap(18, 18, 18)
                        .addComponent(LoadMapSave))
                    .addComponent(LoadMapScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LoadMapEdit)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoadMapVerify)
                    .addComponent(LoadMapAddContinent)
                    .addComponent(LoadMapAddCountry))
                .addGap(18, 18, 18)
                .addComponent(LoadMapScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoadMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadMap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoadMapAddContinent;
    private javax.swing.JButton LoadMapAddCountry;
    private javax.swing.JButton LoadMapEdit;
    private javax.swing.JButton LoadMapOK;
    private javax.swing.JButton LoadMapSave;
    private javax.swing.JScrollPane LoadMapScrollPane1;
    private javax.swing.JScrollPane LoadMapScrollPane2;
    private javax.swing.JTable LoadMapTable1;
    private javax.swing.JTable LoadMapTable2;
    private javax.swing.JButton LoadMapVerify;
    // End of variables declaration//GEN-END:variables
}
