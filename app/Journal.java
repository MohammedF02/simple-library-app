
public class Journal implements Lendable{
	

		public Lendable l;
		
		public Journal(String id, String title, String description, String type) {
			l = new Item(id, title, description, type);
		}

		public Journal(Lendable j) { // for different implementations
			l = j;
		}
		
		@Override
		public String getId() {
			return l.getId();
		}
		
		@Override
		public String getTitle() {
			return l.getTitle();
		}
		
		@Override
		public String getDescription() {
			return l.getDescription();
		}
		
		@Override
		public float fine(int days) {
			return l.fine(days) * 3f;
		}

		@Override
		public int maxLendDays() {
			return l.maxLendDays();
		}


		@Override
		public String getType() {
			return l.getType();
		}
	}
