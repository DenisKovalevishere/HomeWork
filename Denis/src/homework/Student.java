package homework;

public class Student {

	  public int NumderStudentID;
	  public String name;
	  public String surName;
	  public int studyYear;
	  public double mathematics;
	  public double economics;
	  public double foreignLanguage;
	  public double srednee;

	  Student (int id1, String name1, String surname1, int studyYear1, double mathematics1, double economics1, double foreignLanguage1) {
	      NumderStudentID = id1;
	      name = name1;
	      surName = surname1;
	      studyYear = studyYear1;
	      mathematics = mathematics1;
	      economics = economics1;
	      foreignLanguage = foreignLanguage1;
	      srednyayaOcenka();
	      
	  }
	  Student (int id2, String name2, String surname2, int studyYear2) {
	      this (id2, name2, surname2, studyYear2, 0.0, 0.0, 0.0);
	  }
	  Student (String name3, int studyYear3, double mathematics3, double economics3, double foreignLanguage3) {
		  this (0, name3, null, studyYear3, mathematics3, economics3, foreignLanguage3);
	  }

	  public void info() {
	      System.out.println("ID: " + NumderStudentID);
	      System.out.println("Name: " + name);
	      System.out.println("Surname: " + surName);
	      System.out.println("God obucheniya: " + studyYear);
	      System.out.println("Mathematics: " + mathematics);
	      System.out.println("Economics: " + economics);
	      System.out.println("Foreign language: " + foreignLanguage);
	      System.out.println("Srednyaya ocenka studenta " + name + " " + surName + ": " + srednee);
	      System.out.println();
	  }

	  public double srednyayaOcenka() {
	      srednee = (mathematics+economics+foreignLanguage)/3;
	      return srednee;
	  }
	}
class StudentTest {
		
	    public static void main(String[] args) {
	        Student st1 = new Student(12, "Denis", "Ivanov", 3, 4.6, 4.3, 4.8);
	        Student st2 = new Student(43, "Mike", "Petrov", 5, 4.6, 4.3, 4.8);
	        
	        st1.info();
	        st2.info();
	       
	    }
	}


