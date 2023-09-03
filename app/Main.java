
public class Main {
	public static void main(String[] args) {
		
		GlobalVariables.lendable.add(new Book("123", "History", "about history", "Book"));
		GlobalVariables.lendable.add(new Video("345", "Software Engineering", "Coding", "Video"));
		GlobalVariables.lendable.add(new Journal("789", "Biology", "advancements in microbiology", "Journal"));
		GlobalVariables.lendable.add(new TechnicalPaper("222", "IT Capstone", "research in robotics", "Technical Paper"));
		GlobalVariables.lendable.add(new TechnicalPaper("741", "IT Capstone", "research in robotics", "Technical Paper"));
		GlobalVariables.lendable.add(new TechnicalPaper("852", "IT Capstone", "research in robotics", "Technical Paper"));
		
		Library library = new Library(GlobalVariables.lendable);
		Terminal terminal = new Terminal(library);
		terminal.run();
	}
}