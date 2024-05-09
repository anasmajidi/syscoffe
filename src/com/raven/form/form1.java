package com.raven.form;

import coffe.tablecell.TableActionCellEditor;
import coffe.tablecell.TableActionCellRender;
import coffe.tablecell.TableActionEvent;
import com.formdev.flatlaf.FlatClientProperties;
import com.raven.component.item;
import com.raven.model.ModelItem;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import raven.toast.Notifications;


public class form1 extends javax.swing.JPanel {


    private double totalPrice = 0.0;
    
    private ModelItem[] itemsSet1;//
    private ModelItem[] itemsSet2;
    private ModelItem[] itemsSet3;
    private ModelItem[] itemsSet4;
    private ModelItem[] itemsSet5;
    private ModelItem[] itemsSet6;//

    public form1() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        scroll.setVerticalScrollBar(new ScrollBar());
        TestItem();
        initializeItems();
        applyTableStyle(table);
        TableActionEvent event = new TableActionEvent() {

            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                    updateTotalPrice();
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
            }

        };
        table.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // Column 1
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); // Column 2
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); // Column 3
        table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    System.out.println("Table model changed");
                    updateTotalPrice();
                }
            }
        });

        updateTotalPrice();

    }

    private void handleMenuItemSelection(int index) {
        // Call the menuSelected method of the Main instance
    }

    public void addItem(ModelItem data) {
        item item = new item();
        item.setdata(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int id = data.getId_produit();
                    String designation = data.getDesignation();
                    double price = data.getPrix_vente();
                    int quantity = item.getQuantityValue();
                    if (quantity != 0) { // Check if quantity is not 0
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.addRow(new Object[]{id, designation, price, quantity, null});
                        updateTotalPrice();
                    } else {
                        Notifications.getInstance().show(Notifications.Type.ERROR, 500, "Quantity cannot be 0 or empty");
                    }

                }
            }
        });
        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
    }


        private void initializeItems() {

        itemsSet1 = new ModelItem[]{
            new ModelItem(1, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 1),
            new ModelItem(2, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 1),};

        itemsSet2 = new ModelItem[]{
            new ModelItem(1, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 1),
            new ModelItem(2, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 1),};

        itemsSet3 = new ModelItem[]{
            new ModelItem(1, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 4),
            new ModelItem(2, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 3),};

        itemsSet4 = new ModelItem[]{
            new ModelItem(1, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 4),
            new ModelItem(2, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 3),};

        itemsSet5 = new ModelItem[]{
            new ModelItem(1, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 4),
            new ModelItem(2, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 3),};

        itemsSet6 = new ModelItem[]{
            new ModelItem(1, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 4),
            new ModelItem(2, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 3),};
    }
        
        private ModelItem[] getModelItems(int index) {
        switch (index) {
            case 1:
                return itemsSet1;
            case 2:
                return itemsSet2;
            case 3:
                return itemsSet3;
            case 4:
                return itemsSet4;
            case 5:
                return itemsSet5;
            case 6:
                return itemsSet6;
            default:
                return null;
        }
    }

    private void applyTableStyle(JTable table) {

        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        table.putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");

    }

    private void updateTotalPrice() {
        double totalPrice = calculateTotalPrice();
        TotalPrice.setText(String.format("%.2f", totalPrice));
    }

    private double calculateTotalPrice() {
        double totalPrice = 0.0;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int row = 0; row < model.getRowCount(); row++) {
            try {
                double price = (double) model.getValueAt(row, 2);
                int quantity = (int) model.getValueAt(row, 3);
                totalPrice += price * quantity;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total price calculated: " + totalPrice);
        return totalPrice;
    }

    private void TestItem() {

        ModelItem[] items = {
            new ModelItem(1, "Cafe Noir", new ImageIcon(getClass().getResource("/coffe/product/caffenoir.png")), 08.00, 1),
            new ModelItem(2, "Espresso", new ImageIcon(getClass().getResource("/coffe/img/espresso.png")), 08.00, 1),
            new ModelItem(3, "Ness Ness", new ImageIcon(getClass().getResource("/coffe/img/ness_ness.png")), 08.00, 1),
            new ModelItem(4, "Cafe Italien", new ImageIcon(getClass().getResource("/coffe/product/cafe italien.png")), 08.00, 1),
            new ModelItem(5, "Cafe Mouse Blanche", new ImageIcon(getClass().getResource("/coffe/product/cafe mousse blanche.png")), 08.00, 1),
            new ModelItem(6, "Cafe Royal", new ImageIcon(getClass().getResource("/coffe/product/cafe royal.png")), 08.00, 1),
            new ModelItem(7, "Cafe Allonge", new ImageIcon(getClass().getResource("/coffe/product/caffe-alloge.png")), 08.00, 1),
            new ModelItem(8, "Cafe Separe", new ImageIcon(getClass().getResource("/coffe/product/caffesepare.png")), 08.00, 1),
            new ModelItem(9, "Cafe Creme", new ImageIcon(getClass().getResource("/coffe/product/cafe creme.png")), 08.00, 1),
            new ModelItem(10, "Cappucciono", new ImageIcon(getClass().getResource("/coffe/product/cappuccino.png")), 08.00, 1),
            new ModelItem(11, "Lait chaud", new ImageIcon(getClass().getResource("/coffe/product/lait chaud.png")), 8.00, 1),
            new ModelItem(12, "Lait Froid", new ImageIcon(getClass().getResource("/coffe/product/lait froid.png")), 08.00, 1),
            new ModelItem(13, "Lait Sirop", new ImageIcon(getClass().getResource("/coffe/product/lait sirop.png")), 08.00, 1),
            new ModelItem(14, "Lipton", new ImageIcon(getClass().getResource("/coffe/product/lipton.png")), 08.00, 1),};

        // Add items to panelItem
        for (ModelItem item : items) {
            addItem(item);
            panelItem.repaint();
            panelItem.revalidate();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        jLabel1 = new javax.swing.JLabel();
        TotalPrice = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button1 = new coffe.shadow.Button();
        scroll = new javax.swing.JScrollPane();
        panelItem = new com.raven.swing.PanelItem();

        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "border:1,1,1,1,shade(@background,10%),,30",
            new String[]{
                ""
            }
        ));
        crazyPanel1.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "",
            "",
            "",
            new String[]{
                "wrap",
                "width 400"
            }
        ));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Name", "Price", "Qty", "Sup"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(40);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(20);
            table.getColumnModel().getColumn(1).setPreferredWidth(160);
            table.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        crazyPanel1.add(jScrollPane1);

        crazyPanel2.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "border:1,1,1,1,shade(@background,10%),,30",
            new String[]{
                "font:bold +10",
                "font:bold +10",
                ""
            }
        ));
        crazyPanel2.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "",
            "[]push[][]",
            "",
            new String[]{
                "height 60,width 160",
                "height 60,width 60",
                "height 60,width 20,wrap"
            }
        ));

        jLabel1.setText("Total Price :");
        crazyPanel2.add(jLabel1);

        TotalPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        crazyPanel2.add(TotalPrice);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel3.setText("DH");
        crazyPanel2.add(jLabel3);

        crazyPanel1.add(crazyPanel2);

        button1.setText("PAY");
        button1.setRound(20);

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(panelItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scroll)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalPrice;
    private coffe.shadow.Button button1;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelItem panelItem;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
