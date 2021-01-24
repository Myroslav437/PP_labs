package Selector;
import DataBase.DataBase;
import Tours.Tour;
import UI.TUI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Predicate;

public class Selector {
    private DataBase DB;
    private DataBase.Statuses status;
    private HashSet<Tour> Filtered;

    public Selector() {
        DB = new DataBase();
        status = DataBase.Statuses.disconnected;
        Filtered = new HashSet<>();
    }

    public void connect(String path) throws IOException {
        try {
            DB.connect(path);
        }
        catch (IOException e) {
            status = DataBase.Statuses.disconnected;
            throw e;
        }
        status = DataBase.Statuses.connected;
    }

    public void read() throws IOException {
        if(TUI.selector.getStatus() != DataBase.Statuses.connected) {
            throw new IOException("Database is not connected");
        }

        try {
            DB.read();
        }
        catch (FileNotFoundException e) {
            status = DataBase.Statuses.disconnected;
            throw new IOException(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            status = DataBase.Statuses.disconnected;
            throw new IOException(e.getMessage());
        }
        status = DataBase.Statuses.connected;
    }

    public HashSet<Tour> getAll() throws IOException {
        if(TUI.selector.getStatus() != DataBase.Statuses.connected) {
            throw new IOException("Database is not connected");
        }
        HashSet<Tour> res = new HashSet<Tour>();
        if(Filtered.isEmpty()) {
            var iterator = DB.getIterator();
            while (iterator.hasNext()) {
                res.add(iterator.next());
            }
        }
        else {
            res = Filtered;
        }

        Filtered = res;
        return res;
    }

    public HashSet<Tour> getIf(Predicate<Tour> predicate) throws IOException {
        HashSet<Tour> tmp;
        HashSet<Tour> res = new HashSet<>();
        tmp = Filtered.isEmpty() ? getAll() : Filtered;

        Iterator<Tour> iterator = tmp.iterator();
        while (iterator.hasNext()) {
            Tour tmp_tour = iterator.next();
            if(predicate.test(tmp_tour)) {
                res.add(tmp_tour);
            }
        }

        Filtered = res;
        return res;
    }

    public void clearFilter() throws IOException {
        if(TUI.selector.getStatus() != DataBase.Statuses.connected) {
            throw new IOException("Database is not connected");
        }
        Filtered.clear();
    }

    public DataBase.Statuses getStatus() {
        return status;
    }
}
