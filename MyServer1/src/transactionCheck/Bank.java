package transactionCheck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Bank 
{
	private ObjectInputStream objectInputStream;

	public boolean createAccount(Person person)
    {
        if(person.getName().equals("") || person.getAccountNumber().equals("") || person.getPassword().equals(""))
            return false;

        File folder = new File("src/resources/");
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(person.getAccountNumber()))
                return false;
        }

        try {
            FileOutputStream fout = new FileOutputStream("src/resources/" + person.getAccountNumber());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);
            objectOutputStream.writeObject(person);

            objectOutputStream.close();
            fout.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean login(String accountnumber, String password)
    {
        File folder = new File("src/resources/");
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(accountnumber))
            {
                try {
                    FileInputStream fin = new FileInputStream(f);
                    objectInputStream = new ObjectInputStream(fin);

                    Person user = (Person) objectInputStream.readObject();

                    if(user.getPassword().equals(password))
                        return true;
                    else
                        return false;


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    public boolean withdraw(String tmpammount, String accountNumber)
    {
        double ammount = Double.parseDouble(tmpammount);

        if(ammount<0)
            return false;


        File folder = new File("src/resources/");
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(accountNumber))
            {
                try {
                    FileInputStream fin = new FileInputStream(f);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fin);

                    Person user = (Person) objectInputStream.readObject();

                    if(ammount >= user.getBalance())
                        return false;

                    user.setBalance(user.getBalance()-ammount);

                    FileOutputStream fout = new FileOutputStream(f);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);

                    objectOutputStream.writeObject(user);

                    fin.close();
                    objectInputStream.close();
                    fout.close();
                    objectOutputStream.close();


                } 
                
                
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                
                catch (IOException e)
                
                {
                    e.printStackTrace();
                }
                
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                return true;
            }
        }

        return false;

    }


   
   
}
