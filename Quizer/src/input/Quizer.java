/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.util.Random;
import java.util.Scanner;
import java.io.Serializable;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Atif
 */
public class Quizer implements Serializable{
    String role;
    int score;
    static int j =60;
     static int h=10;
    static int k,l=0;
     int i;
     String cname;
     String quiz_detail;
     String q[][];
     int choices=0;

    public Quizer() {
        this.q = new String[h][j];
    }
public String username(){
    
   String contain="abcdefghijklomnopqrstuvwxyz0123456789";
          Random rn=new Random();
          StringBuilder sb=new StringBuilder(8);
       
          for(i=0;i<8;i++){
          sb.append(contain.charAt(rn.nextInt(contain.length())));
          
          }
          String random=sb.toString();
         // System.out.println(random);
          return random;
}

public String password(){
    
   String contain="abcdefghijklomnopqrstuvwxyz0123456789";
          Random rn=new Random();
          StringBuilder sb=new StringBuilder(8);
          for(i=0;i<8;i++){
          sb.append(contain.charAt(rn.nextInt(contain.length())));
          
          }
          String random=sb.toString();
         // System.out.println(random);
          return random;
}
public void instructor() throws IOException{
  System.out.println("Enter the course for which you want to create a quiz?");
 
  Scanner sc=new Scanner(System.in);
  cname=sc.nextLine();
  
  System.out.println("Enter some description about your quiz?");
 
  Scanner qd=new Scanner(System.in);
  quiz_detail=qd.nextLine();
  
 //making quiz
 for (int a=0;a<10;a++){
     choices=0;
    System.out.println("Enter Question of your Quiz?");
       Scanner ques=new Scanner(System.in);
       q[a][choices]=ques.nextLine();  
      for(choices=1;choices<6;choices++){
          if(choices==5){
          System.out.println("Give right answer ");
          Scanner rightans=new Scanner(System.in);
          q[a][choices]=rightans.nextLine();
          }
          else{
  System.out.println("Choice no."+ choices+ " is ");
  Scanner nl=new Scanner(System.in);
  q[a][choices]=nl.nextLine();}
        }
 }
  
  
 
}




public static void main(String[] args) throws ClassNotFoundException {
        
        try {
            
            System.out.println("This is main function\n");
            Quizer obj =new Quizer();
            System.out.println("User name is "+obj.username()+"\nPassword is "+obj.password());
            System.out.println("Choose you role? Student OR Instructor");
            int role;
            Scanner s=new Scanner(System.in);
            role=s.nextInt();
            System.out.println("Value of role is "+role);
              File f=new File("Obj.txt");
            if(role==1){
                System.out.println("Student is selected");
                //desteralization
     
                FileInputStream fis=new FileInputStream(f);
                ObjectInputStream ois=new ObjectInputStream(fis);
                Quizer newObj=(Quizer) ois.readObject();
                System.out.println("Following are the quiz details "+ newObj.quiz_detail);
                System.out.println("Questions are:");
                int no=1;
                int correct=0;
                String entered="null";
                int ch=1;
                for(int l=0;l<10;l++){
                System.out.println("Q.no"+ no++ +" " + newObj.q[l][0]);
                for( ch=1;ch<5;ch++){
                System.out.println("Choices "+ ch + " is ");
                System.out.println(newObj.q[l][ch]);
                
                
                }
                System.out.println("Enter right answer:");
                
                Scanner rs=new Scanner(System.in);
            entered=rs.nextLine();
                if(newObj.q[l][ch].matches(entered)){
                System.out.println("Right answer");
                correct++;
                }
                else{
                System.out.println("Wrong answer");
                }
                }
                System.out.println("Your score is "+ correct);
            
            }
            else if(role==2){
                obj.instructor();
                FileOutputStream fos=new FileOutputStream(f);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(obj);        
                FileInputStream fis=new FileInputStream(f);
                ObjectInputStream ois=new ObjectInputStream(fis);
                Quizer newObj=(Quizer) ois.readObject();
                System.out.println(newObj.role);
                System.out.println(newObj.score);
            }
            else         
                System.out.print("None is selected");
        } catch (IOException ex) {
            Logger.getLogger(Quizer.class.getName()).log(Level.SEVERE, null, ex);
        }
   


}
   
   
}