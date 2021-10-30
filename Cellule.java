public class Cellule {
    private int x,y,typeOccupation;
    final static int LIBRE=0,REINE =1,MENACEE=2;

    public Cellule(int x, int y){
        this.x=x;
        this.y=y;
        this.typeOccupation= LIBRE;
    }



    public void setTypeOccupation(int typeOccupation) {
        this.typeOccupation = typeOccupation;
    }

    public int getTypeOccupation(){
        return this.typeOccupation;
    }



}
