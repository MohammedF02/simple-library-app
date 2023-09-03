
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Library implements LibraryInterface{
	private List<Lendable> lendable = new ArrayList<>();
	private List<LendRecord> lendRecords = new ArrayList<>();
	
	public Library(List<Lendable> lendable) {
		this.lendable = lendable;
	}
	
	@Override
	public List<Lendable> getItems() {
		return Collections.unmodifiableList(lendable);
	}

	@Override
	public List<Lendable> searchItems(String search) {
		List<Lendable> searchResult = new ArrayList<>();
		
		for (Lendable item : lendable) {
			if (item.getTitle().toLowerCase().contains(search.toLowerCase())
			 || item.getId().equals(search)
	   		 || item.getDescription().equals(search)) {
				searchResult.add(item);
			}
		}
		return Collections.unmodifiableList(searchResult);
	}

	@Override
	public List<LendRecord> getLendRecords() {
		return Collections.unmodifiableList(lendRecords);
	}

	@Override
	public List<LendRecord> getLender(String borrowerId) {
		List<LendRecord> lender = new ArrayList<>();
		for (LendRecord lendRecord : lendRecords) {
			if (lendRecord.getBorrowerId().equals(borrowerId)) {
				lender.add(lendRecord);
			}
		}
		return Collections.unmodifiableList(lender);
	}

	@Override
	public List<LendRecord> getOverdueRecords() {
		List<LendRecord> overdue = new ArrayList<>();
		LocalDate today = LocalDate.now();
		
		for (LendRecord lendRecord : overdue) {
			if (lendRecord.getDueDate().isBefore(today) && lendRecord.getReturnDate() == null) {
				overdue.add(lendRecord);
			}
		}
		return Collections.unmodifiableList(overdue);
	}

	@Override
	public boolean itemLended(String itemId, String borrowerId) {
		Lendable item = null;
		for (Lendable i : lendable) {
			if (i.getId().equals(itemId)) {
				item = i;
				break;
			}
		}
		if (item == null) {
			return false;
		}
		List<LendRecord> borrowerRecord = getLender(borrowerId);
		if (borrowerRecord.size() >= 5) {
			System.out.println("Number of maximum lended items exceeded.");
			return false;
		}
		LocalDate lendDate = LocalDate.now();
		LocalDate dueDate = lendDate.plusDays(14);
		
		lendRecords.add(new LendingRecord(item, borrowerId, lendDate, dueDate));
		return true;
	}
}