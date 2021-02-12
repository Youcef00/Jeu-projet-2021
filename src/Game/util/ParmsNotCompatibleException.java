package Game.util;

public class ParmsNotCompatibleException extends Exception {

		public ParmsNotCompatibleException() {
			super("Authorized max sized exceeded");
		}
		
		public ParmsNotCompatibleException(String msg) {
			super(msg);
		}
}
