public class Fraise extends Mangeable implements Mangeable{
    public Fraise(int quantite){
        super("Fraise", quantite);
    }
    public void vieillir(){
        vie++;
    }
    public String toString(){
        return "Fraise";
    }
}