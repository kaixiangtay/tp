package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TaskBuilder;

class TaskOnDatePredicateTest {
    @Test
    public void test_taskContainsDate_returnsTrue() {
        TaskOnDatePredicate predicate = new TaskOnDatePredicate(new Deadline("10/04/2021"));
        assertTrue(predicate.test(new TaskBuilder().withRecurringSchedule("[10/06/2021][sat][weekly]").build()));

        // given date on schedule's end date
        predicate = new TaskOnDatePredicate(new Deadline("08/05/2021"));
        assertTrue(predicate.test(new TaskBuilder().withRecurringSchedule("[08/05/2021][sat][weekly]").build()));

        // given date on deadline
        predicate = new TaskOnDatePredicate(new Deadline("08/05/2021"));
        assertTrue(predicate.test(new TaskBuilder().withDeadline("08/05/2021").build()));
    }

    @Test
    public void test_taskDoesNotContainDate_returnsFalse() {
        // given date not in schedule and no deadline
        TaskOnDatePredicate predicate = new TaskOnDatePredicate(new Deadline("11/04/2021"));
        assertFalse(predicate.test(new TaskBuilder().withRecurringSchedule("[10/06/2021][sat][weekly]").build()));

        // given date after schedule's end date and no deadline
        predicate = new TaskOnDatePredicate(new Deadline("08/05/2021"));
        assertFalse(predicate.test(new TaskBuilder().withRecurringSchedule("[08/04/2021][sat][weekly]").build()));

        // no schedule and wrong deadline
        predicate = new TaskOnDatePredicate(new Deadline("08/05/2021"));
        assertFalse(predicate.test(new TaskBuilder().withDeadline("09/05/2021").build()));

        // no schedule and no deadline
        predicate = new TaskOnDatePredicate(new Deadline("08/05/2021"));
        assertFalse(predicate.test(new TaskBuilder().build()));
    }
}
