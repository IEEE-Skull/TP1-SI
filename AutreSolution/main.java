
public class main {
    public static void main(String[] args) {
        int IND[] = new int[2];
        int taille=4;
        String Show;
        Echiquier E1= new Echiquier(taille);
        boolean Sol=E1.ResoudreProbleme(0);
        if(Sol == false) {
            System.out.println("Pas de Solution Possible");
        }else {
            Show = E1.toString();
            System.out.println(Show);
            E1.PositionReines();
        }
    }
}
