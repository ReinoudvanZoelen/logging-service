package database;

import models.LogEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<LogEntity> logs = new ArrayList<LogEntity>();

    public static List<LogEntity> getLogs() {
        return logs;
    }

    public static LogEntity getLog(int logId) {
        for (LogEntity log : logs) {
            if (log.getId() == logId)
                return log;
        }

        return null;
    }

    public static void addLog(LogEntity log) {
        logs.add(log);
    }

    public static void deleteLog(int logId) {
        for (LogEntity log : logs) {
            if (log.getId() == logId) {
                logs.remove(log);
                break;
            }
        }
    }

    public static List<LogEntity> getLogsFromStartdateToEnddate(LocalDate startDate, LocalDate endDate) {
        List<LogEntity> logs = new ArrayList<LogEntity>();

        for (LogEntity log : logs) {
            if (log.getDateOfEntry().isBefore(endDate) && log.getDateOfEntry().isAfter(startDate)) {
                logs.add(log);
            }
        }

        return logs;
    }
}