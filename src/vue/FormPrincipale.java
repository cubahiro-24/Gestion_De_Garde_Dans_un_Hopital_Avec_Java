
package vue;

import java.awt.event.*;

import javax.swing.*;



public class FormPrincipale extends JFrame implements ActionListener{
    JMenuBar bar;
    JMenu mdb,mdt,mtr;
    JMenuItem mich,mimal,mitr;
    
    public FormPrincipale()
    {
        bar=new JMenuBar();
        mdb=new JMenu("Donnees de base");
        mdt=new JMenu("Donnees de traitement");
        mtr=new JMenu("Fichier");
        
        mich=new JMenuItem("Chambre");
        mich.addActionListener(this);
        
        mimal=new JMenuItem("Malade");
        mimal.addActionListener(this);
        
        mitr=new JMenuItem("Quitter");
        mitr.addActionListener(this);
        
        
        bar.add(mdb);
        bar.add(mdt);
        bar.add(mtr);
        
        mdb.add(mich);
        mdb.add(mimal);
        
        mtr.add(mitr);
        this.getContentPane().add(bar);
        bar.setBounds(10,10,400,40);
        this.setLayout(null);
        
        
        }
    public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==mich)
            {
                FormChambre fc =new FormChambre();
                fc.setSize(700,800);
                fc.setTitle("Gestion des chambres");
                fc.setVisible(true);
            }
            else
                if(e.getSource()==mimal)
                {
                    FormMalade fm=new FormMalade();
                    fm.setSize(700,800);
                    fm.setTitle("Gestion des Malades");
                    fm.setVisible(true);
                }
            else
                    if(e.getSource()==mitr)
                    {
                        dispose();
                    }
        
                
        
        
    }
    
}
