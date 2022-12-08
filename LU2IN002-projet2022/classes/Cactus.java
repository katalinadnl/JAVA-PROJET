//DANILA Catalina 21103654
//SAAD Maria 21106783

public class Cactus extends Ressource implements Toxique{
    
    public Cactus(int quantite){
        super("Cactus", quantite);
    }
    public String getType(){
        return type;
    }
    
    public String toString(){
        return "Cactus->  " + super.toString();
    }
}