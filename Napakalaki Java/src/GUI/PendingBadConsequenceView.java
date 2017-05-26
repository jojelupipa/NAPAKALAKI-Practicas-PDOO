package GUI;

import NapakalakiGame.BadConsequence;
import NapakalakiGame.DeathBadConsequence;
import NapakalakiGame.NumericBadConsequence;
import NapakalakiGame.SpecificBadConsequence;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class PendingBadConsequenceView extends javax.swing.JPanel {
    BadConsequence pendingBadConsequenceModel;
    /**
     * Creates new form PendingBadConsequenceView
     */
    public PendingBadConsequenceView() {
        initComponents();
    }
    
    public void setPendingBadConsequence(BadConsequence aPendingBadConsequence){
        pendingBadConsequenceModel = aPendingBadConsequence;
       
        if(pendingBadConsequenceModel instanceof NumericBadConsequence){
            this.nVisibleTreasures.setText("Tesoros visibles: "+ (((NumericBadConsequence)pendingBadConsequenceModel).getNVisibleTreasures()));
            this.nHiddenTreasures.setText("Tesoros ocultos: " +(((NumericBadConsequence)pendingBadConsequenceModel).getNHiddenTreasures()));
        }

        if(pendingBadConsequenceModel instanceof SpecificBadConsequence){
            this.specificVisibleTreasures.setText("Tesoros visibles especificos: "+((SpecificBadConsequence)pendingBadConsequenceModel).getSpecificVisibleTreasures().toString());
            this.specificHiddenTreasures.setText("Tesoros ocultos especificos: "+((SpecificBadConsequence)pendingBadConsequenceModel).getSpecificHiddenTreasures().toString());
        }
      
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

        jPanel1 = new javax.swing.JPanel();
        nVisibleTreasures = new javax.swing.JLabel();
        nHiddenTreasures = new javax.swing.JLabel();
        specificVisibleTreasures = new javax.swing.JLabel();
        specificHiddenTreasures = new javax.swing.JLabel();

        nVisibleTreasures.setText("Número de tesoros visibles a descartar:");
        nVisibleTreasures.setName(""); // NOI18N

        nHiddenTreasures.setText("Número de tesoros ocultos a descartar:");

        specificVisibleTreasures.setText("Tesoros visibles específicos:");

        specificHiddenTreasures.setText("Tesoros ocultos específicos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nVisibleTreasures)
                    .addComponent(nHiddenTreasures)
                    .addComponent(specificVisibleTreasures)
                    .addComponent(specificHiddenTreasures))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nVisibleTreasures)
                .addGap(26, 26, 26)
                .addComponent(nHiddenTreasures)
                .addGap(26, 26, 26)
                .addComponent(specificVisibleTreasures)
                .addGap(26, 26, 26)
                .addComponent(specificHiddenTreasures)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nHiddenTreasures;
    private javax.swing.JLabel nVisibleTreasures;
    private javax.swing.JLabel specificHiddenTreasures;
    private javax.swing.JLabel specificVisibleTreasures;
    // End of variables declaration//GEN-END:variables
}
