//DANILA Catalina 21103654
//SAAD Maria 21106783

public abstract class Mangeable extends Ressource implements NonToxi{   
    protected int vie = 0;

    public Mangeable(String type, int q){
        super(type,q);
    }
    
    public abstract String getType();
    public abstract int getVie();
    public abstract void vieillir();

    public String toString(){
        return super.toString();
    }
}