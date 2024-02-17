import java.util.ArrayList;
import java.util.List;

public class Banque{
    String name;
    List<Compte> clients;
    public Banque(String name){
        this.name = name;
        this.clients = new ArrayList<Compte>();
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void addCompte(Compte c){
        this.clients.add(c);
    }
    public String Reform(String x,int l){
        
        for(int i = x.length()+3 ;i<l ;i++){
            x+=" ";
        }
        x+="##";
        return x;
    }
    public String toString(){
        System.out.println("");
        String res = "############################ Banque "+this.name+" ############################\n";
        int l=res.length();
        for (int i=0;i<this.clients.size();i++){
            res+=this.Reform("## "+ this.clients.get(i).toString(),l)+"\n";
        }
        return res;
    }
}