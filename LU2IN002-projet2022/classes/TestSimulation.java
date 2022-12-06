

public class TestSimulation{
    public static void main(String[] args){
        Terrain t= new Terrain();


        Simulation s1=new Simulation(10,5,5,t);

        s1.placer();
        
        t.affiche(3);

        s1.deplacerTous();

        t.affiche(3);
    }
}