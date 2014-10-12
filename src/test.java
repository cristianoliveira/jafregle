
import java.util.logging.Level;
import java.util.logging.Logger;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
            try {
                //RUN! Camingoal! Camigoal!
                System.out.println(FreeGtranslate.translate(args[0], FreeGtranslate.Language.ENGLISH, FreeGtranslate.Language.PORTUGUESE));
            } catch (Exception ex) {
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

}
