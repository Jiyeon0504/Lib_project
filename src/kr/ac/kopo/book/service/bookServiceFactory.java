package kr.ac.kopo.book.service;



public class bookServiceFactory {

	private static BookService service = null;
	
	public static BookService getInstance() {
		if(service == null) {
			service = new BookService();
		}
		return service;

	}



	

} 
