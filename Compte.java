public class Compte{
    private String titulair;
    private double  solde;
    public Compte(String titulair){
        this.titulair=titulair;
    }
    public Compte(String titulair,double solde) {
        this.titulair=titulair;
        this.solde=solde;
    }
    public void setTitulair(String titulair){
        this.titulair=titulair;
    }
    public void setSolde(double solde){
        this.solde=solde;
    }
    public String getTitulaire(){
        return "Le titulaire : "+this.titulair;
    }
    public String getSoldeString(){
        return "Solde : "+ this.solde+"DT";
    }
    public double getSolde(){
        return this.solde;
    }
    public void depose(double monatnt){
        this.solde+=monatnt;
        System.out.println("Depot effectué avec succes");
    }
    public void retire(double monatnt) throws NoSoldeException{
        try{
            if(this.solde>monatnt){
                this.solde-=monatnt;
                System.out.println("Depot effectué avec succes");
            }
            else{
                throw new NoSoldeException();
            }
        }catch(NoSoldeException e){
            System.out.println(e);
        }

    }
    public String toString(){
        return getTitulaire()+" ## "+getSoldeString();
    }
}