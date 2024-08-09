/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package controller;
import model.Malade;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FactoryMalade {
    
    private static Connection conn=null;
    private static Statement stm;
    private static PreparedStatement pstmet=null;
    private static ResultSet rs=null;
    
    public static void insererMalade(Malade mal)
    {
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into formhopital.malades(nom,prenom,adresse,nationalite,genre) values(?,?,?,?,?)");
            pstmet.setString(1, mal.getNom());
            pstmet.setString(2,mal.getPrenom());
            pstmet.setString(3, mal.getAdresse());
            pstmet.setString(4, mal.getNationalite());
            pstmet.setString(5, mal.getGenre());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    public static Malade getRechM(String ma){
        Malade mal=null;
        try{
            conn= getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from formhopital.malades where id='"+ma+"'");
            if(rs.next()){
                mal=new Malade();
                mal.setId(rs.getInt("id"));
                mal.setNom(rs.getString("nom"));
                mal.setPrenom(rs.getString("prenom"));
                mal.setAdresse(rs.getString("adresse"));
                mal.setNationalite(rs.getString("nationalite"));
                mal.setGenre(rs.getString("genre"));
                mal.setMalCh(rs.getInt("MalCh"));
            }
            conn.close();
            stm.close();
            
        }catch(Exception ex){
            return null;
        }
        return mal;
    }
    
    public static ArrayList<Malade> getMalade(){
        ArrayList<Malade> lic=new ArrayList();
        Malade mal=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from formhopital.malades");
            while(rs.next())
            {
                mal=new Malade();
                mal.setNom(rs.getString("nom"));
                mal.setPrenom(rs.getString("prenom"));
                mal.setAdresse(rs.getString("adresse"));
                mal.setNationalite(rs.getString("nationalite"));
                mal.setGenre(rs.getString("genre"));
                mal.setMalCh(rs.getInt("MalCh"));
                lic.add(mal);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
    
    public static void DeleteMalde(Malade u){
        //Malade empl=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from formhopital.malades where id='"+u.getId()+"'";
            stm.executeUpdate(req);
            conn.close();
            //stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
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
