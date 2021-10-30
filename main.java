
public class main {
    public static void main(String[] args) {
        int IND[] = new int[2];
        int taille=6;
        String Show;
        Echiquier E1= new Echiquier(taille);
        IND[0]=(int) ((Math.random() * ((taille-1) - 0)) + 0);
        IND[1]=(int) ((Math.random() * ((taille-1) - 0)) + 0);
        int NombreReines=0;
        do {
            E1.placerReine(IND[0],IND[1]);
            Show= E1.toString();
            System.out.print(Show);
            IND = E1.ChoisirCellule();
            NombreReines++;
        }while (IND[0]>=0);
        System.out.println("Nombre de Reines Placees:"+NombreReines);
        E1.PositionReines();
    }
}
