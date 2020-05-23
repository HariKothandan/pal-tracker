package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    private long timeEntryId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(timeEntryId);
        timeEntries.put(timeEntry.getId(), timeEntry);
        TimeEntry getTimeEntry = timeEntries.get(timeEntry.getId());
        timeEntryId++;
        return getTimeEntry;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntries.replace(id, timeEntry);
        timeEntry.setId(id);
        return timeEntries.get(id);
    }

    @Override
    public void delete(long id) {
        timeEntries.remove(id);
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }
}
