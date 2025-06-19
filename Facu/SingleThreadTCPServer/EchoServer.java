
import java.io.PrintWriter;

public class EchoServer extends SingleThreadTCPServer {
   
    public void handleMessage(String message, PrintWriter out) {
        out.println(message);
    }
    
    public boolean evalBreakMessage(String message) {
    	return message.equalsIgnoreCase("!close"); 	
    }

    public static void main(String[] args) {

        new EchoServer().startLoop(args);

    }

}