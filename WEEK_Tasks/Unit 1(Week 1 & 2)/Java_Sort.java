import java.util.*;
class Student{
    private int id;
    private String name;
    private double cgpa;
    Student(int id,String name,double cgpa){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public double getCgpa(){return cgpa;}
}
class Checker implements Comparator<Student>{
    public int compare(Student a,Student b){
        if(a.getCgpa()!=b.getCgpa())return Double.compare(b.getCgpa(),a.getCgpa());
        if(!a.getName().equals(b.getName()))return a.getName().compareTo(b.getName());
        return Integer.compare(a.getId(),b.getId());
    }
}
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Student> students=new ArrayList<>();
        for(int i=0;i<n;i++)students.add(new Student(sc.nextInt(),sc.next(),sc.nextDouble()));
        students.sort(new Checker());
        for(Student s:students)System.out.println(s.getName());
    }
}
/*
Output:
Ashis
Fahim
Samara
Samiha
Rumpa
*/