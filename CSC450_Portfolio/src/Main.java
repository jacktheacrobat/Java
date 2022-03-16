public class Main {
	
	private static int count = 0;
	
	public static void main(String[] args) {
	
		//Create thread1 which will count up from 0 to 20
		Thread thread1 = new Thread(new Runnable() {
	
			public void run() {
				for(; count < 21; count++) {
					System.out.println("Thread 1: " + count);
					try {
						Thread.sleep(200);	//Program waits 200ms before resuming execution
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	
		//Create thread2 which will count down from 20 to 0
		Thread thread2 = new Thread(new Runnable() {
	
			public void run() {
				for (; count > 0;) {
					count--;
					System.out.println("Thread 2: " + count);
					try {
						Thread.sleep(200);	//Program waits 200ms before resuming execution
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});	
		
		//Initiate execution of thread1
		thread1.start();
		//Terminates thread when task is complete
		try {
			thread1.join();
			System.out.println("Thread 1 is done.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Initiate execution of thread2
		thread2.start();
		//Terminates thread when task is complete
		try {
			thread2.join();
			System.out.println("Thread 2 is done.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
