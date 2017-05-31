package GUI;

import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class PlayerView extends javax.swing.JPanel {
    
    private Napakalaki napakalakiModel;
    Player playerModel;
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
        jPanel1.setVisible(false);
    }
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
    }
    
    public static String boolToSiONo(boolean b){
        if(b)
            return "Sí";
        else
            return "No";
    }
    public void updatePendingBadView()    {
        //jPanel1.removeAll();
        jPanel1.invalidate();
        PendingBadConsequenceView bv = new PendingBadConsequenceView();
        bv.setPendingBadConsequence(playerModel.getPendingBadConsequence());
        jPanel1.add(bv);
        jPanel1.repaint();
        jPanel1.revalidate();
        
    }
    
    public void setPlayer(Player p){
       playerModel = p;

       this.name.setText(playerModel.getName());
       this.level.setText("Nivel: "+Integer.toString(playerModel.getLevels()));
       Font auxFont=combatLevel.getFont(); 
       combatLevel.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
       this.combatLevel.setText("Nivel Combate: " + Integer.toString(playerModel.getCombatLevel()));
       this.canISteal.setText("¿Puede robar? " + boolToSiONo(playerModel.canISteal()));
       this.death.setText("¿Muerto? " + boolToSiONo(playerModel.isDead()));
       
       if(playerModel.getEnemy()!=null)
          this.enemy.setText("Enemigo: " + playerModel.getEnemy().getName());
              
       this.cultist.setText("¿Sectario? " + boolToSiONo(playerModel instanceof CultistPlayer));
       this.nCultist.setText("Número de sectarios: " + Integer.toString(CultistPlayer.getTotalCultistPlayers()));
       
       updatePendingBadView();
       this.pendingBadConsequenceView1.setPendingBadConsequence(playerModel.getPendingBadConsequence());

       fillTreasurePanel (visibleTreasures, playerModel.getVisibleTreasures());
       fillTreasurePanel (hiddenTreasures, playerModel.getHiddenTreasures());
       
       repaint();
       revalidate();
    }
    protected void setPendingVisible(){
        updatePendingBadView();
        jPanel1.setVisible(true);  
        pendingBadConsequenceView1.setVisible(true);

        repaint();
           }
    protected void setPendingHidden(){
       jPanel1.setVisible(false);
       repaint();
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
    repaint();
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
    
    public void setEnableButtons(boolean set){
        discardButton.setEnabled(set);
        makeVisibleButton.setEnabled(set);
        stealButton.setEnabled(set);
        discardAllButton.setEnabled(set);
        repaint();
    }
    
    public void setEnableSteal(boolean set){
        stealButton.setEnabled(set);
        repaint();
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
        jPanel1 = new javax.swing.JPanel();
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
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nCultist, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(level, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(59, 59, 59)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(death)
                                .addComponent(canISteal)
                                .addComponent(enemy))
                            .addGap(3, 3, 3)))
                    .addComponent(cultist)
                    .addComponent(combatLevel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(canISteal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(level)
                    .addComponent(death))
                .addGap(16, 16, 16)
                .addComponent(combatLevel)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cultist)
                    .addComponent(enemy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nCultist))
        );

        visibleTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tesoros Visibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(11, 147, 2))); // NOI18N
        visibleTreasures.setMaximumSize(new java.awt.Dimension(115, 122));
        visibleTreasures.setMinimumSize(new java.awt.Dimension(115, 122));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tesoros ocultos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        hiddenTreasures.setMaximumSize(new java.awt.Dimension(115, 122));
        hiddenTreasures.setMinimumSize(new java.awt.Dimension(115, 122));

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
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        discardAllButton.setText("Descartar todos los tesoros");
        discardAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mal Rollo"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(makeVisibleButton)
                        .addGap(18, 18, 18)
                        .addComponent(discardButton)
                        .addGap(18, 18, 18)
                        .addComponent(discardAllButton)
                        .addGap(18, 18, 18)
                        .addComponent(stealButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                            .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeVisibleButton)
                    .addComponent(discardButton)
                    .addComponent(discardAllButton)
                    .addComponent(stealButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stealButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealButtonActionPerformed
        napakalakiModel.getCurrentPlayer().stealTreasure();
        setPlayer (napakalakiModel.getCurrentPlayer());
        repaint();
    }//GEN-LAST:event_stealButtonActionPerformed

    private void makeVisibleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleButtonActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        napakalakiModel.makeTreasuresVisible (selHidden);
        setPlayer (napakalakiModel.getCurrentPlayer());
        repaint();
    }//GEN-LAST:event_makeVisibleButtonActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        ArrayList<Treasure> sel1 = getSelectedTreasures (hiddenTreasures);
        ArrayList<Treasure> sel2 = getSelectedTreasures (visibleTreasures);
        napakalakiModel.discardVisibleTreasures(sel2);
        napakalakiModel.discardHiddenTreasures(sel1);
        setPlayer (napakalakiModel.getCurrentPlayer());
        
        repaint();
    }//GEN-LAST:event_discardButtonActionPerformed

    private void discardAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllButtonActionPerformed
        napakalakiModel.getCurrentPlayer().discardAllTreasures();
        setPlayer (napakalakiModel.getCurrentPlayer());
        
        repaint();
    }//GEN-LAST:event_discardAllButtonActionPerformed
    


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
    private javax.swing.JPanel jPanel1;
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
