import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	
	/*
	 * 
	 * Friday 19:00 E-Motion Club
	 * career event
	 * 
	 * */
	
	static final String dataFile = "invoicedata";

	static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = {
	    "Java T-shirt",
	    "Java Mug",
	    "Duke Juggling Dolls",
	    "Java Pin",
	    "Java Key Chain"
	};

	private static void byteStreams() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
	
		try {
		    in = new FileInputStream("xanadu.txt");
		    out = new FileOutputStream("outagain.txt");
		    int c;
	
		    while ((c = in.read()) != -1) {
		        out.write(c);
		    }
		} finally {
		    if (in != null) {
		        in.close();
		    }
		    if (out != null) {
		        out.close();
		    }
		}
	}

	private static void characterStreams() throws IOException {
		FileReader inputStream = null;
		FileWriter outputStream = null;
	
		try {
		    inputStream = new FileReader("xanadu.txt");
		    outputStream = new FileWriter("characteroutput.txt");
	
		    int c;
		    while ((c = inputStream.read()) != -1) {
		        outputStream.write(c);
		    }
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (outputStream != null) {
		        outputStream.close();
		    }
		}
	}

	private static void bufferedStreams() throws IOException {
		BufferedReader inputStream = new BufferedReader(new FileReader("xanadu.txt"));
		BufferedWriter outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"));
	}

	private static void dataStreams() throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
		              new FileOutputStream(dataFile)));
		for (int i = 0; i < prices.length; i ++) {
		    out.writeDouble(prices[i]);
		    out.writeInt(units[i]);
		    out.writeUTF(descs[i]);
		}
	
		DataInputStream in = new DataInputStream(new
		            BufferedInputStream(new FileInputStream(dataFile)));
	
		double price;
		int unit;
		String desc;
		double total = 0.0;
		try {
		    while (true) {
		        price = in.readDouble();
		        unit = in.readInt();
		        desc = in.readUTF();
		        System.out.format("You ordered %d" + " units of %s at $%.2f%n",
		            unit, desc, price);
		        total += unit * price;
		    }
		} catch (EOFException e) {
		}
	}
	
	private static void objectOutputStream() throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(
				"/Users/user/user.txt");
		User user = new User("John", "Sullivan", "myemail@mail.com");
		ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
		try {
			output.writeObject(user);
		}
		finally {
			output.close();
		}
	}
	
	private static void objectInputStream() throws IOException {
		//Read from the stored file
		FileInputStream fileInputStream = new FileInputStream(new File(
				"/Users/user/test.txt"));
		ObjectInputStream input = new ObjectInputStream(fileInputStream);
		User user2;
		try {
			user2 = (User) input.readObject();
			System.out.println(user2.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			input.close();
		}
	}

}
