package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry find(long id);
    TimeEntry create(TimeEntry timeEntry);
    TimeEntry update(long id, TimeEntry timeEntry);
    List<TimeEntry> list();
    void delete(long id);
//    void createTimeEntry(TimeEntry timeEntry);
}
