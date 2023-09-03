
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LendingRecord implements LendRecord {
	private Lendable lendable;
	private String borrowerId;
	private LocalDate lendDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	
	public LendingRecord(Lendable item, String borrowerId, LocalDate lendDate, LocalDate dueDate) {
		this.lendable = item;
		this.borrowerId = borrowerId;
		this.lendDate = lendDate;
		this.dueDate = dueDate;
	}

	@Override
	public Lendable getItem() {
		return lendable;
	}

	@Override
	public String getBorrowerId() {
		return borrowerId;
	}

	@Override
	public LocalDate getLendDate() {
		return lendDate;
	}

	@Override
	public LocalDate getDueDate() {
		return dueDate;
	}

	@Override
	public LocalDate getReturnDate() {
		return returnDate;
	}

	@Override
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	// Calculate the fine if the date of returned is overdue
	@Override
	public float fine() {
		if (returnDate == null) {
			return 0f;
		}
		int daysLateAfterDueDate = (int) ChronoUnit.DAYS.between(dueDate, returnDate);
		if (daysLateAfterDueDate <= 0) {
			return 0;
		}
		float fine = 0;
		if (lendable instanceof Book || lendable instanceof Journal) {
			fine = ((Book) lendable).fine(daysLateAfterDueDate);
		} else if (lendable instanceof Video) {
			fine = ((Video) lendable).fine(daysLateAfterDueDate);
		} else if (lendable instanceof TechnicalPaper) {
			fine = ((TechnicalPaper) lendable).fine(daysLateAfterDueDate);
		}
		return fine;
	}
}
