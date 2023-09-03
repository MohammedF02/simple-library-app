import java.time.LocalDate;

public interface LendRecord {
	Lendable getItem();
	String getBorrowerId();
	LocalDate getLendDate();
	LocalDate getDueDate();
	LocalDate getReturnDate();
	void setReturnDate(LocalDate returnDate);
	float fine();
}
