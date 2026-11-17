import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormSiswaHogwarts {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Pendaftaran Hogwarts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 5, 5));

        JLabel labelNama = new JLabel("Nama Siswa:");
        JTextField fieldNama = new JTextField();

        JLabel labelKeluarga = new JLabel("Nama Keluarga:");
        JTextField fieldKeluarga = new JTextField();

        JLabel labelUmur = new JLabel("Umur:");
        JTextField fieldUmur = new JTextField();

        JLabel labelGender = new JLabel("Jenis Kelamin:");

        JRadioButton lakiLaki = new JRadioButton("Laki-laki");
        JRadioButton perempuan = new JRadioButton("Perempuan");

        ButtonGroup grupGender = new ButtonGroup();
        grupGender.add(lakiLaki);
        grupGender.add(perempuan);

        JPanel panelGender = new JPanel();
        panelGender.setLayout(new FlowLayout());

        panelGender.add(lakiLaki);
        panelGender.add(perempuan);

        JLabel labelAsrama = new JLabel("Asrama:");

        String[] daftarAsrama = {
            "Gryffindor",
            "Slytherin",
            "Ravenclaw",
            "Hufflepuff"
        };

        JComboBox<String> pilihanAsrama =
            new JComboBox<>(daftarAsrama);

        JLabel labelMinat = new JLabel("Minat:");

        JCheckBox membaca = new JCheckBox("Membaca");
        JCheckBox quidditch = new JCheckBox("Quidditch");
        JCheckBox ramuan = new JCheckBox("Ramuan");

        JPanel panelMinat = new JPanel();
        panelMinat.setLayout(new FlowLayout());

        panelMinat.add(membaca);
        panelMinat.add(quidditch);
        panelMinat.add(ramuan);

        JButton tombolDaftar = new JButton("Daftar");
        JButton tombolReset = new JButton("Reset");

        panel.add(labelNama);
        panel.add(fieldNama);

        panel.add(labelKeluarga);
        panel.add(fieldKeluarga);

        panel.add(labelUmur);
        panel.add(fieldUmur);

        panel.add(labelGender);
        panel.add(panelGender);

        panel.add(labelAsrama);
        panel.add(pilihanAsrama);

        panel.add(labelMinat);
        panel.add(panelMinat);

        panel.add(tombolDaftar);
        panel.add(tombolReset);


        tombolDaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nama = fieldNama.getText();
                String keluarga = fieldKeluarga.getText();
                String umur = fieldUmur.getText();

                String gender = "Belum dipilih";

                if (lakiLaki.isSelected()) {
                    gender = "Laki-laki";
                } else if (perempuan.isSelected()) {
                    gender = "Perempuan";
                }

                String asrama = (String)
                    pilihanAsrama.getSelectedItem();

                String minat = "";

                if (membaca.isSelected()) {
                    minat += "Membaca ";
                }

                if (quidditch.isSelected()) {
                    minat += "Quidditch ";
                }

                if (ramuan.isSelected()) {
                    minat += "Ramuan ";
                }

                if (minat.isEmpty()) {
                    minat = "Tidak ada";
                }

                JOptionPane.showMessageDialog(frame,
                    "Pendaftaran Berhasil!\n\n"
                    + "Nama: " + nama + "\n"
                    + "Keluarga: " + keluarga + "\n"
                    + "Umur: " + umur + "\n"
                    + "Jenis Kelamin: " + gender + "\n"
                    + "Asrama: " + asrama + "\n"
                    + "Minat: " + minat + "\n"
                );
            }
        });

        tombolReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fieldNama.setText("");
                fieldKeluarga.setText("");
                fieldUmur.setText("");

                grupGender.clearSelection();

                pilihanAsrama.setSelectedIndex(0);

                membaca.setSelected(false);
                quidditch.setSelected(false);
                ramuan.setSelected(false);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}