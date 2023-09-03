
public interface Lendable {
	String getTitle();
	String getId();
	String getDescription();
	String getType();
	float fine(int days);
	int maxLendDays();
}