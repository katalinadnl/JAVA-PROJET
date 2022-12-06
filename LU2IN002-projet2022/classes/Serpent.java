public class Serpent {
    private int x;
    private int y;
    private int energie=10; 
    private int vie;
    private static int cmp=0;
    private int id;


    public Serpent(int ligne, int colonne){
        this.x=ligne;
        this.y=colonne;
        this.vie=3;
        id=cmp;
        cmp++;
    }

    public double distance(int a, int b){
        return Math.sqrt(Math.pow(x-a,2) + (Math.pow(y-b,2)));
    }

    public void seDeplacer(int xnew, int ynew){
        if(energie>10){
            this.x= xnew;
            this.y= ynew;
            energie--;
        }else{
            System.out.println("le serpent "+ cmp+" est mort(sans energie)");
        }       
    }

    public void updateVie(){
        if(vie>0){
            vie--;
        }else{
            vie= -1; //agent mort
        }
    }

    public String toString(){
        return "Le serpent "+ id +" a "+vie+" vies et "+energie+" energie";
    }


}
