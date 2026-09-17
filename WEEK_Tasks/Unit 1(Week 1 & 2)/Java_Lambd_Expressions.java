import java.io.*;
import java.util.*;
interface PerformOperation{
    boolean check(int a);
}
class MyMath{
    public PerformOperation isOdd(){
        return a->a%2!=0;
    }
    public PerformOperation isPrime(){
        return a->{
            if(a<2)return false;
            for(int i=2;i*i<=a;i++)if(a%i==0)return false;
            return true;
        };
    }
    public PerformOperation isPalindrome(){
        return a->{
            String s=String.valueOf(a);
            return s.equals(new StringBuilder(s).reverse().toString());
        };
    }
    public boolean checker(PerformOperation p,int num){
        return p.check(num);
    }
}
public class Solution{
    public static void main(String[] args)throws IOException{
        MyMath myMath=new MyMath();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int condition=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken());
            PerformOperation op;
            boolean result;
            if(condition==1){
                op=myMath.isOdd();
                result=myMath.checker(op,num);
                System.out.println(result?"ODD":"EVEN");
            }else if(condition==2){
                op=myMath.isPrime();
                result=myMath.checker(op,num);
                System.out.println(result?"PRIME":"COMPOSITE");
            }else{
                op=myMath.isPalindrome();
                result=myMath.checker(op,num);
                System.out.println(result?"PALINDROME":"NOT PALINDROME");
            }
        }
    }
}
/*
Output:
EVEN
PRIME
PALINDROME
ODD
COMPOSITE
*/