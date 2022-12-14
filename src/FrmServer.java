
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class FrmServer extends javax.swing.JFrame {

    public class TuyenNhan extends Thread {

        public void run() {
            try {
                while (true) {
                    String st = gn.Nhan();
                    String[] ds = st.split("[:]");
                    String ipclient = ds[0];
                    String cp = ds[1];
                    if (cp.equals("/tm")) {
                        gn.Gui("XLPT", ipclient, Integer.parseInt(txtport.getText()));
                    /*txtport*/               }
                    if (cp.equals("/ht")) {
                        String iplocal = InetAddress.getLocalHost().getHostAddress();
                        gn.Gui(iplocal, ipclient, Integer.parseInt(txtport.getText()));
                    }
                    if (cp.contains("/+")) {
                        lampheptoan(cp,ipclient);
                    }
                    Runtime r = Runtime.getRuntime();
                    if (cp.equals("/notepad")) {
                        r.exec("notepad");
                    }
                    if (cp.equals("/excel")) {
                        r.exec("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.EXE");
                    }
                    if (cp.equals("/xoso")) {
                        FileReader f = new FileReader("xoso.txt");
                        BufferedReader b = new BufferedReader(f);
                        while (true) {
                            String st1 = b.readLine();
                            if (st1 == "" || st1 == null) {
                                break;
                            }
                            gn.Gui(st1, ipclient, Integer.parseInt(txtport.getText()));
                        }
                    }
                    if (cp.equals("/quit")) {
                        gn.Gui("close", ipclient, Integer.parseInt(txtport.getText()));
                    }

                    list1.add(st);
                    list1.select(list1.getItemCount() - 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void lampheptoan(String cp, String ipclient) {
        try {
            String[] ds = cp.split("[;]");
            int tong=0;
            int max=Integer.parseInt(ds[1]);
            int min=Integer.parseInt(ds[1]);
            int sochusocliengui = ds.length -1;
            for (int i =1;i<ds.length;i++){
                // t??nh t???ng
                tong+=Integer.parseInt(ds[i]);
                
                //tim so lon nhat
                if(max<Integer.parseInt(ds[i])){
                    max=Integer.parseInt(ds[i]);
                }
                
                //t??m s??? nh??? nh???t
                if(min>Integer.parseInt(ds[i])){
                    min=Integer.parseInt(ds[i]);
                }
                
            }
            // tim so lon nhat
            gn.Gui("Tong: "+String.valueOf(tong)
                    , ipclient, Integer.parseInt(txtport.getText()));
            gn.Gui("So lon nhat: "+String.valueOf(max)
                    , ipclient, Integer.parseInt(txtport.getText()));
            gn.Gui("So nho nhat: "+String.valueOf(min)
                    , ipclient, Integer.parseInt(txtport.getText()));
            gn.Gui("So chu so client gui len : "+String.valueOf(sochusocliengui)
                    , ipclient, Integer.parseInt(txtport.getText()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FrmServer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        txtsend = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtip = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtport = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtsend.setText("jTextField1");

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ip Server");

        txtip.setText("127.0.0.1");

        jLabel2.setText("Port");

        txtport.setText("1261");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtsend, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtip, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
GuiNhan gn = new GuiNhan();
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            gn.MoCong(1260);
            TuyenNhan td = new TuyenNhan();
            td.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String ipserver = txtip.getText();
            int cong = Integer.parseInt(txtport.getText());
            String iplocal = InetAddress.getLocalHost().getHostAddress();
            String data = iplocal + ":" + txtsend.getText();
            gn.Gui(data, ipserver, cong);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.List list1;
    private javax.swing.JTextField txtip;
    private javax.swing.JTextField txtport;
    private javax.swing.JTextField txtsend;
    // End of variables declaration//GEN-END:variables
}
