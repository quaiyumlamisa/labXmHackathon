package sertificate;
import java.io.IOException;

public class StudentDoc 
{
	 public static void main(String[] args) throws IOException, ClassNotFoundException
	 {
		 StudentArray sa= new  StudentArray();
		 
		    Student student1 = new Student();
	        student1.name = "Lamisa Quaiyum";
	        student1.FathersName = "M.A.Quaiyum";
	        student1.MothersName = "Fowzia Khanam";
	        student1.DateOfBirth=  "11 oct 1998";
	        
	        Student student2= new Student();
	        student2.name = "Sumaiya Quaiyum";
	        student2.FathersName = "F.A.Quaiyum";
	        student2.MothersName = "Champa Khanam";
	        student2.DateOfBirth=  "10 oct 1994";
	        
	        
	        Student student3 = new Student();
	        student3.name = "Lamia khan";
	        student3.FathersName = "M.Molla";
	        student3.MothersName = "Forida khan";
	        student3.DateOfBirth=  "11 feb 1995";



	        System.out.println(sa.createStudentInfo(student1));
	        System.out.println(sa.createStudentInfo(student2));
	        System.out.println(sa.createStudentInfo(student3));
	        

	        sa.printInfo();
	        
	        System.out.println(sa.login("Lamisa Quaiyum", "M.A.Quaiyum","Fowzia Khanam","11 oct 1998"));
	      
		
	 }

	
}


