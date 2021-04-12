package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.CountdownCommand;
import seedu.address.logic.commands.DeleteFieldCommand;
import seedu.address.logic.commands.DeleteTaskCommand;
import seedu.address.logic.commands.DoneCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new CountdownCommand object
 */
public class CountdownCommandParser implements Parser<CountdownCommand> {

    public static final String MESSAGE_COUNTDOWN_FORMAT = "Invalid command format! Note that index must be positive and "
            + "within the range of the displayed list. There should also be no additional parameters.\n\n"
            + CountdownCommand.MESSAGE_USAGE;
    /**
     * Parses the given {@code String} of arguments in the context of the CountdownCommand
     * and returns a CountdownCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public CountdownCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new CountdownCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(MESSAGE_COUNTDOWN_FORMAT);
        }
    }
}
