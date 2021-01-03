package DataBase;
import Tours.Tour;

import javax.management.RuntimeErrorException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.FileSystemNotFoundException;
import java.util.*;

public class DataBase {
    private HashSet<Tour> Tours;
    private File ReadFile;

    public enum Statuses {
        connected,
        disconnected,
    }

    public DataBase() {
        Tours = new HashSet<Tour>();
        ReadFile = null;
    }

    public void connect(String path) throws FileNotFoundException{
        try{
            ReadFile = new File(path);
            Scanner myReader = new Scanner(ReadFile);
        }
        catch (FileNotFoundException e) {
            ReadFile = null;
            throw e;
        }
    }

    public void read() throws FileNotFoundException, IllegalArgumentException {
        if(ReadFile == null) {
            throw new FileSystemNotFoundException("Database is not connected");
        }

        FileInputStream fis = new FileInputStream(ReadFile);

        ArrayList<String> readTour = new ArrayList<String>();
        final String delimiters = " \n:{}-\r,\t";
        int readReturn;

        try{
            String buf = "";
            while ((readReturn = fis.read()) != -1) {
                char ch = (char)readReturn;

                if(delimiters.indexOf(ch) == -1) {
                    buf += ch;
                }
                else if(ch == '{' || ch == '\r') {
                    continue;
                }
                // Create and add a new tour:
                else if(ch == '}') {
                    try {
                        StringTokenizer toCreate = new StringTokenizer(readTour.get(0), " \t\r\n-,:./\\()#$%^&*");
                        String name = toCreate.nextToken();
                        String type = toCreate.nextToken();
                        readTour.remove(0);

                        Tour tmp = createGivenTour(type, name, readTour);
                        Tours.add(tmp);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("Not valid syntax");
                    }
                    buf = "";
                    readTour.clear();
                }

                // Next token:
                else if(ch == '\n') {
                    if(buf.isEmpty()) {
                        continue;
                    }
                    readTour.add(buf);
                    buf = "";
                }

                else if (ch == ':' || ch == ',' || ch == '-' || ch == ' ' || ch == '\t') {
                    buf += ' ';
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Tour createGivenTour(String type, String name, ArrayList<String> args) throws ClassNotFoundException, RuntimeErrorException {
        // Create command class:
        String ClassName = "Tours." + type;
        Class<?> NewCommandC = Class.forName(ClassName);
        Tour newTour;
        try {
            Constructor<?> NewCommandCtor = NewCommandC.getConstructor(String.class);
            newTour = ((Tour) NewCommandCtor.newInstance(name));
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        for(int i = 0; i < args.size(); ++i) {
            StringTokenizer tok = new StringTokenizer(args.get(i), " \t\r\n-,:./\\()#$%^&*");
            String field = tok.nextToken();

            while (tok.hasMoreTokens()) {
                String bufstr = tok.nextToken();
                switch (field) {
                    case "Food":        newTour.addFood(bufstr, Integer.parseInt(tok.nextToken())); break;
                    case "Transport":   newTour.addTransport(bufstr, Integer.parseInt(tok.nextToken())); break;
                    case "Places":      newTour.addPlace(bufstr, Integer.parseInt(tok.nextToken())); break;
                    case "Term":        newTour.setTerm(Integer.parseInt(bufstr)); break;
                    case "BasicPrice":  newTour.setBasicPrice(Integer.parseInt(bufstr)); break;
                    case "PricePerDay": newTour.setPricePerDay(Integer.parseInt(bufstr)); break;
                }
            }
        }

        return newTour;
    }

    public Iterator<Tour> getIterator() {
        return Tours.iterator();
    }
}
