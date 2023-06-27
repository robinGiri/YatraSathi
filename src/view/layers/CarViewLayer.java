package view.layers;

import controller.CarController;
import java.sql.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Car;

/**
 *
 * @author ksand
 */
public class CarViewLayer extends javax.swing.JPanel {
    
    /**
     * Creates new form CarViewLayer
     */
    public CarViewLayer() {
        initComponents();
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
                        
                     
                    }
                }
            }
        });
    }
       private void loadCar() {
        CarController carController = new CarController();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addCar = new javax.swing.JButton();
        editCar = new javax.swing.JButton();
        deleteCar = new javax.swing.JButton();
        carId = new javax.swing.JTextField();
        carDate = new javax.swing.JTextField();
        carbrand = new javax.swing.JTextField();
        carname = new javax.swing.JTextField();
        number = new javax.swing.JTextField();
        ownerid = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        rate = new javax.swing.JTextField();
        color = new javax.swing.JTextField();

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

        addCar.setText("Add ");
        addCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarActionPerformed(evt);
            }
        });

        editCar.setText("Edit ");
        editCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCarActionPerformed(evt);
            }
        });

        deleteCar.setText("Delete");
        deleteCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCarActionPerformed(evt);
            }
        });

        carId.setText("jTextField1");

        carDate.setText("jTextField1");

        carbrand.setText("jTextField1");

        carname.setText("jTextField1");
        carname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnameActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(addCar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(deleteCar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(editCar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ownerid, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(carname, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(carbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(carDate, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(carId, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ownerid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addCar)
                            .addComponent(editCar)
                            .addComponent(deleteCar))
                        .addGap(87, 87, 87))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCar;
    private javax.swing.JTextField carDate;
    private javax.swing.JTextField carId;
    private javax.swing.JTextField carbrand;
    private javax.swing.JTextField carname;
    private javax.swing.JTextField color;
    private javax.swing.JButton deleteCar;
    private javax.swing.JButton editCar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField number;
    private javax.swing.JTextField ownerid;
    private javax.swing.JTextField rate;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
