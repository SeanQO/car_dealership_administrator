package customException;


public class NotSpecializedDealerException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String notSpecialiced;

	public NotSpecializedDealerException(String notSpecialiced) {
		
		super();
		this.notSpecialiced = notSpecialiced;
	}
	
	public String getNotSpecialiced(){
		return notSpecialiced;
	}
	
	@Override
	public String getMessage() {
		return "the current dealer its not specialiced in selling " + notSpecialiced;
	}
}
