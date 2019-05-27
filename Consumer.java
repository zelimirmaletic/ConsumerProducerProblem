

public class Consumer extends Thread
{
	private Storage buffer;
	private final int consumerID;

	public Consumer(Storage buffer, int id)
	{
		this.buffer = buffer;
		this.consumerID = id;
		start();
	}

	public synchronized void run()
	{
		while(true)
		{
			try
			{
				System.out.println("Consumer " + consumerID + " took: " + buffer.readElement(consumerID));
				Thread.sleep(1500L);
			}catch (InterruptedException ex)
			{}
		}
	}
}