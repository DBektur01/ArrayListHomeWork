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
        Reader reader1 = new Reader();
        for (Reader reader:Database.readers){
            if (reader.getId().equals(id)){
               reader1 = reader;
            }else {
                System.out.println("Not found!");
            }
        }
        return reader1;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader reader1:Database.readers){
            if(reader1.getId().equals(id)){
                Database.readers.set(0,reader);
            }
        }
        return reader;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Reader reader:Database.readers){
            if(reader.getId().equals(libraryId)){
                for (Library library:Database.libraries){
                    if(library.getId().equals(libraryId)){
                        library.getReaders().add(reader);
                    }
                }
            }
        }
    }
}
