package GUI;
import NapakalakiGame.Treasure;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class TreasureView extends javax.swing.JPanel {

    Treasure treasureModel;
    private boolean selected = false;
    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        initComponents();
    }
    
    /**
     * Consultor de selected
     */
    
    public boolean isSelected(){
        return selected;
    }
    
    public Treasure getTreasure(){
        return treasureModel;
    }
    
    
    /** 
     * Update view's components
     */
     public void setTreasure (Treasure aTreasure) {
        treasureModel = aTreasure;
        this.name.setText (treasureModel.getName());
        this.bonus.setText("Bonus :" + treasureModel.getBonus());
        this.type.setText("Tipo:" + treasureModel.getType().toString());

        // la siguiente instrucción hace que los cambios en la vista sean efectivos
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

        panel = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        bonus = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tesoro"));
        panel.setName(""); // NOI18N

        name.setText("Nombre");

        type.setText("Tipo");

        bonus.setText("Bonus");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addComponent(type)
                    .addComponent(bonus))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(name)
                .addGap(18, 18, 18)
                .addComponent(type)
                .addGap(18, 18, 18)
                .addComponent(bonus)
                .addGap(0, 37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(selected == true){
            selected = false;
            setOpaque(false);
        }
        else {
            selected = true;
            setOpaque(true);
        }
        
        repaint();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bonus;
    private javax.swing.JLabel name;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
