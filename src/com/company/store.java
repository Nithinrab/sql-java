package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class store {
    public static void main(String[] args) {
            // write your code here
            Scanner sc = new Scanner(System.in);
            int options;
            while(true){
                System.out.println("1. book details");
                System.out.println("2. view all books");
                System.out.println("3. delete all books");
                System.out.println("4 exit");
                System.out.println("select an option");
                options= sc.nextInt();
                switch(options){
                    case 1:
                        String bookname,author,publisher,distributer,price;
                        System.out.println("enter bookname");
                        bookname = sc.next();
                        System.out.println("enter author");
                        author=sc.next();
                        System.out.println("enter publisher");
                        publisher = sc.next();
                        System.out.println("enter distributer");
                        distributer= sc.next();
                        System.out.println("enter price");
                        price=sc.next();
                        try {
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false","root","");
                            Statement stmt = con.createStatement();
                            stmt.executeUpdate("INSERT INTO `bookdetails`(`bookname`, `author`, `publisher`, `distributer`, `price`) VALUES('"+bookname+"','"+author+"','"+publisher+"','"+distributer+"',"+price+")");
                            System.out.println("Inserted sucessfully");
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }

                    case 2:
                        try{
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false","root","");
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT `id`, `bookname`, `author`, `publisher`, `distributer`, `price` FROM `bookdetails` WHERE 1");
                            while(rs.next()){
                                System.out.println("bookname="+rs.getString("bookname"));
                                System.out.println("author"+rs.getString("author"));
                                System.out.println("publisher"+rs.getString("publisher"));
                                System.out.println("distributer"+rs.getString("distributer"));
                                System.out.println("price"+rs.getInt("price"));
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

