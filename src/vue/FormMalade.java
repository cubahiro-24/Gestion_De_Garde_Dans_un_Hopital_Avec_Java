package vue;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;
import controller.*;

public class FormMalade extends JFrame implements ActionListener{
    JLabel lnom, lprenom, ladresse, lnationalite, lgenre, lchambre;
    JTextField tnom, tprenom, tadresse, tid;
    JComboBox tnationalite, tchambre;
    JRadioButton genre1, genre2;
    JButton badd, bview, bupdate, bdelete, brein, brech;
    String[] nation = {"France", "Burundi", "Rwanda"};
    ArrayList<Malade> listeMalade = new ArrayList<>();
    JTable tblEmpl;
    private final DefaultTableModel model;
    Malade malad = null;
    int index = 0;
    ArrayList<Chambre> listeChambre = new ArrayList<>();

    public FormMalade() {
        lnom = new JLabel("Nom");
        lnom.setBounds(10, 70, 100, 30);
        this.getContentPane().add(lnom);

        tnom = new JTextField("");
        tnom.setBounds(120, 70, 100, 30);
        this.getContentPane().add(tnom);

        brech = new JButton("recherche");
        brech.setBounds(230, 70, 100, 30);
        brech.addActionListener(this);
        this.getContentPane().add(brech);
        tid = new JTextField("");
        tid.setBounds(340, 110, 100, 30);
        this.getContentPane().add(tid);

        lprenom = new JLabel("Prenom");
        lprenom.setBounds(10, 110, 100, 30);
        this.getContentPane().add(lprenom);

        tprenom = new JTextField("");
        tprenom.setBounds(120, 110, 100, 30);
        this.getContentPane().add(tprenom);

        ladresse = new JLabel("Adresse");
        ladresse.setBounds(10, 150, 100, 30);
        this.getContentPane().add(ladresse);

        tadresse = new JTextField("");
        tadresse.setBounds(120, 150, 100, 30);
        this.getContentPane().add(tadresse);

        lnationalite = new JLabel("Nationalite");
        lnationalite.setBounds(10, 190, 100, 30);
        this.getContentPane().add(lnationalite);

        tnationalite = new JComboBox(nation);
        tnationalite.setBounds(120, 190, 100, 30);
        this.getContentPane().add(tnationalite);

        lgenre = new JLabel("Genre");
        lgenre.setBounds(10, 230, 100, 30);
        this.getContentPane().add(lgenre);

        genre1 = new JRadioButton("M");
        genre1.setBounds(130, 230, 40, 30);
        this.getContentPane().add(genre1);

        genre2 = new JRadioButton("F");
        genre2.setBounds(190, 230, 40, 30);
        this.getContentPane().add(genre2);

        ButtonGroup g = new ButtonGroup();
        g.add(genre1);
        g.add(genre2);

        lchambre = new JLabel("Chambre");
        lchambre.setBounds(10, 340, 100, 30);
        this.getContentPane().add(lchambre);

        tchambre = new JComboBox();
        tchambre.setBounds(120, 340, 100, 30);
        listeChambre = FactoryChambre.getChambre();
        for (Chambre ch : listeChambre) {
            tchambre.addItem(ch.getIdchambre());
        }

        tchambre.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                index = tchambre.getSelectedIndex();
            }
        });

        this.getContentPane().add(tchambre);

        badd = new JButton("Add");
        badd.setBounds(10, 290, 100, 20);
        badd.addActionListener(this);
        this.getContentPane().add(badd);

        bview = new JButton("View");
        bview.setBounds(150, 290, 100, 20);
        bview.addActionListener(this);
        this.getContentPane().add(bview);

        bupdate = new JButton("Update");
        bupdate.setBounds(290, 290, 100, 20);
        this.getContentPane().add(bupdate);

        bdelete = new JButton("Delete");
        bdelete.setBounds(430, 290, 100, 20);
        bdelete.addActionListener(this);
        this.getContentPane().add(bdelete);

        brein = new JButton("Reinitialiser");
        brein.setBounds(570, 290, 100, 20);
        brein.addActionListener(this);
        this.getContentPane().add(brein);

        model = new DefaultTableModel();
        model.addColumn("nom");
        model.addColumn("prenom");
        model.addColumn("adresse");
        model.addColumn("nationalite");
        model.addColumn("genre");
        model.addColumn("chambre");

        this.getContentPane().setLayout(null);
    }

    public void afficher() {
        model.setRowCount(0);
        listeMalade = FactoryMalade.getMalade();
        for (Malade mal : listeMalade) {
            model.addRow(new Object[]{
                mal.getNom(), mal.getPrenom(), mal.getAdresse(), mal.getNationalite(), mal.getGenre()
            });
        }
        tblEmpl = new JTable(model);
        JScrollPane p = new JScrollPane(tblEmpl);
        p.setBounds(50, 420, 400, 400);
        this.getContentPane().add(p);
    }

    public void effacer() {
        tid.setText("");
        tnom.setText("");
        tprenom.setText("");
        tadresse.setText("");
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == badd) {
            String nom = tnom.getText();
            String prenom = tprenom.getText();
            String adr = tadresse.getText();
            String nat = String.valueOf(tnationalite.getSelectedItem());
            int chamb = listeChambre.get(index).getNumero();
            String genr = "";

            if (genre1.isSelected()) {
                genr = genre1.getText();
            } else if (genre2.isSelected()) {
                genr = genre2.getText();
            }

            malad = new Malade(nom, prenom, adr, nat, genr, chamb);
            FactoryMalade.insererMalade(malad);
        } else if (e.getSource() == bview) {
            afficher();
        } else if (e.getSource() == brein) {
            effacer();
        } else if (e.getSource() == brech) {
            String rch = tid.getText();
            malad = FactoryMalade.getRechM(rch);
            if (malad != null) {
                tnom.setText(malad.getNom());
                tprenom.setText(malad.getPrenom());
                tadresse.setText(malad.getAdresse());
                tnationalite.setSelectedItem(malad.getNationalite());
                String truc = getinfo(malad.getMalCh());
                tchambre.setSelectedItem(truc);

                if (malad.getGenre().equalsIgnoreCase(genre1.getText())) {
                    genre1.setSelected(true);
                } else {
                    genre2.setSelected(true);
                }
            }
        } else if (e.getSource()==bdelete){
            if(malad !=null){
                String msg="Voulez-vous reelement supprimer "+malad.getId()+" de la liste des malades";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    FactoryMalade.DeleteMalde(malad);
                    afficher();
                    effacer();
                }
            }
        }
    }

    String getinfo(int num) {
        String nume = "";
        for (Chambre c : listeChambre) {
            if (c.getNumero()==(num)){
                nume = c.getCategorie();
                break;
            }
        }
        return nume;
    }
}
