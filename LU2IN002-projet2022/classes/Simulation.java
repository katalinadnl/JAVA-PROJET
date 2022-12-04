public class Simulation{
    private Terrain t;
    private Serpent[] agent;
    private Ressource[] ress;

    public Simulation(Terrain ter, Serpent[] tab, Ressource[] ress){
        //Mettre les ressources dans le terrain
        for(int i=0; i< ress.length; i++){
            int x = (int)Math.random()*20;
            int y = (int)Math.random()*20;
            ress[i].setPosition(x,y);
        }
    }
}