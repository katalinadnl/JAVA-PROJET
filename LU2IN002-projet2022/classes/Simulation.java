import java.util.ArrayList;

public class Simulation{
    private Terrain t;
    private ArrayList<Serpent> agent= new ArrayList<Serpent>();
    private ArrayList<Ressource> ressources= new ArrayList<Ressource>();
    

    public Simulation(int b, int f, int c, Terrain ter){
        t=ter;
        for(int i=0; i<b;i++){
            ressources.add(new Banane(1));
        }
        for(int i=0; i<f;i++){
            ressources.add(new Fraise(1));
        }
        for(int i=0; i<c;i++){
            ressources.add(new Cactus(1));
        }
        for(int i=0; i<3; i++){
            agent.add(new Serpent((int)(Math.random()*20), (int)(Math.random()*20)));
        }
        System.out.println(ressources);
    }

    public void ajoutR(Ressource r){
        ressources.add(r);
    }

    public void ajoutA(Serpent a){
        agent.add(a);
    }

    public void placer(){

        for(Ressource r: ressources){
            int x = (int)(Math.random()*20);
            int y = (int)(Math.random()*20);
            
            while((!t.caseEstVide(x, y))&&(!t.sontValides(x, y))){
                x = (int)(Math.random()*20);
                y = (int)(Math.random()*20);
            }

            r.setPosition(x, y);
            t.setCase(x, y, r);
        }

    }

    public void deplacerTous(){
        for(Serpent s : agent){
            int ligne=(int)(Math.random()*20);
            int col=(int)(Math.random()*20);
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
                    t.videCase(ligne, col);
                }
            }
        }
    }

    public String toString(){
        return "Similation";
    }




}