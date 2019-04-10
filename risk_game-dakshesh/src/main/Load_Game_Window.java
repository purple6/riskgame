/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import game_engine.Game.GameObjectsWrapper;
import game_engine.Game.LoadGame;
import game_engine.GameDriver;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 * Load Game Window
 * @author daksh
 */
public class Load_Game_Window extends javax.swing.JFrame {

    /**
     * Path of the .game file
     */
    String gamePath;

    /**
     * Creates new form Load_Game_Window
     */
    public Load_Game_Window() {
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

        jLabel1 = new javax.swing.JLabel();
        gPath = new javax.swing.JTextField();
        loadButton = new javax.swing.JButton();
        browse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Game File : ");

        gPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gPathActionPerformed(evt);
            }
        });

        loadButton.setText("Load Game");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gPath, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browse))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(loadButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(gPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browse))
                .addGap(33, 33, 33)
                .addComponent(loadButton)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
        String gamePath = gPath.getText().toString();

        if (validGameFile(gamePath)) {
            LoadGame lg = new LoadGame(gamePath);
            GameObjectsWrapper gow = null;
            try {
                gow = lg.loadGame();
            } catch (IOException ex) {
                System.out.println("Not a Valid Game File");
                ex.printStackTrace();
            }
//            GameDriver gd = new GameDriver(gow.gameBoard, gow.player, gow.getCurrentTurn());
            GameDriver gd = new GameDriver();
            gd.startLoadedGame(gow.getGameBoard(), gow.getPlayer(), gow.getCurrentTurn(), gow.getGameMode(), gow.getDrawTurn(), gow.getTurnCounter(), gow.getGameResult());
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String gamePath = selectedFile.getAbsolutePath();
            gPath.setText(gamePath);
            System.out.println(gamePath);
            this.gamePath = gamePath;
        }
    }//GEN-LAST:event_browseActionPerformed

    private void gPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gPathActionPerformed

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
            java.util.logging.Logger.getLogger(Load_Game_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Load_Game_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Load_Game_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Load_Game_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Load_Game_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JTextField gPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loadButton;
    // End of variables declaration//GEN-END:variables

    private boolean validGameFile(String gamePath) {
        if (gamePath.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please Select Game File");
            return false;
        } else {

            String p[] = gamePath.split("\\\\");
            String fileName = p[p.length - 1];
            String e[] = fileName.split("\\.");
            if (e[1].equals("game")) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Not a valid game file");
                return false;
            }
        }
    }
}
