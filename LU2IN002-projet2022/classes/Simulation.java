public class Simulation{
    private Terrain t;
    private Serpents[] agent;
    private Ressource[] ress;

    public Simulation(Terrain ter, Serpents[] tab, Ressource[] ress){
        //Mettre les ressources dans le terrain
        for(int i=0; i< ress.length; i++){
            int x = (int)Math.random()*20;
            int y = (int)Math.random()*20;
            res[i].setPosition(x,y);
        }
    }
}