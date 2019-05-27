import java.util.Random;// import package for random number generation

//1. We need a class that inherits Thread class, AKA main class for threads
public class Producer extends Thread
{
	
	private Storage buffer;
	private final int producerID;

	//constructor for the producer class
	public Producer(Storage buffer, int producerID)
	{
		this.buffer = buffer;
		this.producerID = producerID;
		start();//we start thred, it calls method run()
	}

	public synchronized void run()
	{
		while(true)//constantly produce new products
		{
			try
			{
				//generate new product and give it a random value
				int producedElement = (new Random()).nextInt(20);
				buffer.writeElement(producedElement, producerID);
				System.out.println("Producer " + producerID + " produced: "  + producedElement);
				Thread.sleep(1500L); //just for visual representation to slow down 
			}
			catch(InterruptedException ex)
			{}
		}
	}
}