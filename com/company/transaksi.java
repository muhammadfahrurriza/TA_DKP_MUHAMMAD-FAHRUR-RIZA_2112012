package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.StringTokenizer;
import java.util.Locale;

public class transaksi  {
    private JComboBox CBNamaBrg;
    private JTextField TxtHargaBarang;
    private JTextField TxtJBeli;
    private JTextField TxtJmlHarga;
    private JTextField TxtJmlBayar;
    private JTextField TxtJmlKembalian;
    private JButton JButton1;
    private JButton JButton2;
    private JButton Button3;
    private JLabel JLabel1;
    private JLabel JLabel2;
    private JLabel JLabel3;
    private JLabel JLabel4;
    private JLabel JLabel5;
    private JLabel JLabel6;
    private JPanel panel;
    private JLabel JlabelHeader;

    public StringTokenizer token;
    public String gantiformat="";
    public String nm_barang="";
    public long harga_brg;
    public long jumlah_hrg;
    public long kembalian;
    public long jumlah_byr;
    public int jml_beli;

    public static void main(String[] args) {
        JFrame frame = new JFrame("DKP GUI");
        frame.setContentPane(new transaksi().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 300);
        frame.setResizable(true);
    }

    public transaksi () {

        CBNamaBrg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nm_barang=(String)CBNamaBrg.getSelectedItem();
                if (nm_barang=="Urea"){
                    harga_brg=3000000;
                }else if (nm_barang=="ZA"){
                    harga_brg=250000;
                }else if (nm_barang=="NPK"){
                    harga_brg=500000;
                }else if (nm_barang=="SP-36"){
                    harga_brg=350000;
                }else if (nm_barang=="Organik"){
                    harga_brg=250000;
                }

                gantiformat=NumberFormat.getNumberInstance(Locale.ENGLISH).format(harga_brg);
                token=new StringTokenizer(gantiformat,".");
                gantiformat=token.nextToken();
                gantiformat=gantiformat.replace(",",".");
                TxtHargaBarang.setText(gantiformat);
            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jml_beli=Integer.parseInt(TxtJBeli.getText());

                jumlah_hrg=jml_beli*harga_brg;

                gantiformat=NumberFormat.getNumberInstance(Locale.ENGLISH).format(jumlah_hrg);
                token=new StringTokenizer(gantiformat,".");
                gantiformat=token.nextToken();
                gantiformat=gantiformat.replace(",",".");
                TxtJmlHarga.setText(gantiformat);
            }
        });
        TxtJmlBayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jumlah_byr=Long.parseLong(TxtJmlBayar.getText());

                kembalian=jumlah_byr-jumlah_hrg;

                gantiformat=NumberFormat.getNumberInstance(Locale.ENGLISH).format(jumlah_byr);
                token=new StringTokenizer(gantiformat,".");
                gantiformat=token.nextToken();
                gantiformat=gantiformat.replace(",",".");
                TxtJmlBayar.setText(gantiformat);

                gantiformat=NumberFormat.getNumberInstance(Locale.ENGLISH).format(kembalian);
                token=new StringTokenizer(gantiformat,".");
                gantiformat=token.nextToken();
                gantiformat=gantiformat.replace(",",".");
                TxtJmlKembalian.setText(gantiformat);
            }
        });
        JButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CBNamaBrg.setSelectedIndex(-1);
                TxtHargaBarang.setText("");
                TxtJBeli.setText("");
                TxtJmlBayar.setText("");
                TxtJmlHarga.setText("");
                TxtJmlKembalian.setText("");
            }
        });
        JButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}