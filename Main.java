public class Main {
    public static void main (String[] args) throws NoSoldeException{
        Banque atb = new Banque("ATB");
        Compte c1 = new Compte("wajih",400);
        Compte c2 = new Compte("karim",4023);
        Compte c3 = new CompteEpargne("Samir", 300, 0.05);
        Compte c4 = new CompteEpargne("Salah", 400, 0.05);
        c1.retire(500);
        c1.depose(399);
        atb.addCompte(c1);
        atb.addCompte(c2);
        atb.addCompte(c3);
        atb.addCompte(c4);
        System.out.println(atb);
    }
}
