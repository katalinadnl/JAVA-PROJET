public abstract class Mangeable extends Ressource{   
    public int vie = 0;

    public Mangeable(String type, int q){
        super(type,q);
    }

    public abstract void vieillir();
}