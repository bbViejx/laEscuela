package Logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class UppercaseFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		return String.format(record.getLoggerName(),
                record.getLevel().getName(),
                formatMessage(record).toUpperCase());
	}

}
