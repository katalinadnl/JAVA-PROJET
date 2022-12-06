public class Simulation{
    private Terrain t;
    private Serpent[] agent;
    private Ressource[] ressource;

    public Simulation(Terrain ter, Serpent[] tab, Ressource[] ressources, int tailleR){
        tab= new Serpent[3];
        ressources= new Ressource[tailleR];
        t= new Terrain();

        for(int j=0; j< ressources.length; j++){
            int x = (int)Math.random()*20;
            int y = (int)Math.random()*20;
            ressource[j].setPosition(x,y);
            t.setCase(x, y, ressource[j]);
        }

        for(int i=0; i<tab.length;i++){
            int x = (int)Math.random()*20;
            int y = (int)Math.random()*20;
            tab[i]= new Serpent(x,y);
            

        }
    }

    public void deplacer(Serpent s){
        int ligne=(int)Math.random()*20;
        int col=(int)Math.random()*20;
        if(t.sontValides(ligne, col)){
            s.seDeplacer(ligne, col); //le serpent se deplace dans un point random
        }
    }   
}