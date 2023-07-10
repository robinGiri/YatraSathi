package view.layers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.CarController;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFileChooser;
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
        
        // This line will see if the user is touching the list of table and load the data of the selected row in the fields;
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
          
        //to deselect if it is not clicked in the list
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
    //filter the table from the search bar
    private void filterTable(String regex) {
    try {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());
        sorter.setRowFilter(RowFilter.regexFilter(regex));
        jTable1.setRowSorter(sorter);
    } catch (PatternSyntaxException ex) {
        // Handle invalid regex pattern
        System.err.println("Invalid regex pattern: " + ex.getMessage());
    }
}   
// print the pdf formated table 
    private void generatePDF(String convertedString) {
    try {
        // Create a new PDF document
        Document document = new Document(PageSize.A4);

        // Set the output file path
        PdfWriter.getInstance(document, new FileOutputStream(convertedString));

        // Open the document
        document.open();

        // Create a table with the same number of columns as the Swing table
        PdfPTable pdfTable = new PdfPTable(jTable1.getColumnCount());

        // Add table headers
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            pdfTable.addCell(jTable1.getColumnName(i));
        }

        // Add table data
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                pdfTable.addCell(jTable1.getValueAt(i, j).toString());
            }
        }

        // Add the table to the document
        document.add(pdfTable);

        // Close the document
        document.close();

        System.out.println("PDF created successfully.");

    } catch (DocumentException | FileNotFoundException e) {
        e.printStackTrace();
    }
}
//Load the car in the table
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
        printPDF = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 402));

        printPDF.setText("Print");
        printPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printPDFActionPerformed(evt);
            }
        });
        add(printPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 437, -1, -1));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton)
                .addGap(32, 32, 32))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 320, -1));

        carDate.setText("CarDate");

        carId.setText("CarId");

        carname.setText("CarName");
        carname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnameActionPerformed(evt);
            }
        });

        carbrand.setText("CarBrand");

        number.setText("Number");

        ownerid.setText("OwnerId");
        ownerid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                owneridActionPerformed(evt);
            }
        });

        status.setText("Status");

        rate.setText("Rate");

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
                .addContainerGap(14, Short.MAX_VALUE)
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
                .addGap(19, 19, 19)
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

        add(ADEPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 460, -1));
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

    private void printPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printPDFActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        Component frame = null;

        // Show the file chooser dialog
        int result = fileChooser.showOpenDialog(frame);
            
            // Handle the selected folder
            if (result == JFileChooser.APPROVE_OPTION) {
                String selectedFolder = fileChooser.getSelectedFile().getPath();
                String convertedString = selectedFolder.replace("\\", "\\\\");
                generatePDF(convertedString+"\\\\carTable.pdf");
                
            }
       
    }//GEN-LAST:event_printPDFActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed

    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        filterTable(searchField.getText());
    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADEPanel;
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
    private javax.swing.JButton printPDF;
    private javax.swing.JTextField rate;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
