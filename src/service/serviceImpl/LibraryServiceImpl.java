package serviceImpl;

import model.Library;
import service.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    List<Library>libraries=new ArrayList<>();

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        return null;
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library:libraries){
            if (library.getId()==id){
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (Library library1:libraries){
            if (library1.getId()==id){
                libraries.add(library);
            }
        }
        return library;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (Library library:libraries){
            if (library.getId()==id){
                libraries.remove(library);
            }
        }
        return "Successfully deleted";
    }
}
