
import java.util.List;
import java.util.Scanner;

public class Terminal {
	private Library library;

	public Terminal(Library library) {
		this.library = library;
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1: Search items");
			System.out.println("2: Lend item");
			System.out.println("3: Show lending records");
			System.out.println("4: Show lending records by borrower");
			System.out.println("5: Show overdue lended records");
			System.out.println("0: Exit");

			System.out.print("Select an option: ");
			int options = scanner.nextInt();
			scanner.nextLine();

			switch (options) {
			case 1:
				System.out.print("Search for: ");
				String search = scanner.nextLine();

				List<Lendable> lendable = library.searchItems(search);
				System.out.printf("%-10s %-20s %-20s %-20s%n", "ID", "Title", "Description", "Type");

				for (Lendable item : lendable) {
					System.out.printf("%-10s %-20s %-20s %-20s%n", item.getId(), item.getTitle(), item.getDescription(), item.getType());
				}
				break;
			case 2:
				System.out.print("Enter item ID: ");
				String itemId = scanner.nextLine();
				System.out.print("Enter borrower ID: ");
				String borrowerId = scanner.nextLine();

				boolean lended = library.itemLended(itemId, borrowerId);
				if (lended) {
					System.out.println("Lending was successful.");
				} else {
					System.out.println("Lending failed");
				}
				break;
			case 3:
				List<LendRecord> records = library.getLendRecords();
				printLendRecords(records);
				break;
			case 4:
				System.out.print("Enter Borrower ID: ");
				String borrowerID = scanner.nextLine();

				List<LendRecord> borrowerRecords = library.getLender(borrowerID);
				printLendRecords(borrowerRecords);
				break;
			case 5:
				List<LendRecord> overdueRecords = library.getOverdueRecords();
				printLendRecords(overdueRecords);
				break;
			case 0:
				System.out.println("Goodbye!");
				return;
			default:
				System.out.println("Invalid Option.");
				break;
			}
		}
	}

	private void printLendRecords(List<LendRecord> records) {
		System.out.printf("%-15s %-40s %-40s %-20s %-10s%n", "ID", "Title", "Borrower ID", "Due Date", "Fine");
		float totalFine = 0;
		for (LendRecord lendRecord : records) {
			Lendable item = lendRecord.getItem();
			float fine = lendRecord.fine();
			totalFine += fine;
			System.out.printf("%-15s %-40s %-40s %-20s %-10s%n", item.getId(), item.getTitle(),
					lendRecord.getBorrowerId(), lendRecord.getDueDate(), fine);
		}
		System.out.println("Total fine: " + totalFine);
	}
}