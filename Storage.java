import java.util.LinkedList;

public class Storage
{
  //1. create buffer for storing using Linked List
  protected LinkedList<Integer> buffer = new LinkedList<>();
  //2. Define maximal number of elements in buffer AKA products
  protected final int maximalCapacity = 10;

  //3. Now we need a method for reading from buffer
  public synchronized int readElement(int consumerID) throws InterruptedException
  {
  	//while there is nothing to take from buffer this method waits
  	while(buffer.isEmpty())
  	{
  		System.out.println("Consumer " + consumerID + " is blocked, there are no products to take.");
  		wait();
  	}
  	//So, if there are elements in buffer we take one
  	int product = buffer.removeFirst();
  	//If there is a free space for new products notufy method to generet new
	  if(buffer.size()<maximalCapacity)
	  {
		notify();
	  }

  	//return given product
  	return product;
  }
  //4. Now we need a method for generating elements AKA products
  public synchronized void writeElement(int newElement, int producerID) throws InterruptedException
  {
  	//while the buffer is full, we do not need to generate new elements
  	while(buffer.size()==maximalCapacity)
  	{
  		System.out.println("Producer "+producerID+" blocked, number of products in storage: "+buffer.size());
  		wait();
  	}
  	//So if there IS a space for new products we add them to buffer
  	buffer.addLast(newElement);
  	//So when we generate at least one element we notify synchronized method read
	  if(buffer.size()==1)
	  {
		notify();
	  }
  		
  }
}
