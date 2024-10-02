import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	static Queue Processes; 
	private static RoundRobin myAlgorithm; 
	
	public static int Time;
	public static boolean Finished = false;
	public static boolean Stopped = true;

	public static void main(String[] args) {
		Processes = new Queue(8);
		String fileName = "data.csv";														//The name of the CSV file
		File file = new File(fileName);														//Tells the system this is a file
		try {
			Scanner inputStream = new Scanner(file); 										//Take the contents of the file as an input
			inputStream.nextLine(); 														//skips the first line of the csv file
			while(inputStream.hasNext()) { 													//while there is another line of the csv
				String data = inputStream.nextLine(); 										//set data to the next line of the csv
				String[] values = data.split(","); 											//splits the line into an array of values
				Process process = new Process(values[0],values[1],values[2], values[3]);
				Processes.add(process); 													//adds a new instance of Process to the list of Processes using the values from the CSV
				
			}
			inputStream.close(); //closes the input stream
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		myAlgorithm = new RoundRobin(Processes.getCopy(), 2);
		
		while (!Finished) {
			Process process = workStep();
			Time++;
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table(Processes);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void reset() {
		Time = 0;
		Finished = false;
	}
	
	public static Process workStep() {
		Process process;
		process = myAlgorithm.nextStep(Time);
		if (myAlgorithm.isFinished()) {
			Finished = true;
		}
		return process;
	}
	
}
