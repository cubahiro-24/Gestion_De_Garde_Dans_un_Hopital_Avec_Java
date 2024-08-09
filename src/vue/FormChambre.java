
package vue;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import controller.FactoryChambre;
import controller.FactoryMalade;
import model.Chambre;


public class FormChambre extends JFrame implements ActionListener {
    JLabel lnumero,lservice,lcategorie,lprix;
    JTextField tnumero,tservice,tprix;
    JComboBox tcategorie;
    JButton badd,bview,bupdate,bdelete,brein, brech;
    String[] categorie={"Salle","VIP","VVIP"};
    
    ArrayList<Chambre> listeChambre=new ArrayList();
    JTable tblEmpl;
    private final DefaultTableModel model;
    Chambre ch=null;
    
    public FormChambre()
    {
        lnumero=new JLabel("Numero");
        lnumero.setBounds(10,30,100,30);
        this.getContentPane().add(lnumero);
        
        tnumero=new JTextField("");
        tnumero.setBounds(120,30,100,30);
        this.getContentPane().add(tnumero);
        
        lservice=new JLabel("Service");
        lservice.setBounds(10,70,100,30);
        this.getContentPane().add(lservice);
        
        tservice=new JTextField("");
        tservice.setBounds(120,70,100,30);
        this.getContentPane().add(tservice);
        
        lcategorie=new JLabel("Categorie");
        lcategorie.setBounds(10,110,100,30);
        this.getContentPane().add(lcategorie);
        
        tcategorie=new JComboBox(categorie);
        tcategorie.setBounds(120,110,100,30);
        this.getContentPane().add(tcategorie);
        
        lprix=new JLabel("Prix");
        lprix.setBounds(10,150,100,30);
        this.getContentPane().add(lprix);
        
        tprix=new JTextField("");
        tprix.setBounds(120,150,100,30);
        tprix.setEditable(false);
        this.getContentPane().add(tprix);
        
        badd=new JButton("Add");
        badd.setBounds(10,220,70,20);
        badd.addActionListener(this);
        this.getContentPane().add(badd);
        
        bview=new JButton("View");
        bview.setBounds(150,220,100,20);
        bview.addActionListener(this);
        this.getContentPane().add(bview);
        
        bupdate=new JButton("Update");
        bupdate.setBounds(290,220,100,20);
        this.getContentPane().add(bupdate);
        
        bdelete=new JButton("Delete");
        bdelete.setBounds(430,220,100,20);
        this.getContentPane().add(bdelete);
        
        brein=new JButton("Reinitialiser");
        brein.setBounds(570,220,120,20);
        brein.addActionListener(this);
        this.getContentPane().add(brein);
        
        brech = new JButton("recherche");
        brech.setBounds(270, 30, 100, 30);
        brech.addActionListener(this);
        this.getContentPane().add(brech);
        
        model=new DefaultTableModel();
        model.addColumn("numero");
        model.addColumn("service");
        model.addColumn("categorie");
        model.addColumn("prix");
        
        this.getContentPane().setLayout(null);       
        
    }
    
    public void afficher()
    {
        model.setRowCount(0);
        listeChambre= FactoryChambre.getChambre();
        for(Chambre cha:listeChambre)
        {
            model.addRow(new Object[]{
                                        cha.getNumero(),cha.getService(),cha.getCategorie(),cha.getPrix()});
        }
        tblEmpl=new JTable(model);
        JScrollPane p=new JScrollPane(tblEmpl);
        p.setBounds(60,420,600,200);
        this.getContentPane().add(p);
        
    }
    
    public void effacer()
    {
        tnumero.setText("");
        tservice.setText("");
        tprix.setText("");    
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==badd)
        {
            int num= Integer.parseInt(tnumero.getText());
            String serv= tservice.getText();
            String cat=String.valueOf(tcategorie.getSelectedItem());
            int prix=0;
           
            switch (cat) {
                case "Salle" -> prix=10000;
                case "VIP" -> prix=30000;
                case "VVIP" -> prix=50000;
                default -> {
                }
            }
            tprix.setText(String.valueOf(prix));
            
                            
           
            ch= new Chambre(num,serv,cat,prix);
            
            
            
            //listeCours.add(cour);
            FactoryChambre.insererChambre(ch);
        } else if(e.getSource()==bview)
            {
                afficher();
        } else if(e.getSource()==brein)
            {
                    effacer();           
        } else if(e.getSource()==brech)
            {
                recherche();
            }
        
        
    }
    
    public void recherche(){
        String rch = tnumero.getText();
            ch = FactoryChambre.getRechC(rch);
            if (ch != null) {
                tnumero.setText(String.valueOf(ch.getNumero()));
                tservice.setText(ch.getService());
                tcategorie.setSelectedItem(ch.getCategorie());
                tprix.setText(String.valueOf(ch.getPrix()));
    }
    }
    
    
    
    
}
