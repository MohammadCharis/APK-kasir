package kasir;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import kasir.koneksi;
import kasir.struk;

public class Transaksi extends javax.swing.JPanel {
     
    DefaultTableModel model;
    
    public Transaksi() {
        initComponents();
        reset();
        inisialisasiTabel();
        kunciTextField();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        tTanggal.setText(sdf.format(new Date()));
        
    tJumlahBayar.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            tJumlahBayarKeyReleased(evt);
        }
    });
    
    }   
    void reset(){       
        tNamaMenu.setText(null);
        tHarga.setText(null);
        tJumlahBeli.setText(null);
        tTotalHarga.setText(null);
        tJumlahBayar.setText(null);
        tKembalian.setText(null);
        tNamaCostumer.setText(null);
    
    }
    void inisialisasiTabel() {
        model = new DefaultTableModel();
        model.addColumn("Nama Menu");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Subtotal");
        tblDetailTransaksi.setModel(model);
    }
    void kunciTextField() {
        tTanggal.setEditable(false);
        tTotalHarga.setEditable(false);
        tKembalian.setEditable(false);
        tHarga.setEditable(false);
        
    }
    void hitungTotal() {
        int total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            String subt = model.getValueAt(i, 3).toString(); // Kolom subtotal
            total += parseRupiah(subt);
        }
        if (model.getRowCount() == 0) {
            tTotalHarga.setText(null);
            tJumlahBayar.setText(null);
            tKembalian.setText(null);
        } else {
            tTotalHarga.setText(formatRupiah(total));
            hitungKembalian(); // Update kembalian hanya kalau ada menu
        }
    }
    
    void hitungKembalian() {
        try {
            int total = parseRupiah(tTotalHarga.getText());
            int bayar = parseRupiah(tJumlahBayar.getText());
            int kembali = bayar - total;
            tKembalian.setText(kembali >= 0 ? formatRupiah(kembali) : null);
        } catch (Exception e) {
            tKembalian.setText(null);
        }
    }
    


    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbClose = new javax.swing.JLabel();
        btnSerch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tNamaCostumer = new javax.swing.JTextField();
        tHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tJumlahBeli = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetailTransaksi = new javax.swing.JTable();
        btnTamnbah = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tTotalHarga = new javax.swing.JTextField();
        tJumlahBayar = new javax.swing.JTextField();
        tKembalian = new javax.swing.JTextField();
        tNamaMenu = new javax.swing.JTextField();
        tTanggal = new javax.swing.JTextField();

        setBackground(new java.awt.Color(229, 229, 229));
        setPreferredSize(new java.awt.Dimension(970, 600));

        jPanel1.setBackground(new java.awt.Color(154, 70, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kasir/foto3.png"))); // NOI18N
        jLabel1.setText("Transaksi");
        jLabel1.setIconTextGap(20);

        lbClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kasir/icons8-close-40.png"))); // NOI18N
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbClose)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbClose)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnSerch.setBackground(new java.awt.Color(51, 51, 51));
        btnSerch.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnSerch.setForeground(new java.awt.Color(255, 255, 255));
        btnSerch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kasir/icons8-search-20 (1).png"))); // NOI18N
        btnSerch.setText("Cari");
        btnSerch.setIconTextGap(0);
        btnSerch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nama Costumer");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nama Menu");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Harga");

        tNamaCostumer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tNamaCostumer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaCostumerActionPerformed(evt);
            }
        });

        tHarga.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tHargaActionPerformed(evt);
            }
        });
        tHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tHargaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Jumlah Beli");

        tJumlahBeli.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tJumlahBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tJumlahBeliActionPerformed(evt);
            }
        });
        tJumlahBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tJumlahBeliKeyPressed(evt);
            }
        });

        tblDetailTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblDetailTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetailTransaksi.setSelectionBackground(new java.awt.Color(154, 70, 30));
        tblDetailTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetailTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetailTransaksi);

        btnTamnbah.setBackground(new java.awt.Color(22, 134, 3));
        btnTamnbah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTamnbah.setForeground(new java.awt.Color(255, 255, 255));
        btnTamnbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kasir/icons8-add-20.png"))); // NOI18N
        btnTamnbah.setText("Tambah");
        btnTamnbah.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnTamnbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTamnbahActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(3, 93, 134));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kasir/icons8-reset-20 (1).png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setBorder(null);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(134, 3, 5));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kasir/icons8-delete-20.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setBorder(null);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(163, 145, 2));
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kasir/icons8-edit-20.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setBorder(null);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnBayar.setBackground(new java.awt.Color(213, 149, 0));
        btnBayar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kasir/icons8-buy-20.png"))); // NOI18N
        btnBayar.setText("Bayar");
        btnBayar.setBorder(null);
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        btnBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBayarKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(151, 91, 63));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total harga");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Jumlah Bayar");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Kembalian");

        tTotalHarga.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tTotalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tTotalHargaActionPerformed(evt);
            }
        });

        tJumlahBayar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tJumlahBayar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tJumlahBayarFocusLost(evt);
            }
        });
        tJumlahBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tJumlahBayarActionPerformed(evt);
            }
        });
        tJumlahBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tJumlahBayarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tJumlahBayarKeyReleased(evt);
            }
        });

        tKembalian.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tKembalianActionPerformed(evt);
            }
        });
        tKembalian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tKembalianKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tKembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(tJumlahBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(tTotalHarga))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tJumlahBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tNamaMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tNamaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaMenuActionPerformed(evt);
            }
        });

        tTanggal.setBackground(new java.awt.Color(51, 51, 51));
        tTanggal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tTanggal.setForeground(new java.awt.Color(255, 255, 255));
        tTanggal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tTanggal.setToolTipText("");
        tTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tTanggalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(btnSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTamnbah, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tHarga)
                            .addComponent(tNamaMenu)
                            .addComponent(tNamaCostumer)
                            .addComponent(tJumlahBeli))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSerch))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNamaCostumer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tJumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTamnbah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHargaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tHargaActionPerformed

    private void tJumlahBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tJumlahBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tJumlahBeliActionPerformed

    private void tTotalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTotalHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tTotalHargaActionPerformed

    private void tJumlahBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tJumlahBayarActionPerformed
       
    }//GEN-LAST:event_tJumlahBayarActionPerformed

    private void tKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKembalianActionPerformed

    }//GEN-LAST:event_tKembalianActionPerformed

    private void tNamaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaMenuActionPerformed

    private void tNamaCostumerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaCostumerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaCostumerActionPerformed

    private void btnTamnbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTamnbahActionPerformed
        // TODO add your handling code here:
        try {
            String nama = tNamaMenu.getText();
            String hargaText = tHarga.getText().replaceAll("[^\\d]", "");
            String jumlahText = tJumlahBeli.getText().replaceAll("[^\\d]", "");

            if (nama.isEmpty() || hargaText.isEmpty() || jumlahText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int harga = Integer.parseInt(hargaText);
            int jumlah = Integer.parseInt(jumlahText);
            int subtotal = harga * jumlah;
            
            model.addRow(new Object[]{ nama, formatRupiah(harga), jumlah, formatRupiah(subtotal) });


            hitungTotal();

            tNamaMenu.setText("");
            tHarga.setText("");
            tJumlahBeli.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Pastikan data yang dimasukkan valid!\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTamnbahActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        // TODO add your handling code here:
        try {
            int total = parseRupiah(tTotalHarga.getText());
            int bayar = parseRupiah(tJumlahBayar.getText());

            if (total == 0 || bayar == 0) {
                JOptionPane.showMessageDialog(this, "Total harga atau jumlah bayar tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (bayar < total) {
                JOptionPane.showMessageDialog(this, "Jumlah bayar kurang dari total harga!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Connection conn = koneksi.konek();
            String sql = "INSERT INTO transaksi (tanggal, total, bayar, kembali, nama_customer) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tTanggal.getText());
            ps.setInt(2, total);
            ps.setInt(3, bayar);
            ps.setInt(4, bayar - total);
            ps.setString(5, tNamaCostumer.getText());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int idTransaksi = -1;
            if (rs.next()) {
                idTransaksi = rs.getInt(1);
            }

            for (int i = 0; i < model.getRowCount(); i++) {
                String namaMenu = model.getValueAt(i, 0).toString();
                String idMenu = ambilIdMenuDariNama(namaMenu);
                int jumlah = Integer.parseInt(model.getValueAt(i, 2).toString());
                int hargaDetail = parseRupiah(model.getValueAt(i, 1).toString());
                int subtotal = parseRupiah(model.getValueAt(i, 3).toString());


                String sqlDetail = "INSERT INTO detail_transaksi (id_transaksi, id_menu, jumlah_beli, harga_tx, subtotal) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement psDetail = conn.prepareStatement(sqlDetail);
                psDetail.setInt(1, idTransaksi);
                psDetail.setString(2, idMenu);
                psDetail.setInt(3, jumlah);
                psDetail.setInt(4, hargaDetail);
                psDetail.setInt(5, subtotal);
                psDetail.executeUpdate();
            }

            struk s = new struk(null, true, 
                tNamaCostumer.getText(), 
                tTanggal.getText(), 
                model, 
                tTotalHarga.getText(), 
                tJumlahBayar.getText(), 
                tKembalian.getText());
            s.setLocationRelativeTo(null); 
            s.setVisible(true);

            reset();
            model.setRowCount(0);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan transaksi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBayarActionPerformed
    String ambilIdMenuDariNama(String namaMenu) {
        try {
            Connection conn = koneksi.konek();
            String query = "SELECT id_menu FROM menu WHERE nama_menu = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, namaMenu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("id_menu");
            } else {
                JOptionPane.showMessageDialog(this, "Menu '" + namaMenu + "' tidak ditemukan di database!", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saat mengambil ID menu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
    
    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        int baris = tblDetailTransaksi.getSelectedRow();
        if (baris >= 0) {
            try {
                String nama = tNamaMenu.getText();
                int harga = Integer.parseInt(tHarga.getText().replaceAll("[^\\d]", ""));
                int jumlah = Integer.parseInt(tJumlahBeli.getText());
                int subtotal = harga * jumlah;

                model.setValueAt(nama, baris, 0);
                model.setValueAt(formatRupiah(harga), baris, 1);
                model.setValueAt(jumlah, baris, 2);
                model.setValueAt(formatRupiah(subtotal), baris, 3);

                tNamaMenu.setText(null);
                tHarga.setText(null);
                tJumlahBeli.setText(null);
                hitungTotal();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Mengubah Data!\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih item di tabel untuk diubah!");
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int baris = tblDetailTransaksi.getSelectedRow();
        if (baris >= 0) {
            model.removeRow(baris);
            hitungTotal();
            // Clear field setelah hapus, kecuali ada baris lain yang dipilih
            if (tblDetailTransaksi.getSelectedRow() == -1) { // Nggak ada baris yang dipilih
                tNamaMenu.setText(null);
                tHarga.setText(null);
                tJumlahBeli.setText(null);
            }
            if (model.getRowCount() == 0) {
                tJumlahBayar.setText(null);
                tKembalian.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih salah satu item yang akan dihapus!");
        }
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tTanggalActionPerformed

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        // TODO add your handling code here:
        removeAll();
        repaint();
        revalidate();

    }//GEN-LAST:event_lbCloseMouseClicked

    private void btnSerchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerchActionPerformed
        boolean close = true ;
        serch cari = new serch(null,close);
        cari.setVisible(true);

    }//GEN-LAST:event_btnSerchActionPerformed

    private void tblDetailTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetailTransaksiMouseClicked
        // TODO add your handling code here:
        int baris = tblDetailTransaksi.getSelectedRow();
        if (baris >= 0) {
            tNamaMenu.setText(model.getValueAt(baris, 0).toString());
            String hargaText = model.getValueAt(baris, 1).toString();
            tHarga.setText(hargaText.isEmpty() ? "0" : String.valueOf(parseRupiah(hargaText)));
            tJumlahBeli.setText(model.getValueAt(baris, 2).toString());
        }
    }//GEN-LAST:event_tblDetailTransaksiMouseClicked

    private void tJumlahBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tJumlahBayarKeyPressed
        // TODO add your handling code here:
        
    
    }//GEN-LAST:event_tJumlahBayarKeyPressed

    private void tJumlahBeliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tJumlahBeliKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tJumlahBeliKeyPressed

    private void tKembalianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tKembalianKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tKembalianKeyPressed

    private void btnBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBayarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBayarKeyPressed

    private void tJumlahBayarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tJumlahBayarFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tJumlahBayarFocusLost

    private void tJumlahBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tJumlahBayarKeyReleased
        // TODO add your handling code here:
        try {
            String bayarText = tJumlahBayar.getText().replaceAll("[^\\d]", "");
            int bayar = bayarText.isEmpty() ? 0 : Integer.parseInt(bayarText);
            int total = tTotalHarga.getText().trim().isEmpty() ? 0 : parseRupiah(tTotalHarga.getText());
            int kembali = bayar - total;

            tJumlahBayar.setText(bayar > 0 ? formatRupiah(bayar) : "");
            tKembalian.setText(kembali >= 0 ? formatRupiah(kembali) : "");
        } catch (NumberFormatException e) {
            tKembalian.setText("");
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid untuk jumlah bayar!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_tJumlahBayarKeyReleased

    private void tHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tHargaKeyTyped
        // TODO add your handling code here: 
    }//GEN-LAST:event_tHargaKeyTyped
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSerch;
    private javax.swing.JButton btnTamnbah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbClose;
    public static javax.swing.JTextField tHarga;
    private javax.swing.JTextField tJumlahBayar;
    private javax.swing.JTextField tJumlahBeli;
    private javax.swing.JTextField tKembalian;
    private javax.swing.JTextField tNamaCostumer;
    public static javax.swing.JTextField tNamaMenu;
    private javax.swing.JTextField tTanggal;
    private javax.swing.JTextField tTotalHarga;
    private javax.swing.JTable tblDetailTransaksi;
    // End of variables declaration//GEN-END:variables
    
    public String formatRupiah(int angka) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id", "ID"));
        symbols.setCurrencySymbol("Rp");
        symbols.setMonetaryDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        DecimalFormat formatter = new DecimalFormat("¤ #,###", symbols);
        return formatter.format(angka);
    }
    
    public int parseRupiah(String text) {
        if (text == null || text.trim().isEmpty()) return 0;
        return Integer.parseInt(text.replaceAll("[^\\d]", ""));
    }
    
}
