import java.io.*; 
import java.util.*; 
class Student { 
int rollno; 
String name; 
float fees; 
String branch; 
int year; 
int sem; 
int age; 
static String clg; 
public Student(int rollno,String name,float fees,String branch,int year,int sem,int age) { 
this.rollno = rollno; 
this.name = name; 
this.fees = fees; 
this.branch = branch; 
this.year = year; 
this.sem = sem; 
this.age = age; 
clg="PU"; 
} 
@Override 
public String toString() { 
return rollno + " "+ name + " " + fees + " " + branch + " " + year + sem + " " + age + " " + clg + "\n"; 
} 
} 
class AgeComparator implements Comparator {  
public int compare(Object o1,Object o2){  
Student s1=(Student)o1;  
Student s2=(Student)o2;  
if(s1.age==s2.age)  
return 0;  
else if(s1.age>s2.age)  
return 1;  
else  
return -1;  
}  
}  
class NameComparator implements Comparator{  
public int compare(Object o1,Object o2){  
Student s1=(Student)o1;  
Student s2=(Student)o2;  
return s1.name.compareTo(s2.name);  
}  
}  
class FeesComparator implements Comparator {  
public int compare(Object o1,Object o2){  
Student s1=(Student)o1;  
Student s2=(Student)o2;  
if(s1.fees==s2.fees)  
return 0;  
else if(s1.fees>s2.fees)  
return 1;  
else  
return -1;  
}  
}  
public class Temp1 { 
public static void main(String[] args) { 
// TODO Auto-generated method stub 
ArrayList sl=new ArrayList();  
sl.add(new Student(1,"Shiva",10000.00f,"cse",1,1,18));  
sl.add(new Student(2,"Venky",15000.00f,"ise",1,2,20));  
sl.add(new Student(3,"Jesus",17000.00f,"ece",1,1,19));  
sl.add(new Student(3,"Alla",12000.00f,"eee",1,1,19));  
sl.add(new Student(3,"Budha",11000.00f,"mech",1,1,21)); 
System.out.println("Sorting by Name");  
System.out.println("_______________");  
Collections.sort(sl,new NameComparator());  
Iterator itr=sl.iterator();  
while(itr.hasNext()){  
Student st=(Student)itr.next();  
System.out.println(st.rollno+" "+st.name+" "+ st.fees+ " " + st.branch+ " " + st.year + " " + st.sem + " " + st.age + " " + Student.clg);  
}  
System.out.println("Sorting by age");  
System.out.println("______________");  
Collections.sort(sl,new AgeComparator());  
Iterator itr2=sl.iterator();  
while(itr2.hasNext()){  
Student st=(Student)itr2.next();  
System.out.println(st.rollno+" "+st.name+" "+ st.fees+ " " + st.branch+ " " + st.year + " " + st.sem + " " + st.age + " " + Student.clg);  
}  
System.out.println("Sorting by fees");  
System.out.println("______________");  
Collections.sort(sl,new FeesComparator());  
Iterator itr1=sl.iterator();  
while(itr1.hasNext()){  
Student st=(Student)itr1.next();  
System.out.println(st.rollno+" "+st.name+" "+ st.fees+ " " + st.branch+ " " + st.year + " " + st.sem + " " + st.age + " " + Student.clg);  
}  
} 
} 
