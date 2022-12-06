public class Simulation{
    private Terrain t;
    private Serpent[] agent;
    private Ressource[] ressources;

    public Simulation(Terrain ter, Serpent[] agent, Ressource[] ressources){
        this.t=ter;
        this.agent=agent;
        this.ressources=ressources;

        for(int j=0; j< ressources.length; j++){
            int x = (int)Math.random()*20;
            int y = (int)Math.random()*20;
            if(t.caseEstVide(x, y)){
                ressources[j].setPosition(x,y);
                t.setCase(x, y, ressources[j]);
            }else{
                while(t.caseEstVide(x, y)==false){
                    x = (int)Math.random()*20;
                    y = (int)Math.random()*20;   
                }
                ressources[j].setPosition(x,y);
                t.setCase(x, y, ressources[j]);
            }
        }

        for(int i=0; i<agent.length;i++){
            int x = (int)Math.random()*20;
            int y = (int)Math.random()*20;
            agent[i]= new Serpent(x,y);
        }
    }

    public void deplacerTous(Serpent s){
        for(int i=0; i<agent.length; i++){
            int ligne=(int)Math.random()*20;
            int col=(int)Math.random()*20;
            if(t.sontValides(ligne, col)){
                s.seDeplacer(ligne, col); //le serpent se deplace dans un point random
                if(t.getCase(ligne, col) instanceof NonToxi){ //si dans la case il y'a une ressource mangeable
                    s.augEnergie();
                    t.videCase(ligne, col);
                }else if(t.getCase(ligne, col) instanceof Toxique){//si dans la case il y'a une ressource toxique(cactus)
                    s.updateVie();
                    if(s.getVie()==-1){
                        System.out.println("Serpent "+ s.getId() +" est mort! ");
                    }
                }
            }
        }
    }   


}