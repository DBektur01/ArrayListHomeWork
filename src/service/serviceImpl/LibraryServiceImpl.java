package service.serviceImpl;


import model.Library;
import model.db.Database;
import service.LibraryService;

import javax.xml.crypto.Data;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        Database.libraries.addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(id)) {
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (int i = 0; i <Database.libraries.size(); i++) {
            Library library1=Database.libraries.get(i);
            if (library1.getId().equals(id)) {
                Database.libraries.set(i,library);
                return library;
            }
        }
        return null;
    }
    @Override
    public String deleteLibrary(Long id) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(id)) {
                Database.libraries.remove(library);
                return "Library with ID " + id + " deleted successfully.";
            }
        }
        return "Library with ID " + id + " not found.";
    }
}


