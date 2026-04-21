package src;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {
    private static final String FILE_PATH = "contacts.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveContacts(List<Contact> contacts) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(contacts, writer);
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public static List<Contact> loadContacts() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type contactListType = new TypeToken<ArrayList<Contact>>(){}.getType();
            List<Contact> contacts = gson.fromJson(reader, contactListType);
            return contacts != null ? contacts : new ArrayList<>();
        } catch (IOException e) {
            // File doesn't exist yet, return empty list
            return new ArrayList<>();
        }
    }
}