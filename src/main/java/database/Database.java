package database;

import models.Log;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<Log> logs = new ArrayList<Log>();

    public static List<Log> getLogs() {
        return logs;
    }

    public static Log getLog(int logId) {
        for (Log log : logs) {
            if (log.getId() == logId)
                return log;
        }

        return null;
    }

    public static void addLog(Log log) {
        logs.add(log);
    }

    public static void deleteLog(int logId) {
        for (Log log : logs) {
            if (log.getId() == logId) {
                logs.remove(log);
                break;
            }
        }
    }
}