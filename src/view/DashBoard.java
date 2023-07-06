package view;

public class DashBoard extends javax.swing.JFrame {

    public DashBoard() {
        initComponents();
        dashBoardLayer1.setVisible(true);
        carViewLayer1.setVisible(false);
        rentViewLayer1.setVisible(false);
        clientViewLayer1.setVisible(false);
        billViewLayer1.setVisible(false);
    }
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NavBar = new javax.swing.JPanel();
        Bill = new javax.swing.JButton();
        DashBoard = new javax.swing.JButton();
        Rent = new javax.swing.JButton();
        Cars = new javax.swing.JButton();
        Clients = new javax.swing.JButton();
        DisplayLayer = new javax.swing.JLayeredPane();
        dashBoardLayer1 = new view.layers.DashBoardLayer();
        billViewLayer1 = new view.layers.BillViewLayer();
        carViewLayer1 = new view.layers.CarViewLayer();
        clientViewLayer1 = new view.layers.ClientViewLayer();
        rentViewLayer1 = new view.layers.RentViewLayer();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Bill.setBackground(new java.awt.Color(232, 224, 224));
        Bill.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Bill.setText("Bill");
        Bill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillActionPerformed(evt);
            }
        });

        DashBoard.setBackground(new java.awt.Color(232, 224, 224));
        DashBoard.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        DashBoard.setText("DashBoard");
        DashBoard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DashBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashBoardActionPerformed(evt);
            }
        });

        Rent.setBackground(new java.awt.Color(232, 224, 224));
        Rent.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Rent.setText("Rent");
        Rent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Rent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentActionPerformed(evt);
            }
        });

        Cars.setBackground(new java.awt.Color(232, 224, 224));
        Cars.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Cars.setText("Cars");
        Cars.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Cars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarsActionPerformed(evt);
            }
        });

        Clients.setBackground(new java.awt.Color(232, 224, 224));
        Clients.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Clients.setText("Client");
        Clients.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Clients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavBarLayout = new javax.swing.GroupLayout(NavBar);
        NavBar.setLayout(NavBarLayout);
        NavBarLayout.setHorizontalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NavBarLayout.createSequentialGroup()
                        .addComponent(DashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavBarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clients, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cars, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        NavBarLayout.setVerticalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Cars, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Clients, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Rent, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        DisplayLayer.setLayer(dashBoardLayer1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayer.setLayer(billViewLayer1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayer.setLayer(carViewLayer1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayer.setLayer(clientViewLayer1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayer.setLayer(rentViewLayer1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DisplayLayerLayout = new javax.swing.GroupLayout(DisplayLayer);
        DisplayLayer.setLayout(DisplayLayerLayout);
        DisplayLayerLayout.setHorizontalGroup(
            DisplayLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DisplayLayerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(billViewLayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(DisplayLayerLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(carViewLayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rentViewLayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientViewLayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(762, Short.MAX_VALUE))
            .addGroup(DisplayLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DisplayLayerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(dashBoardLayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        DisplayLayerLayout.setVerticalGroup(
            DisplayLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayLayerLayout.createSequentialGroup()
                .addGroup(DisplayLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DisplayLayerLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(carViewLayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DisplayLayerLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(DisplayLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rentViewLayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientViewLayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(billViewLayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(DisplayLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DisplayLayerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(dashBoardLayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(NavBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DisplayLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DisplayLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(NavBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RentActionPerformed
        dashBoardLayer1.setVisible(false);
        carViewLayer1.setVisible(false);
        rentViewLayer1.setVisible(true);
        clientViewLayer1.setVisible(false);
        billViewLayer1.setVisible(false);
    }//GEN-LAST:event_RentActionPerformed

    private void BillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillActionPerformed
        dashBoardLayer1.setVisible(false);
        carViewLayer1.setVisible(false);
        rentViewLayer1.setVisible(false);
        clientViewLayer1.setVisible(false);
        billViewLayer1.setVisible(true);
    }//GEN-LAST:event_BillActionPerformed

    private void ClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientsActionPerformed
        dashBoardLayer1.setVisible(false);
        carViewLayer1.setVisible(false);
        rentViewLayer1.setVisible(false);
        clientViewLayer1.setVisible(true);
        billViewLayer1.setVisible(false);
    }//GEN-LAST:event_ClientsActionPerformed

    private void CarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarsActionPerformed
        dashBoardLayer1.setVisible(false);
        carViewLayer1.setVisible(true);
        rentViewLayer1.setVisible(false);
        clientViewLayer1.setVisible(false);
        billViewLayer1.setVisible(false);
    }//GEN-LAST:event_CarsActionPerformed

    private void DashBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashBoardActionPerformed
        dashBoardLayer1.setVisible(true);
        carViewLayer1.setVisible(false);
        rentViewLayer1.setVisible(false);
        clientViewLayer1.setVisible(false);
        billViewLayer1.setVisible(false);
    }//GEN-LAST:event_DashBoardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bill;
    private javax.swing.JButton Cars;
    private javax.swing.JButton Clients;
    private javax.swing.JButton DashBoard;
    private javax.swing.JLayeredPane DisplayLayer;
    private javax.swing.JPanel NavBar;
    private javax.swing.JButton Rent;
    private view.layers.BillViewLayer billViewLayer1;
    private view.layers.CarViewLayer carViewLayer1;
    private view.layers.ClientViewLayer clientViewLayer1;
    private view.layers.DashBoardLayer dashBoardLayer1;
    private view.layers.RentViewLayer rentViewLayer1;
    // End of variables declaration//GEN-END:variables
}
