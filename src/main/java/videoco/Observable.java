package videoco;

// Observer Design Pattern
// Observable Interface (Subject)
public interface Observable {
	
	public void add(Observer observer);
	public void remove(Observer observer);
	public void notifyObservers();
	
}
