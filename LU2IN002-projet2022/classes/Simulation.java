import java.util.ArrayList;

public class Simulation{
    private Terrain t;
    private ArrayList<Serpent> agent= new ArrayList<Serpent>();
    private ArrayList<Ressource> ressources= new ArrayList<Ressource>();
    

    public Simulation(Terrain ter){
        t=ter;
        int b= (30*(t.nbLignes* t.nbColonnes))/100;
        int f= (30*(t.nbLignes* t.nbColonnes))/100;
        int c= (25*(t.nbLignes* t.nbColonnes))/100;
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
            agent.add(new Serpent((int)(Math.random()*t.nbLignes), (int)(Math.random()*t.nbColonnes)));
        }
    }

    public Simulation clone(){
        return new Simulation(t);
    }
    
    public void ajoutR(Ressource r){
        ressources.add(r);
    }

    public void ajoutA(Serpent a){
        agent.add(a);
    }

    public ArrayList<Serpent> getAgents(){
        return agent;
    }

    public ArrayList<Ressource> getRessources(){
        return ressources;
    }

    public void placer(){

        for(Ressource r: ressources){
            int x = (int)(Math.random()*t.nbLignes);
            int y = (int)(Math.random()*t.nbColonnes);
            
            while((!t.caseEstVide(x, y))&&(!t.sontValides(x, y))){
                x = (int)(Math.random()*t.nbLignes);
                y = (int)(Math.random()*t.nbColonnes);
            }

            r.setPosition(x, y);
            t.setCase(x, y, r);
        }

    }

    public void faireVieillir(){
        ArrayList<Mangeable> mangeables= new ArrayList<Mangeable>();

        for(Ressource r: ressources){
            if(r instanceof NonToxi){
                mangeables.add((Mangeable)r);
            }
        }

        for(Mangeable m: mangeables){
            if(m.getVie()<6){
                m.vieillir();
            }
            if(m.getVie()==6){
                int xC= m.getX();
                int yC= m.getY();
                t.videCase(xC, yC);                    
                t.setCase(xC, yC, new Cactus(1));
                m.vieillir();
            }
        }
        System.out.println("Toutes les ressources mangeables qui ont une vie > 6 sont tranformés en cactus "); 
       
    }

    public void deplacerTous(){
        for(Serpent s : agent){
            int newligne=(int)(Math.random()*t.nbLignes);
            int newcol=(int)(Math.random()*t.nbColonnes);
            if((t.sontValides(newligne, newcol))&&(s.getVie()!=-1)){
                s.seDeplacer(newligne, newcol); //le serpent se deplace dans un point random
                if(t.getCase(newligne, newcol) instanceof NonToxi){ //si dans la case il y'a une ressource mangeable
                    s.augEnergie();
                    t.videCase(newligne, newcol);
                    System.out.println("Le serpent "+ s.getId()+" a mangé une ressource");
                }else{
                    if(t.getCase(newligne, newcol) instanceof Toxique){//si dans la case il y'a une ressource toxique(cactus)
                        s.updateVie();
                        System.out.println("Serpent "+ s.getId() +" a touché un cactus!");
                        if(s.getVie()==-1){
                            System.out.println("Serpent "+ s.getId() +" est mort! ");
                        }
                        t.videCase(newligne, newcol);
                    }
                }
            }
        }
        faireVieillir();
    }

    public String toString(){
        return "Simulation sur un terrain avec les agents: " + getAgents() + " \n et les ressources: "+ getRessources() ;
    }




}