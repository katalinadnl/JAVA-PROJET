public class Banane extends Mangeable implements NonToxi{
    public Banane(int quantite){
        super("Banane", quantite);
    }
    public void vieillir(){
        vie++;
    }
    public String toString(){
        return "Banane";
    }
    
}