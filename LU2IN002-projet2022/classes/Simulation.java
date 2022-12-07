import java.util.ArrayList;

public class Simulation{
    private Terrain t;
    private ArrayList<Serpent> agent= new ArrayList<Serpent>();
    private ArrayList<Ressource> ressources= new ArrayList<Ressource>();
    

    public Simulation(Terrain ter){
        t=ter;
        int b= (30*(t.nbLignes* t.nbColonnes))/100; //les bananes vont occuper 30% du terrain
        int f= (30*(t.nbLignes* t.nbColonnes))/100; //les fraises vont occuper 30% du terrain
        int c= (25*(t.nbLignes* t.nbColonnes))/100; //les cactus vont occuper 30% du terrain
        for(int i=0; i<b;i++){
            ressources.add(new Banane((int)(Math.random()*5))); //chaque case du terrain va avoir une quantité de bananes sur elle
        }
        for(int i=0; i<f;i++){
            ressources.add(new Fraise((int)(Math.random()*5))); //chaque case du terrain va avoir une quantité de fraises sur elle
        }
        for(int i=0; i<c;i++){
            ressources.add(new Cactus((int)(Math.random()*3))); //chaque case du terrain va avoir une quantité de cactus sur elle
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

    public String compterToutesRessources(ArrayList<Ressource> re){
        int nb=0;
        int nbT=0;

        for(Ressource r: re){ //choisir les ressources mangeables depuis la liste de ressources
            nb++;
            if(r instanceof Toxique){
                nbT++;
            }
        }
        int nbM= nb-nbT;
        return "Nombre de ressources = "+ nb +" (nb Mangeables= "+ nbM+", nb Toxiques= "+ nbT+" )";
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
            
            while((!t.caseEstVide(x, y))&&(!t.sontValides(x, y))){ //on va verifier si la case du terrain est vide et valide 
                x = (int)(Math.random()*t.nbLignes);
                y = (int)(Math.random()*t.nbColonnes);
            }

            r.setPosition(x, y); //on va mettre la position de la ressource
            t.setCase(x, y, r); //on va la placer sur le terrain
        }

    }

    public void faireVieillir(){ //methode pour faire vieillir toutes les ressources mangeables
        ArrayList<Mangeable> mangeables= new ArrayList<Mangeable>();

        for(Ressource r: ressources){ //choisir les ressources mangeables depuis la liste de ressources
            if(r instanceof NonToxi){
                mangeables.add((Mangeable)r);
            }
        }

        for(Mangeable m: mangeables){ //vieillir les bananes et les fraises s'elles ont moins de 6 vies, sinon elles se transforment en cactus
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
        System.out.println("Toutes les ressources mangeables qui ont une vie > 6 sont tranformés en cactus \n"); 
       
    }

    public void deplacerTous(){ //methode pour deplacer tous les serpents
        for(Serpent s : agent){
            int newligne=(int)(Math.random()*t.nbLignes); //new x 
            int newcol=(int)(Math.random()*t.nbColonnes);  //new y
            if((t.sontValides(newligne, newcol))&&(s.getVie()!=-1)){ //on verifie si la case est valide et si le serpent n'est pas mort
                s.seDeplacer(newligne, newcol); //le serpent se deplace dans un point random
                if(t.getCase(newligne, newcol) instanceof NonToxi){ //si dans la case il y'a une ressource mangeable
                    Ressource nonToxi= t.getCase(newligne, newcol);
                    for(int e=0;e < nonToxi.getQuantite(); e++){ //on va ajouter a l'energie du serpent la quantité de ressources sur la case
                        s.augEnergie(); 
                    }
                        Ressource vide = t.videCase(newligne, newcol); //on va vider la case si le serpent mange la ressource
                        ressources.remove(vide);
                        System.out.println("Le serpent "+ s.getId()+" a mangé une "+ vide.type+ "!!!\n");
                }else{
                    if(t.getCase(newligne, newcol) instanceof Toxique){//si dans la case il y'a une ressource toxique(cactus)
                        Ressource toxi= t.getCase(newligne, newcol);
                        for(int e=0;e < toxi.getQuantite(); e++){ //on va reduire la vie du serpent avec la quantité de ressources sur la case
                            s.updateVie(); //le serpent perd une vie 
                        }
                        ressources.remove(toxi);
                        System.out.println("Serpent "+ s.getId() +" a touché un cactus!\n");
                        if(s.getVie()==-1){  //si le serpent est mort
                            System.out.println("Serpent "+ s.getId() +" est mort!\n ");
                        }
                        t.videCase(newligne, newcol); //le cactus va disparaitre
                    }
                }
            }
        }
        faireVieillir(); //après chaque deplacement les ressources mangeables vont vieillir 
    }

    public String toString(){
        return "Simulation sur un terrain avec les agents: " + getAgents() + " \n et les ressources: "+ getRessources()+"\n";
    }




}