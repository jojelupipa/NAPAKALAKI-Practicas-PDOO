/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import NapakalakiGame.CombatResult;
import NapakalakiGame.Napakalaki;
import static java.lang.System.exit;

/**
 *
 * @author Jesús Sánchez de Lechina y Miguel Robles
 */
public class NapakalakiView extends javax.swing.JFrame {
    Napakalaki napakalakiModel;
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
        if(n.getCurrentPlayer() != null){
            this.currentPlayer.setPlayer(n.getCurrentPlayer());
            this.currentPlayer.setNapakalaki(napakalakiModel);
        }
        if(n.getCurrentMonster() != null)
            this.currentMonster.setMonster(n.getCurrentMonster());
        
        resultPannel.setVisible(false);
        nextTurnButton.setEnabled(false);
        combatButton.setEnabled(false);
        currentMonster.setVisible(false);
        currentPlayer.setEnableSteal(false);

        repaint();
        revalidate();
}
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
    }
    
       public void setEnableButtons(boolean set){
        combatButton.setEnabled(set);
        nextTurnButton.setEnabled(set);
        meetTheMonsterButton.setEnabled(set);
        exitButton.setEnabled(set);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        warningPanel = new javax.swing.JOptionPane();
        combatButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        meetTheMonsterButton = new javax.swing.JButton();
        nextTurnButton = new javax.swing.JButton();
        currentMonster = new GUI.MonsterView();
        resultPannel = new javax.swing.JPanel();
        messages = new javax.swing.JLabel();
        currentPlayer = new GUI.PlayerView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combatButton.setText("¡Combate!");
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });
        getContentPane().add(combatButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 50));

        meetTheMonsterButton.setText("Conoce al monstruo");
        meetTheMonsterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetTheMonsterButtonActionPerformed(evt);
            }
        });
        getContentPane().add(meetTheMonsterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        nextTurnButton.setText("Siguiente turno");
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextTurnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        getContentPane().add(currentMonster, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, -1, 214));

        resultPannel.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado combate"));

        messages.setText("Mensajes");
        resultPannel.add(messages);

        getContentPane().add(resultPannel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 210, 70));
        getContentPane().add(currentPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        
        switch(napakalakiModel.developCombat()){
            case WIN: messages.setText("Has ganado el combate");
                break;
            case LOSE: messages.setText("Has perdido el combate");
                break;
            case LOSEANDCONVERT: messages.setText("¡Ahora eres sectario!");
                break;
            case WINGAME: messages.setText("Has ganado el combate y la partida!!");
                break;
        }
        currentPlayer.setPendingVisible();
        this.currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
        nextTurnButton.setEnabled(true);
        currentPlayer.setEnableButtons(true);
        meetTheMonsterButton.setEnabled(false);
        combatButton.setEnabled(false);
        resultPannel.setVisible(true);
        repaint();
        revalidate();
    }//GEN-LAST:event_combatButtonActionPerformed

    private void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnButtonActionPerformed
        if(napakalakiModel.nextTurn()){
            nextTurnButton.setEnabled(false);
            currentMonster.setVisible(false);
            meetTheMonsterButton.setEnabled(true);
            currentPlayer.setPendingHidden();

        }
        else
            warningPanel.showMessageDialog(null, "No cumples las condiciones para pasar de turno."
            + "\nO bien tienes más de 4 tesoros ocultos."
            + "\nO bien te queda mal rollo por cumplir.", "ADVERTENCIA", warningPanel.WARNING_MESSAGE);
        this.currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
        this.currentMonster.setMonster(napakalakiModel.getCurrentMonster());
        combatButton.setEnabled(false);
        resultPannel.setVisible(false);
        
        repaint();
        revalidate();    }//GEN-LAST:event_nextTurnButtonActionPerformed

    private void meetTheMonsterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetTheMonsterButtonActionPerformed
       currentMonster.setVisible(true);
       combatButton.setEnabled(true);
       meetTheMonsterButton.setEnabled(false);
       currentPlayer.setEnableButtons(false);
       
       revalidate();
       repaint();
    }//GEN-LAST:event_meetTheMonsterButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

     public void showView() {
     this.setVisible(true);
     repaint();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton combatButton;
    private GUI.MonsterView currentMonster;
    private GUI.PlayerView currentPlayer;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton meetTheMonsterButton;
    private javax.swing.JLabel messages;
    private javax.swing.JButton nextTurnButton;
    private javax.swing.JPanel resultPannel;
    private javax.swing.JOptionPane warningPanel;
    // End of variables declaration//GEN-END:variables
}
