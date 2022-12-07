

public class TestSimulation{
    public static void main(String[] args){
        Terrain t= new Terrain(5,5); //creation du terrain

        Simulation s1=new Simulation(t); // creation du jeu

            s1.placer(); //on place les ressources

            for(Serpent s: s1.getAgents()){ //on affiche les serpents
                
                System.out.println(s.toString());
                System.out.println("\n");
            }

            System.out.println(s1.compterToutesRessources(t.lesRessources())); //on commpte les ressources sur le terrain

            t.affiche(2); //on affiche le terrain

            for(int j=0; j<10; j++){ //la boucle pour deplacer les serpents
                System.out.println("Tour numéro "+ (j+1));
                System.out.println("\n");
                s1.deplacerTous(); 
                System.out.println("\n");
                for(Serpent s: s1.getAgents()){ //afficher chaque fois les serpents
                    if((s.getVie()!=-1) ||(s.getEnergie()>0)){ //s'ils ont pas de vie ils nensont pas affichés
                        System.out.println(s.toString());
                        System.out.println("\n");
                    }
                }
                System.out.println(s1.compterToutesRessources(t.lesRessources()));//affichage de nb de ressources
                t.affiche(2);//affichage terrain
            }

            System.out.println("Les résultats finaux du jeu :"); //affichage de resultats finaux 
            System.out.println("\n");

            for(Serpent s: s1.getAgents()){
                if(((s.getVie()!=-1)&&(s.getEnergie()>0))){
                    System.out.println("Le serpent "+ s.getId()+ " a gagné!");
                    System.out.println("\n");
                }else{
                    System.out.println("Le serpent "+ s.getId()+ " a perdu!");
                    System.out.println("\n");
                }
            }



            t.affiche(2);
            System.out.println(s1.compterToutesRessources(t.lesRessources()));
    }
}