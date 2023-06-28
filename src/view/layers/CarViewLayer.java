package view.layers;

import controller.CarController;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.regex.PatternSyntaxException;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Car;

/**
 *
 * @author ksand
 */
public class CarViewLayer extends javax.swing.JPanel {
    
    public CarViewLayer() {
        initComponents();
        ADEPanel.setVisible(false);
        searchPanel.setVisible(true);
        loadCar();
          jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Retrieve data from the selected row
                        String id = jTable1.getValueAt(selectedRow, 0).toString();
                        int idInt = Integer.parseInt(id);
                        CarController carController = new CarController();
                        Car car = carController.searchCar(idInt);
                        carId.setText(String.valueOf(car.getCar_id()));
                        carDate.setText(car.getCar_model_year().toString());
                        carbrand.setText(car.getCar_brand());
                        carname.setText(car.getCar_name());
                        number.setText(car.getPlate_number());
                        ownerid.setText(String.valueOf(car.getOwner_id()));
                        status.setText(car.getCar_status());
                        rate.setText(Integer.toString(car.getRate()));
                        color.setText(car.getCar_color());
                        ADEPanel.setVisible(true);
                        searchPanel.setVisible(false);
                        
                     
                    }
                }
            }
        });
           jScrollPane1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Check if the mouse click is outside the bounds of the JTable
            if (!jTable1.getVisibleRect().contains(e.getPoint())) {
                // Clear the selection on the JTable
                jTable1.clearSelection();
                ADEPanel.setVisible(false);
                searchPanel.setVisible(true);
            }
        }
    });
    }
       private void loadCar() {
        CarController carController = new CarController();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 

        for (Car car : carController.listCars()) {
            Object[] row = {
                    car.getCar_id(),
                    car.getCar_name(),
                    car.getCar_status(),
                    car.getCar_brand()
            };
            model.addRow(row);
        }

    }
    private void filterTable(String regex) {
    try {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());
        sorter.setRowFilter(RowFilter.regexFilter(regex));
        jTable1.setRowSorter(sorter);
    } catch (PatternSyntaxException ex) {
        System.err.println("Invalid regex pattern: " + ex.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        ADEPanel = new javax.swing.JPanel();
        carDate = new javax.swing.JTextField();
        carId = new javax.swing.JTextField();
        carname = new javax.swing.JTextField();
        carbrand = new javax.swing.JTextField();
        number = new javax.swing.JTextField();
        ownerid = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        rate = new javax.swing.JTextField();
        color = new javax.swing.JTextField();
        addCar = new javax.swing.JButton();
        deleteCar = new javax.swing.JButton();
        editCar = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        loadAllCar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Car Id ", "Car Name", "Current Status", "Year"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        carDate.setText("jTextField1");

        carId.setText("jTextField1");

        carname.setText("jTextField1");
        carname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnameActionPerformed(evt);
            }
        });

        carbrand.setText("jTextField1");

        number.setText("jTextField1");

        ownerid.setText("jTextField1");
        ownerid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                owneridActionPerformed(evt);
            }
        });

        status.setText("jTextField1");

        rate.setText("jTextField1");

        color.setText("jTextField1");

        addCar.setText("Add ");
        addCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarActionPerformed(evt);
            }
        });

        deleteCar.setText("Delete");
        deleteCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCarActionPerformed(evt);
            }
        });

        editCar.setText("Edit ");
        editCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ADEPanelLayout = new javax.swing.GroupLayout(ADEPanel);
        ADEPanel.setLayout(ADEPanelLayout);
        ADEPanelLayout.setHorizontalGroup(
            ADEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ADEPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ADEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ADEPanelLayout.createSequentialGroup()
                        .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ownerid, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ADEPanelLayout.createSequentialGroup()
                        .addComponent(carname, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(carbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ADEPanelLayout.createSequentialGroup()
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ADEPanelLayout.createSequentialGroup()
                        .addComponent(carDate, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(carId, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ADEPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addCar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(deleteCar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(editCar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ADEPanelLayout.setVerticalGroup(
            ADEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADEPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ADEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ADEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ADEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ownerid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ADEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ADEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCar)
                    .addComponent(editCar)
                    .addComponent(deleteCar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        loadAllCar.setText("Load all data");
        loadAllCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadAllCarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(SearchButton))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(loadAllCar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(loadAllCar)
                .addContainerGap())
        );

        jLayeredPane1.setLayer(ADEPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(searchPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ADEPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(ADEPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(121, 121, 121)
                    .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(121, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCarActionPerformed
          CarController carController = new CarController();
           carController.updateCar(Integer.parseInt(carId.getText()),carname.getText(), carbrand.getText(),Date.valueOf(carDate.getText()) , color.getText(), number.getText(), status.getText(),rate.getText(),Integer.parseInt(ownerid.getText()));
           loadCar();
    }//GEN-LAST:event_editCarActionPerformed

    private void deleteCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCarActionPerformed
        CarController carController = new CarController();
        carController.deleteCar(Integer.parseInt(carId.getText()));
        loadCar();

    }//GEN-LAST:event_deleteCarActionPerformed

    private void addCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarActionPerformed
           CarController carController = new CarController();
           carController.createCar(Integer.parseInt(carId.getText()),carname.getText(), carbrand.getText(),Date.valueOf(carDate.getText()) , color.getText(), number.getText(), status.getText(),rate.getText(),Integer.parseInt(ownerid.getText()));
           loadCar();
    }//GEN-LAST:event_addCarActionPerformed

    private void carnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carnameActionPerformed

    }//GEN-LAST:event_carnameActionPerformed

    private void owneridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_owneridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_owneridActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerforme
//        loadCar(Integer.parseInt(searchField.getText()));
        filterTable(searchField.getText());
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void loadAllCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadAllCarActionPerformed
        loadCar();
    }//GEN-LAST:event_loadAllCarActionPerformed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        filterTable(searchField.getText());
    }//GEN-LAST:event_searchFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADEPanel;
    private javax.swing.JButton SearchButton;
    private javax.swing.JButton addCar;
    private javax.swing.JTextField carDate;
    private javax.swing.JTextField carId;
    private javax.swing.JTextField carbrand;
    private javax.swing.JTextField carname;
    private javax.swing.JTextField color;
    private javax.swing.JButton deleteCar;
    private javax.swing.JButton editCar;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loadAllCar;
    private javax.swing.JTextField number;
    private javax.swing.JTextField ownerid;
    private javax.swing.JTextField rate;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
