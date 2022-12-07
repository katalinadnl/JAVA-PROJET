

public class TestSimulation{
    public static void main(String[] args){
        Terrain t= new Terrain();

        Simulation s1=new Simulation(t);

        s1.placer();
        for(Serpent s: s1.getAgents()){
            System.out.println(s.toString());
            System.out.println("\n");
        }
        t.affiche(2);

        for(int j=0; j<10; j++){
            System.out.println("Tour numéro "+ (j+1));
            System.out.println("\n");
            s1.deplacerTous();
            System.out.println("\n");
            for(Serpent s: s1.getAgents()){
                if(s.getVie()!=-1){
                    System.out.println(s.toString());
                    System.out.println("\n");
                }
            }
            t.affiche(2);
        }
        System.out.println("Les resulats finaux du joeux");
        System.out.println("\n");

        for(Serpent s: s1.getAgents()){
            if(s.getVie()!=-1){
                System.out.println("Le serpent "+ s.getId()+ " a gagné!");
                System.out.println("\n");
            }else{
                System.out.println("Le serpent "+ s.getId()+ " a perdu!");
                System.out.println("\n");
            }
        }

        

    }
}