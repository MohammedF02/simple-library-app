
public class Book implements Lendable {

	private Lendable lendable;
	
	public Book(String id, String title, String description, String type) {
		lendable = new Item(id, title, description, type);
	}

	public Book(Lendable b) { // for different implementations
		lendable = b;
	}
	
	@Override
	public String getId() {
		return lendable.getId();
	}
	
	@Override
	public String getTitle() {
		return lendable.getTitle();
	}
	
	@Override
	public String getDescription() {
		return lendable.getDescription();
	}
	
	@Override
	public float fine(int days) {
		return lendable.fine(days) * 3f;
	}

	@Override
	public int maxLendDays() {
		return lendable.maxLendDays();
	}


	@Override
	public String getType() {
		return lendable.getType();
	}
}
