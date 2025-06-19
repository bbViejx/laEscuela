import java.io.PrintWriter;
import java.util.Arrays;
import java.util.*;
import java.util.Random;
import java.util.stream.Collectors;

public class PasswordServer extends SingleThreadTCPServer{

	final Random randomizer = new Random();
	
	@Override
	public void handleMessage(String message, PrintWriter out) {
		String[] args = message.split(" ");
		if(!checkArgs(args)) {
			out.println("Error. Debe enviar 3 argumentos para procesar la contrasena");
			return;
		}
		
		List<Character> password = new ArrayList<Character>();
		
		password.add(getRandomChar(args[0]));
		password.add(getRandomChar(args[1]));
		password.add(getRandomChar(args[2]));
		
		for(int passChar = 0 ; passChar < 5 ; passChar++) {
			int charType = randomizer.nextInt(2);
			password.add(getRandomChar(args[charType]));
		}
		
		Collections.shuffle(password);
		
		out.println("Password: " + password.stream().map(String::valueOf).collect(Collectors.joining("")));
	}
	
	private boolean checkArgs(String[] args) {
		return args.length==3 && !Arrays.stream(args).anyMatch(String::isEmpty);
	}
	
	private Character getRandomChar(String arg) {
		return arg.charAt(randomizer.nextInt(arg.length()));
	}
	
	public static void main(String[] args) {
		new PasswordServer().startLoop(args);
	}

}
