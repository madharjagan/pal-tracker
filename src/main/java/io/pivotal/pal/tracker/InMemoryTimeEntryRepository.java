package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> timeEntries = new HashMap<>();
    long key = 0;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        key = key + 1 ;
        TimeEntry timeEntryToCreate = new TimeEntry(key, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(),timeEntry.getHours());
        timeEntries.put(key,timeEntryToCreate);
        return timeEntries.get(key);
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntries.replace(id, new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(),timeEntry.getHours()));
        return timeEntries.get(id);
    }

    @Override
    public void delete(long id) {
        timeEntries.remove(id);
    }
}

