package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TASK;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.CountdownCommand;

public class CountdownCommandParserTest {
    private CountdownCommandParser parser = new CountdownCommandParser();

    @Test
    public void parse_validArgs_returnsCountdownCommand() {
        assertParseSuccess(parser, "1", new CountdownCommand(INDEX_FIRST_TASK));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", CountdownCommandParser.MESSAGE_COUNTDOWN_FORMAT);
    }
}
