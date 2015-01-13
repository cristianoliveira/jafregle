package jafregle;

import java.util.logging.Level;
import java.util.logging.Logger;


public class runApp {
	public static void main(String[] args) {
        try {
            //RUN! Camingoal! Camigoal!
            System.out.println(Jafregle.translate("Hello", Jafregle.Language.ENGLISH, Jafregle.Language.PORTUGUESE));
        } catch (Exception ex) {
            Logger.getLogger(runApp.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
