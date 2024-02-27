import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main (String[] args) throws NoSoldeException{
        Banque atb = new Banque("ATB");
        Compte c1 = new Compte("wajih",400);
        Compte c2 = new Compte("karim",4023);
        Compte c3 = new CompteEpargne("Samir", 300, 0.05);
        Compte c4 = new CompteEpargne("Salah", 400, 0.05);
        Compte c5 = new CompteEpargne("Salah", 400, 0.07);
        c1.retire(500);
        c1.depose(399);
        atb.addCompte(c1);
        atb.addCompte(c2);
        atb.addCompte(c3);
        atb.addCompte(c4);
        atb.addCompte(c5);
        System.out.println(atb);
        getComptes();
        SetComptes();
    }
    private static void SetComptes() {
        //ArrayList<Compte> comptes = new ArrayList<Compte>();
        String url, user, pwd;
        Connection c = null;
        PreparedStatement prepst;
        url="jdbc:postgresql://localhost:9999/banque";
        user="postgres";
        pwd="wajih07D2";
        try{
            c = DriverManager.getConnection(url, user, pwd);
            c.setAutoCommit(false);
            System.out.println( "Connecting to database..." );
            prepst = c.prepareStatement("INSERT INTO client (nom,age) VALUES(?,?) " );
            
            prepst.setString(1, "ali");
            prepst.setInt(2, 24);
            
            prepst.executeUpdate();
            prepst.close();
            c.commit();
            c.close();
        }
        catch(Exception e){
            System.err.println(e.getClass().getName()  + ": "+ e.getMessage());
            System.exit(0);
        }
        
    }
    static void getComptes(){
        String url, user, pwd;
        Connection c = null;
        Statement stmt = null;
        url="jdbc:postgresql://localhost:9999/banque";
        user="postgres";
        pwd="wajih07D2";
        try{
            c =  DriverManager.getConnection(url, user, pwd);
            c.setAutoCommit(false);
            System.out.println( "Connecting to database..." );

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client");
            while (rs.next()) {
                int id_client=rs.getInt("id");
                String nom=rs.getString("nom");
                int age = rs.getInt("age");
                System.out.println("ID = "+id_client);
                System.out.println( "Name = " + nom );
                System.out.println( "Age = " + age  );
                System.out.println();
            }
            rs.close();
            stmt.close();
        }
        catch(Exception e){
            System.err.println(e.getClass().getName()  + ": "+ e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
