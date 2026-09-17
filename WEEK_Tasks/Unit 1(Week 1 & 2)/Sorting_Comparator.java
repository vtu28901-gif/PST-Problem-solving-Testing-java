import java.util.*;
class Player{
    String name;
    int score;
    Player(String name,int score){
        this.name=name;
        this.score=score;
    }
}
class Checker implements Comparator<Player>{
    public int compare(Player a,Player b){
        if(a.score!=b.score)return Integer.compare(b.score,a.score);
        return a.name.compareTo(b.name);
    }
}
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Player[] players=new Player[n];
        for(int i=0;i<n;i++)players[i]=new Player(sc.next(),sc.nextInt());
        Arrays.sort(players,new Checker());
        for(Player p:players)System.out.println(p.name+" "+p.score);
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