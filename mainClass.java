
public class mainClass
{
	public static void main(String[] args) 
	{
			Storage myStorage = new Storage();

			new Producer(myStorage, 1);
			new Producer(myStorage, 2);
			new Producer(myStorage, 3);
			new Producer(myStorage, 4);
			new Producer(myStorage, 5);

			new Consumer(myStorage,1);
			new Consumer(myStorage,2);
			new Consumer(myStorage,3);
			new Consumer(myStorage,4);
			new Consumer(myStorage,5);

			try
			{
				Thread.sleep(10000);
			}catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
			System.exit(0);
	}
}