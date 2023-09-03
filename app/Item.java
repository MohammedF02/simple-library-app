
public class Item implements Lendable{

	private String title;
	private String id;
	private String description;
	private String type;

	
	public Item (String id, String title, String description, String type) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
	}
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public float fine(int days) {
		return days;
	}

	@Override
	public int maxLendDays() {
		return 14;
	}
}
