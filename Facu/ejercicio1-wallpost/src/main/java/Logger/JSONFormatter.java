package Logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import org.json.JSONObject;

public class JSONFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		JSONObject json = new JSONObject();
		json.put("message", formatMessage(record));
		json.put("level", record.getLevel().getName());
		return json.toString();
	}

}
