
package controller;

import static controller.FactoryMalade.getConnection;
import model.Chambre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Malade;




public class FactoryChambre {
    private static Connection conn=null;
    private static Statement stm;
    private static PreparedStatement pstmet=null;
    private static ResultSet rs=null;
    
    public static void insererChambre(Chambre ch)
    {
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into formhopital.chambres(numero,service,categorie,prix) values(?,?,?,?)");
            pstmet.setInt(1,ch.getNumero());
            pstmet.setString(2, ch.getService());
            pstmet.setString(3,ch.getCategorie());
            pstmet.setInt(4, ch.getPrix());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    public static Chambre getRechC(String cha){
        Chambre cham=null;
        try{
            conn= getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from formhopital.chambres where numero='"+cha+"'");
            if(rs.next()){
                cham=new Chambre();
                cham.setNumero(rs.getInt("numero"));
                cham.setService(rs.getString("service"));
                cham.setCategorie(rs.getString("categorie"));
                cham.setPrix(rs.getInt("prix"));
            }
            conn.close();
            stm.close();
            
        }catch(Exception ex){
            return null;
        }
        return cham;
    }
    
    public static ArrayList<Chambre> getChambre(){
        ArrayList<Chambre> lic=new ArrayList();
        Chambre ch=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from formhopital.chambres");
            while(rs.next())
            {
                ch=new Chambre();
                ch.setNumero(rs.getInt("numero"));
                ch.setService(rs.getString("service"));
                ch.setCategorie(rs.getString("categorie"));
                ch.setPrix(rs.getInt("prix"));
                lic.add(ch);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
    
    public static Connection getConnection(){
        String serveur="localhost";
        int port=3306;
        String database="formhopital";
        String username="root";
        String password="";
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url="jdbc:mysql://" +serveur+":"+port+"/"+database+"?characterEncoding=latin1";
            conn=DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            return conn;
        } catch(Exception e){
            System.out.println("ERREUR");
            e.printStackTrace();
            return null;
            
        }
        
    }
    
    
    
}
