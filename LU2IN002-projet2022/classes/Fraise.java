//DANILA Catalina 21103654
//SAAD Maria 21106783

public class Fraise extends Mangeable{
    public Fraise(int quantite){
        super("Fraise", quantite);
    }
    public void vieillir(){
        vie++;
    }

    public int getVie(){
        return vie;
    }
    public String getType(){
        return type;
    }

    public String toString(){
        return "Fraise->  " + super.toString();
    }
}