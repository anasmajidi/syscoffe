package coffe.serveur.categorie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    private List<EventMenu> events;


    public Menu() {
        initComponents();
        setOpaque(false);
        events = new ArrayList<>();
        panel.setLayout(new MigLayout("wrap, fill, inset 0", "[center]", "[center]"));
        addSpace(20);
        addItem("1", 0);
        addItem("2", 1);
        addItem("3", 2);
        addItem("4", 3);
        addItem("5", 4);
        addItem("6", 5);

        addSpace(20);
        repaint();
        revalidate();
    }

    private void addSpace(int size) {
        panel.add(new JLabel(), "h " + size + "!");
    }

    private void addItem(String icon, int index) {
        MenuItem item = new MenuItem(index);
        item.setImage(new ImageIcon(getClass().getResource("/categorieIcon/" + icon + ".png")).getImage());
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                runEvent(index);
            }
        });
        panel.add(item, "w 80!, h 80!");
    }

    public void addEvent(EventMenu event) {
        events.add(event);
    }

    private void runEvent(int index) {

        for (EventMenu event : events) {
            event.menuSelected(index);
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new com.raven.swing.Panel_1();

        panel.setBackground(new java.awt.Color(242, 242, 242));
        panel.setGradientColor(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Panel_1 panel;
    // End of variables declaration//GEN-END:variables
}
