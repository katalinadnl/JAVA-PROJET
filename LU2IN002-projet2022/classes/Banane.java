//DANILA Catalina 21103654
//SAAD Maria 21106783

public class Banane extends Mangeable{
    public Banane(int quantite){
        super("Banane", quantite);
    }
    public String getType(){
        return type;
    }

    public void vieillir(){
        vie++;
    }

    public int getVie(){
        return vie;
    }

    public String toString(){
        return "Banane ->  " + super.toString() ;
    }
    
}