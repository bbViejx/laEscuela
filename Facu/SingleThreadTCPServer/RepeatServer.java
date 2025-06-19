import java.io.PrintWriter;

public class RepeatServer extends SingleThreadTCPServer {

	@Override
	public void handleMessage(String message, PrintWriter out) {
		String[] args = message.split(" ");
		if(!checkArguments(args, out)) {
			return;
		}

		StringBuilder builder = new StringBuilder();
		Character delimiter = args.length == 3 ? args[2].charAt(0) : ' ';

		builder.append(delimiter);
		builder.append(args[0].repeat(Integer.parseInt(args[1])));
		builder.append(delimiter);

		out.println(builder.toString());
	}

	private Boolean checkArguments(String[] args,  PrintWriter out) {
		if(!checkCantArguments(args)) {
			out.println("Error. Debe enviar entre 2 y 3 argumentos");
			return false;
		}
		if(!validateString(args[0])) {
			out.println("Error. Arg[0] no puede ser nulo ni vacio");
			return false;
		}
		if(!validateRepeat(args[1])) {
			out.println("Error. Arg[1] es requerido y debe ser un numero entero mayor a 0");
			return false;
		}
		if(args.length == 3) {
			if(!validateDelimiter(args[2])) {
				out.println("Error. Arg[2] tiene que ser un caracter");
				return false;
			}
		}
		return true;
	}

	private Boolean checkCantArguments(String[] args) {
		return args.length>=2 && args.length <=3;
	}

	private Boolean validateString(String arg) {
		return arg != null && !arg.isEmpty();
	}

	private Boolean validateRepeat(String arg)  {
		try {
			return Integer.parseInt(arg) > 0;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}

	private Boolean validateDelimiter(String arg) {
		return arg.length() == 1;
	}

	public static void main(String[] args) {
		new RepeatServer().startLoop(args);
	}

}
