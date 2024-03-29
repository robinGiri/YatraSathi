/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.layers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.BillController;
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
import model.*;
import controller.*;
public class BillViewLayer extends javax.swing.JPanel {
    BillController billController = new BillController();
    Bill bill = new Bill();
    RentalController rentalController = new RentalController();
    Rental rental = new Rental();
    CarController carController = new CarController();
    UsersController usersController = new UsersController();
    Car car = new Car();
    User user = new User();
    int idInt;
    //Load the bills form the table and create the bill  
   private int CreateBill(int id){
        BillDetailsController billDetailsController = new BillDetailsController();
        BillDetails billDetails = new BillDetails();
        billDetails = billDetailsController.getBillDetailsByBillNumber(id);       
        txtBillno.setText(String.valueOf(id));
        txtDate.setText(billDetails.getBillDate().toString());
        txtCustomerName.setText(billDetails.getCustomerName());
        txtCarName.setText(billDetails.getCarName());
        txtCarRate.setText(String.valueOf(billDetails.getCarRate()));
        txtRentalDate.setText(billDetails.getRentalDate().toString());
        txtReturnDate.setText(billDetails.getReturnDate().toString());
        txtTotalAmount.setText(String.valueOf(billDetails.getTotalAmount()));
        txtDiscountAmount.setText(String.valueOf(billDetails.getDiscountAmount()));
        txtTotal.setText(String.valueOf(billDetails.getTotalAfterDiscount()));
        
        return 0;
    }
    public BillViewLayer() {
        initComponents();
        ADEPanel.setVisible(true);
        loadBill();
         jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Retrieve data from the selected row
                        String id = jTable1.getValueAt(selectedRow, 0).toString();
                        idInt = Integer.parseInt(id);
                        CreateBill(idInt);
                        ADEPanel.setVisible(true);
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
//                searchPanel.setVisible(true);
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
private void generatePDF(String convertedString) {
    try {
        // Create a new PDF document
        Document document = new Document(PageSize.A4);

        // Set the output file path
        PdfWriter.getInstance(document, new FileOutputStream(convertedString));

        // Open the document
        document.open();

        // Add the BillPanel content to the document
        document.add(billPanelToPdf());

        // Close the document
        document.close();

        System.out.println("PDF created successfully.");

    } catch (DocumentException | FileNotFoundException e) {
        e.printStackTrace();
    }
}

// Convert the BillPanel to a PdfPTable and return it
private PdfPTable billPanelToPdf() {
    PdfPTable billPanelTable = new PdfPTable(2);

    // Add bill details to the table
    billPanelTable.addCell("Bill no:");
    billPanelTable.addCell(txtBillno.getText());

    billPanelTable.addCell("Date:");
    billPanelTable.addCell(txtDate.getText());

    billPanelTable.addCell("Customer Name:");
    billPanelTable.addCell(txtCustomerName.getText());

    billPanelTable.addCell("Car Name:");
    billPanelTable.addCell(txtCarName.getText());

    billPanelTable.addCell("Car Rate:");
    billPanelTable.addCell(txtCarRate.getText());

    billPanelTable.addCell("Rental date:");
    billPanelTable.addCell(txtRentalDate.getText());

    billPanelTable.addCell("Return date:");
    billPanelTable.addCell(txtReturnDate.getText());

    billPanelTable.addCell("Total Amount:");
    billPanelTable.addCell(txtTotalAmount.getText());

    billPanelTable.addCell("Discount Amount:");
    billPanelTable.addCell(txtDiscountAmount.getText());

    billPanelTable.addCell("Total:");
    billPanelTable.addCell(txtTotal.getText());

    return billPanelTable;
}


//Load the bills in the table
       private void loadBill() {
        BillController billController = new BillController();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        for (Bill bill : billController.listBills()) {
            Object[] row = {
                    bill.getBillNo(),
                    bill.getCarId(),
                    bill.getDate(),
                    bill.getCustomerId()
            };
            model.addRow(row);
        }

                        
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ADEPanel = new javax.swing.JPanel();
        billPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBillno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCarName = new javax.swing.JLabel();
        txtCarRate = new javax.swing.JLabel();
        txtRentalDate = new javax.swing.JLabel();
        txtReturnDate = new javax.swing.JLabel();
        txtTotalAmount = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDiscountAmount = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchButton1 = new javax.swing.JButton();
        printPDF = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Bill no", "Car Id", "Date", "Total amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        billPanel.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Bill no:");

        txtBillno.setText("{BillNo}");

        jLabel2.setText("Date:");

        txtDate.setText("{Date}");

        jLabel5.setText("Car Name:");

        jLabel6.setText("Car Rate:");

        jLabel7.setText("Rental date:");

        jLabel8.setText("Return date:");

        jLabel10.setText("Total Amount:");

        txtCarName.setText("{CarName}");

        txtCarRate.setText("{CarRate}");

        txtRentalDate.setText("{RentalDate}");

        txtReturnDate.setText("{ReturnDate}");

        txtTotalAmount.setText("{TotalAmount}");

        jLabel11.setText("Discount Amount:");

        txtDiscountAmount.setText("{DiscountAmount}");

        jLabel12.setText("Total:");

        txtTotal.setText("{Total}");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel3.setBackground(new java.awt.Color(153, 153, 255));
        jLabel3.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("YatraSathi: Rent My Car");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel9.setText("Customer Name:");

        txtCustomerName.setText("{CustomerName}");

        javax.swing.GroupLayout billPanelLayout = new javax.swing.GroupLayout(billPanel);
        billPanel.setLayout(billPanelLayout);
        billPanelLayout.setHorizontalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBillno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(141, 141, 141)
                                .addComponent(txtReturnDate))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(150, 150, 150)
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCarRate)
                                    .addComponent(txtCarName)))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(142, 142, 142)
                                .addComponent(txtRentalDate))))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtCustomerName)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(25, 25, 25)
                                .addComponent(txtTotalAmount))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiscountAmount))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(76, 76, 76)
                                .addComponent(txtTotal)))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()

                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        billPanelLayout.setVerticalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBillno))
                .addGap(2, 2, 2)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCustomerName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCarName))
                .addGap(36, 36, 36)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCarRate))
                .addGap(40, 40, 40)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtRentalDate))
                .addGap(40, 40, 40)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtReturnDate))
                .addGap(36, 36, 36)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotalAmount))
                .addGap(27, 27, 27)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtDiscountAmount))
                .addGap(18, 18, 18)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18))
        );

        searchButton1.setText("Search");
        searchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(searchButton1)
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton1))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        printPDF.setText("Print");
        printPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ADEPanelLayout = new javax.swing.GroupLayout(ADEPanel);
        ADEPanel.setLayout(ADEPanelLayout);
        ADEPanelLayout.setHorizontalGroup(
            ADEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ADEPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(ADEPanelLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(printPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(ADEPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(billPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ADEPanelLayout.setVerticalGroup(
            ADEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADEPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(billPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(printPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ADEPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ADEPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

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
                generatePDF(convertedString+"\\\\bill.pdf");
                
          }
 
    }//GEN-LAST:event_printPDFActionPerformed

    private void searchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADEPanel;
    private javax.swing.JPanel billPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton printPDF;
    private javax.swing.JButton searchButton1;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel txtBillno;
    private javax.swing.JLabel txtCarName;
    private javax.swing.JLabel txtCarRate;
    private javax.swing.JLabel txtCustomerName;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtDiscountAmount;
    private javax.swing.JLabel txtRentalDate;
    private javax.swing.JLabel txtReturnDate;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JLabel txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
