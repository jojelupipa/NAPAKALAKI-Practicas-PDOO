/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class PlayerView extends javax.swing.JPanel {
    
    Napakalaki napakalakiModel;
    Player playerModel;
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
    }
    
    public void setPlayer(Player p){
       playerModel = p;
       
       this.name.setText(playerModel.getName());
       this.level.setText(Integer.toString(playerModel.getLevels()));
       this.combatLevel.setText(Integer.toString(playerModel.getCombatLevel()));
       this.canISteal.setText(Boolean.toString(playerModel.canISteal()));
       this.death.setText(Boolean.toString(playerModel.isDead()));
       this.pendingBadConsequenceView1.setPendingBadConsequencer(playerModel.getPendingBadConsequence());
       
       if(playerModel.getEnemy()!=null)
          this.enemy.setText(playerModel.getEnemy().getName());
       
       this.cultist.setText(Boolean.toString(playerModel instanceof CultistPlayer));
       this.nCultist.setText(Integer.toString(CultistPlayer.getTotalCultistPlayers()));
              
       fillTreasurePanel (visibleTreasures, playerModel.getVisibleTreasures());
       fillTreasurePanel (hiddenTreasures, playerModel.getHiddenTreasures());
       
       repaint();
       revalidate();
    }
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
    // Se recorren los tesoros que contiene el panel,
    //    almacenando en un vector aquellos que están seleccionados.
    //    Finalmente se devuelve dicho vector.
    
    TreasureView tv;
    ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
             output.add ( tv.getTreasure() );
            }
    return output;
    }
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas al panel
        for (Treasure t : aList) {
        TreasureView aTreasureView = new TreasureView();
        aTreasureView.setTreasure (t);
        aTreasureView.setVisible (true);
        aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
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
        jLabel2 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        canISteal = new javax.swing.JLabel();
        death = new javax.swing.JLabel();
        enemy = new javax.swing.JLabel();
        cultist = new javax.swing.JLabel();
        nCultist = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        stealButton = new javax.swing.JButton();
        makeVisibleButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        discardAllButton = new javax.swing.JButton();
        pendingBadConsequenceView1 = new GUI.PendingBadConsequenceView();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Jugador"));

        name.setText("Nombre");

        level.setText("Nivel");

        combatLevel.setText("Nivel de Combate");

        canISteal.setText("Robar");

        death.setText("Muerte");

        enemy.setText("Enemigo");

        cultist.setText("Cultista");

        nCultist.setText("NCultistas");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addComponent(level)
                    .addComponent(combatLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canISteal)
                    .addComponent(enemy)
                    .addComponent(death))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cultist)
                    .addComponent(nCultist))
                .addGap(120, 120, 120))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(canISteal)
                    .addComponent(cultist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(level)
                    .addComponent(death)
                    .addComponent(nCultist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combatLevel)
                    .addComponent(enemy))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        visibleTreasures.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(42, 196, 2)));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));

        stealButton.setText("Robar");
        stealButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealButtonActionPerformed(evt);
            }
        });

        makeVisibleButton.setText("Hacer Visible");
        makeVisibleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleButtonActionPerformed(evt);
            }
        });

        discardButton.setText("Descartar tesoro");

        discardAllButton.setText("Descartar todos los tesoros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stealButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discardAllButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(discardButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeVisibleButton)))
                .addGap(185, 185, 185))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stealButton)
                    .addComponent(discardAllButton))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeVisibleButton)
                    .addComponent(discardButton))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stealButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stealButtonActionPerformed

    private void makeVisibleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleButtonActionPerformed
    ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
    napakalakiModel.makeTreasuresVisible (selHidden);
    napakalakiModel.makeTreasuresVisible (selHidden);
    }//GEN-LAST:event_makeVisibleButtonActionPerformed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel canISteal;
    private javax.swing.JLabel combatLevel;
    private javax.swing.JLabel cultist;
    private javax.swing.JLabel death;
    private javax.swing.JButton discardAllButton;
    private javax.swing.JButton discardButton;
    private javax.swing.JLabel enemy;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel level;
    private javax.swing.JButton makeVisibleButton;
    private javax.swing.JLabel nCultist;
    private javax.swing.JLabel name;
    private javax.swing.JPanel panel;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView1;
    private javax.swing.JButton stealButton;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
