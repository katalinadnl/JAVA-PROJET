public class Simulation{
    private Terrain t;
    private Serpent[] agent;
    private Ressource[] ressource;

    public Simulation(Terrain ter, Serpent[] tab,int tailleS, Ressource[] ressources, int tailleR){
        tab= new Serpent[tailleS];
        ressources= new Ressource[tailleR];

        for(int j=0; j< ressources.length; j++){
            int x = (int)Math.random()*20;
            int y = (int)Math.random()*20;
            ressource[j].setPosition(x,y);
        }

        for(int i=0; i<tab.length;i++){
            int x = (int)Math.random()*20;
            int y = (int)Math.random()*20;
            tab[i]= new Serpent(x,y);
        }
    }
}