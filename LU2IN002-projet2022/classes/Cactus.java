public class Cactus extends Ressource implements Toxique{
    
    public Cactus(int quantite){
        super("Cactus", quantite);
    }

    public String toString(){
        return "Cactus";
    }
}