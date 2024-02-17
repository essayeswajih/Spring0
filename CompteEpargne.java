public class CompteEpargne extends Compte{
    private double benefice;
    public CompteEpargne(String tit, double solde,double benefice){
        super(tit,solde);
        this.benefice=benefice;
    }
    public void setBenefice(double benefice){
        this.benefice=benefice;
    }
    public double getBenefice(){
        return this.benefice;
    }
    public String  toString() {
        return getTitulaire()+" ## "+getSoldeString()+" ## "+ "Benefice : "+this.benefice;
    }
}