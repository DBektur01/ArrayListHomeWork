package service.serviceImpl;


import model.Library;
import model.Reader;
import model.db.Database;
import service.ReaderService;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public void saveReader(Reader reader) {
        Database.readers.add(reader);
        System.out.println(reader);


    }
    @Override
    public List<Reader> getAllReaders() {
        return Database.readers;
    }


    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader:Database.readers){
            if (reader.getId().equals(id)){
               return reader;
            }
        }
        return null;
    }
    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (int i = 0; i <Database.readers.size(); i++) {
            if (Database.readers.get(i).getId().equals(id)){
                Database.readers.set(i,reader);
                return reader;
            }

        }System.out.println("Successfully updated");
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Reader reader:Database.readers){
            if(reader.getId().equals(libraryId)){
                for (Library library:Database.libraries){
                    if(library.getId().equals(libraryId)){
                        library.setReaders(Database.readers);
                    }
                }
            }
        }
    }
}
