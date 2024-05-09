package com.raven.component;

import com.raven.model.ModelItem;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JTextField;

public class item extends javax.swing.JPanel {

    /**
     * @return the data
     */
    public ModelItem getData() {
        return data;
    }

    public item() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        lbqty.setText(null);
        addListeners();
    }

    private void addListeners() {
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementQty();
            }
        });

        buttonMois.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decrementQty();
            }
        });
    }

    private ModelItem data;

    public void setdata(ModelItem data) {
        this.data = data;
        idproduit.setText(String.valueOf(data.getCategorie_id()));
        designation.setText(data.getDesignation());
        image.setImage(data.getImage());
        DecimalFormat df = new DecimalFormat("##0.00");
        prixvente.setText(df.format(data.getPrix_vente()));
        categorieid.setText(String.valueOf(data.getCategorie_id()));

    }

    private void incrementQty() {
        String text = lbqty.getText();
        int currentValue = (text.isEmpty()) ? 0 : Integer.parseInt(text);
        lbqty.setText(String.valueOf(currentValue + 1));
    }

    private void decrementQty() {
        int currentValue = Integer.parseInt(lbqty.getText());
        // Ensure the quantity does not go below 0
        if (currentValue > 0) {
            lbqty.setText(String.valueOf(currentValue - 01));
        }
    }
    
   
    public int getQuantityValue() {
    String text = lbqty.getText();
    if (text.isEmpty()) {
        return 0; // Return 0 if the quantity value is empty
    } else {
        return Integer.parseInt(text);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        designation = new javax.swing.JLabel();
        image = new com.raven.swing.PictureBox();
        jLabel2 = new javax.swing.JLabel();
        prixvente = new javax.swing.JLabel();
        idproduit = new javax.swing.JLabel();
        categorieid = new javax.swing.JLabel();
        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        lbqty = new javax.swing.JTextField();
        buttonPlus = new com.raven.swing.Button();
        buttonMois = new com.raven.swing.Button();

        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "border:1,1,1,1,shade(@background,10%),,30",
            new String[]{
                "font:bold +1"
            }
        ));
        crazyPanel1.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "",
            "",
            "",
            new String[]{
                "width 170,wrap",
                "width 170,height 170,wrap",
                "split 3,width 40,height 40"
            }
        ));

        designation.setForeground(new java.awt.Color(178, 178, 178));
        designation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        designation.setText("Item Name");
        crazyPanel1.add(designation);

        image.setImage(new javax.swing.ImageIcon(getClass().getResource("/coffe/icon/milk.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(212, 47, 47));
        jLabel2.setText("DH");
        image.add(jLabel2);
        jLabel2.setBounds(170, 150, 30, 30);

        prixvente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        prixvente.setForeground(new java.awt.Color(212, 47, 47));
        prixvente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prixvente.setText("00.00");
        image.add(prixvente);
        prixvente.setBounds(110, 150, 60, 30);
        image.add(idproduit);
        idproduit.setBounds(0, 0, 0, 0);
        image.add(categorieid);
        categorieid.setBounds(150, 0, 0, 0);

        crazyPanel1.add(image);

        crazyPanel2.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "border:1,1,1,1,shade(@background,10%),,30",
            new String[]{
                "JTextField.placeholderText=Qantity"
            }
        ));

        lbqty.setBackground(new java.awt.Color(242, 242, 242));
        lbqty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbqty.setBorder(null);
        crazyPanel2.add(lbqty);

        crazyPanel1.add(crazyPanel2);

        buttonPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffe/img/plus.png"))); // NOI18N
        buttonPlus.setMinimumSize(new java.awt.Dimension(40, 40));
        crazyPanel1.add(buttonPlus);

        buttonMois.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffe/img/moins_1.png"))); // NOI18N
        buttonMois.setMinimumSize(new java.awt.Dimension(40, 40));
        crazyPanel1.add(buttonMois);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button buttonMois;
    private com.raven.swing.Button buttonPlus;
    private javax.swing.JLabel categorieid;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private javax.swing.JLabel designation;
    private javax.swing.JLabel idproduit;
    private com.raven.swing.PictureBox image;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField lbqty;
    private javax.swing.JLabel prixvente;
    // End of variables declaration//GEN-END:variables
}
