class Checker implements java.util.Comparator<Player>{
    public int compare(Player a,Player b){
        if(a.score!=b.score)return Integer.compare(b.score,a.score);
        return a.name.compareTo(b.name);
    }
}
/*
Output:
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
*/