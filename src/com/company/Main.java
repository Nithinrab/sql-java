package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
 Scanner sc = new Scanner(System.in);
        int options;
        while(true){
            System.out.println("1. add students");
            System.out.println("2. view all students");
            System.out.println("3. delete all students");
            System.out.println("4 exit");
            System.out.println("select an option");
            options= sc.nextInt();
            switch(options){
                case 1:
                   String name,admissionno,rollno,college;
                    System.out.println("enter name");
                    name = sc.next();
                    System.out.println("enter admissionno");
                    admissionno=sc.next();
                    System.out.println("enter rollno");
                    rollno = sc.next();
                    System.out.println("enter college");
                    college = sc.next();
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `child`( `name`, `rollno`, `addmission`, `college`) VALUES('"+name+"',"+rollno+","+admissionno+",'"+college+"')");
                        System.out.println("Inserted sucessfully");
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                case 2:
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false","root","");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT `ID`, `name`, `rollno`, `addmission`, `college` FROM `child` WHERE 1");
                    while(rs.next()){
                        System.out.println("name="+rs.getString("name"));
                        System.out.println("addmission"+rs.getInt("addmission"));
                        System.out.println("rollno"+rs.getInt("rollno"));
                        System.out.println("college"+rs.getString("college"));
                    }

                }
                catch(Exception e){

                }
                case 3:
                    System.out.println("delete all students option selected");
                    break;
                case 4:
                    System.out.println("exit");

                default:
                    System.out.println("invalid");
            }
        }
    }
}
