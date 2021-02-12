package Game.util;

public class MaxSizeExceededException extends Exception {

		public MaxSizeExceededException() {
			super("Authorized max sized exceeded");
		}
		
		public MaxSizeExceededException(String msg) {
			super(msg);
		}
}
