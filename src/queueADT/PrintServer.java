package queueADT;
import java.util.Scanner;

// Test class for QueueArrayBased
public class PrintServer {
	
	static Scanner in = new Scanner(System.in);
	
	static final int MAX_MEMBERS = 5;
	
	public static void displayMenu() {
		System.out.println("Welcome to PrintServer! Please select a number from the list.");
		System.out.println("1.   Enqueue a job");
		System.out.println("2.   Dequeue a job");
		System.out.println("3.   Peek at the job at front of the queue");
		System.out.println("4.   Empty the queue");
		System.out.println("5.   Display all jobs");
		System.out.println("6.   Quit the program");
		System.out.println();
	}

	public static void main(String[] args) {
		QueueArrayBased queue = new QueueArrayBased();
		int menuChoice = 0;
		
		// Loop until user quits the program
		do {
			displayMenu();
			
			menuChoice = in.nextInt();
			switch(menuChoice) {
				case 1: {
					System.out.println("Enter job details!");
					System.out.print("Job ID: ");
					in.next();
					String id = in.nextLine();
					System.out.print("Document name: ");
					String doc_name = in.nextLine();
					System.out.print("Number of pages: ");
					String num_pages = in.nextLine();
					
					String[] members = new String[MAX_MEMBERS];
					System.out.print("Number of members (max. 5): ");
					int num_members = in.nextInt();
					
					for (int i = 1; i <= num_members; i++) {
						System.out.print("Member " + i + "'s name: ");
						in.next();
						String member_name = in.nextLine();
						members[i-1] = member_name;
					}
					
					PrintJob job = new PrintJob(id, doc_name, members, num_pages);
					queue.enqueue(job);
					System.out.println();
					break;
				}
				case 2: {
					System.out.println("Item dequeued: " + queue.dequeue());
					System.out.println();
					break;
				}
				case 3: {
					System.out.println("Item at queue front: " + queue.peek());
					System.out.println();
					break;
				}
				case 4: {
					queue.dequeueAll();
					break;
				}
				case 5: {
					queue.displayQueue();
					System.out.println();
					System.out.println();
					break;
				}
			}
		} 
		while (menuChoice < 6);

	}

}