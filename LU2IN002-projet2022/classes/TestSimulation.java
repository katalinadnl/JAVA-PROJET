public class TestSimulation{
    public static void main(String[] args){
        Banane b = new Banane((int)Math.random()*6);
        Fraise f = new Fraise((int)Math.random()*6);
        Cactus c = new Cactus((int)Math.random()*6);

        int total= b.getQuantite()+ f.getQuantite()+ c.getQuantite();

        Ressource[] res= new Ressource[total];
        int j=0;

        for(int i=0; i<b.getQuantite();i++){
            while(j!=res.length){
                res[j]=b;
                j++;
            }
        }
        for(int i=0; i<f.getQuantite();i++){
            while(j!=res.length){
                res[j]=f;
                j++;
            }
        }
        for(int i=0; i<c.getQuantite();i++){
            while(j!=res.length){
                res[j]=c;
                j++;
            }
        }

        Terrain t= new Terrain();

        Serpent[] agent= new Serpent[3];

        Simulation s1=new Simulation(t, agent, res);
        
        s1.placer();
        
        t.affiche(3);



    }
}