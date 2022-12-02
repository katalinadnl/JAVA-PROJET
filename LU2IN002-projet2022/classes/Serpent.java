public class Serpent {
    private int x;
    private int y;
    private int energie=10; 
    private int vie;
    private static int cmp=0;


    public Serpent(int ligne, int colonne){
        this.x=ligne;
        this.y=colonne;
        this.vie=3;

    }

    public double distance(int a, int b){
        return Math.sqrt(Math.pow(x-a,2) + (Math.pow(y-b,2)));
    }

    public void seDeplacer(int xnew, int ynew){
        if(Terrain.caseEstVide(xnew,ynew)){
            
        }
    }

}
