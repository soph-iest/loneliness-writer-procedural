package tiltfactor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("xd World!");
        Writer myWriter = new Writer();
        FileOutputStream fos;
        ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("mywriter2.tmp");
			oos = new ObjectOutputStream(fos);	
			oos.writeObject(myWriter);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        FileInputStream fis;
        
        Writer tempWriter;
        try {
        	fis = new FileInputStream("mywriter2.tmp");
        	ObjectInputStream ois = new ObjectInputStream(fis);
        	tempWriter = (Writer) ois.readObject();
        	System.out.println(tempWriter.details.toString());
        	ois.close();
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
