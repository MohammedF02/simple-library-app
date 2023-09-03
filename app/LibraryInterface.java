
import java.util.List;

public interface LibraryInterface {
	List<Lendable> getItems();
	List<Lendable> searchItems(String search);
	List<LendRecord> getLendRecords();
	List<LendRecord> getLender(String borrowerId);
	List<LendRecord> getOverdueRecords();
	boolean itemLended(String itemId, String borrowerId);
}
