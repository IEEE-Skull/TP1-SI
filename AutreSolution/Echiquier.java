import java.util.*;
import java.util.Arrays.*;
public class Echiquier {
    private Cellule[][] echiquier;
    private int taille;

    public void initaliserEchequier() {
        for (int x = 0; x < taille; x++) {
            for (int y = 0; y < taille; y++) {
                echiquier[x][y] = new Cellule(x, y);
            }
        }
    }

    public Echiquier(int taille) {
        this.taille = taille;
        echiquier = new Cellule[taille][taille];
        initaliserEchequier();
    }

    public void modifierCellule(int x, int y, int valeur) {
        echiquier[x][y].setTypeOccupation(valeur);
    }

    public void placerReine(int x, int y) {
        int typeOccupation = echiquier[x][y].getTypeOccupation();
        if (typeOccupation == 0 && x >= 0) {
            echiquier[x][y].setTypeOccupation(1);
            int a = x, b = y, a1 = x, b1 = y, a2 = x, b2 = y, a3 = x, b3 = y;
            for (int i = 0; i < taille; i++) {
                if (i != y) {
                    echiquier[x][i].setTypeOccupation(2);
                }
                if (i != x) {
                    echiquier[i][y].setTypeOccupation(2);
                }
                for (int j = 0; j < taille; j++) {
                    if (a < (taille - 1) && b < (taille - 1)) {
                        a++;
                        b++;
                        echiquier[a][b].setTypeOccupation(2);
                    }
                    if (a1 > 0 && b1 > 0) {
                        a1--;
                        b1--;
                        echiquier[a1][b1].setTypeOccupation(2);
                    }
                    if (a2 < (taille - 1) && b2 > 0) {
                        a2++;
                        b2--;
                        echiquier[a2][b2].setTypeOccupation(2);
                    }
                    if (a3 > 0 && b3 < (taille - 1)) {
                        a3--;
                        b3++;
                        echiquier[a3][b3].setTypeOccupation(2);
                    }
                }
            }
        } else {
            System.out.println("No More Spaces");
        }
    }

    public String toString() {
        int TypeShow;
        String Show = "";
        for (int x = 0; x < taille; x++) {
            for (int y = 0; y < taille; y++) {
                TypeShow = echiquier[x][y].getTypeOccupation();
                Show += x + "" + y + ":" + TypeShow + "\t";
            }
            Show += "\n";
        }
        Show += "\n";
        return Show;
    }


    public void PositionReines() {
        int TypeShow;
        System.out.print("Reines:" + "\n");
        for (int x = 0; x < taille; x++) {
            for (int y = 0; y < taille; y++) {
                TypeShow = echiquier[x][y].getTypeOccupation();
                if (TypeShow == 1) {
                    System.out.println("X:" + x + " Y:" + y);
                }
            }
        }
    }

    public boolean ResoudreProbleme(int col) {
        int I = 0;
        int[][] PositionSaver = new int[taille][2];
        if (col >= (taille)) {
            return true;
        }
        for (int i = 0; i < taille; i++) {
            if (echiquier[i][col].getTypeOccupation() == 0) {
                placerReine(i, col);
                if (ResoudreProbleme(col + 1) == true) {
                    return true;
                }
                for (int x = 0; x < taille; x++) {
                    for (int y = 0; y < col; y++) {
                        if (echiquier[x][y].getTypeOccupation() == 1) {
                            PositionSaver[I][0] = x;
                            PositionSaver[I][1] = y;
                            I++;
                        }
                    }
                }
                initaliserEchequier();
                for (int x = 0; x < col; x++) {
                    placerReine(PositionSaver[x][0], PositionSaver[x][1]);
                }
            }
        }
        return false;
    }
}
