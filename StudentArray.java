package sertificate;

import java.io.*;
import java.util.ArrayList;

public class StudentArray
{
	 ArrayList<Student> array;

	    public StudentArray()
	    {
	        array = new ArrayList<Student>();
	    }


	    public boolean createStudentInfo(Student student) throws IOException, ClassNotFoundException
	    {

	        File file = new File("input1.txt");

	        if(file.exists())
	        {
	            FileInputStream fin = new FileInputStream(file);
	            ObjectInputStream object = new ObjectInputStream(fin);
	            ArrayList<Student> readObject = (ArrayList<Student>) object.readObject();
				ArrayList<Student> array1 = readObject;

	            array.clear();

	            for(Student s : array1)
	            {
	                array.add(s);
	            }

	            for(int i=0; i<array1.size(); i++)
	            {
	                Student s = array1.get(i);
	                if (s.name.equals(student.name))
	                        return false;
	            }
	        }

	        array.add(student);
	        FileOutputStream fout = new FileOutputStream(new File("input1.txt"));
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);
	        objectOutputStream.writeObject(array);

	        return true;
	    }

	    public boolean login(String name, String FathersName , String MothersName, String DateOfBirth) throws IOException, ClassNotFoundException {

	        File file = new File("input1.txt");

	        if(file.exists())
	        {
	            FileInputStream fin = new FileInputStream(file);
	            ObjectInputStream object = new ObjectInputStream(fin);
	            ArrayList<Student> readObject = (ArrayList<Student>) object.readObject();
				ArrayList<Student> array1 = readObject;

	            for(int i=0; i<array1.size(); i++)
	            {
	                if (array1.get(i).name.equals(name) && array1.get(i).FathersName.equals(FathersName)&& array1.get(i).MothersName.equals(MothersName)&& array1.get(i).DateOfBirth.equals(DateOfBirth))
	                        return true;

	            }
	        }

	        return false;
	    }	    
	    
	    public void printInfo() throws IOException, ClassNotFoundException
	    {
	        File file = new File("input1.txt");

	        if(file.exists())
	        {
	            FileInputStream fin = new FileInputStream(file);
	            ObjectInputStream object = new ObjectInputStream(fin);
	            ArrayList<StudentDoc> tmpStudent = (ArrayList<StudentDoc>) object.readObject();

	            for(int i=0; i<array.size(); i++)
	            {
	                Student s = array.get(i);

	                System.out.println("Name: " + s.name);
	                System.out.println("Father's name: " + s.FathersName);
	                System.out.println("Mother's name: " + s.FathersName);
	                System.out.println("Date of birth: " + s.DateOfBirth);
	                System.out.println();
	            }
	        }
	    

}
}