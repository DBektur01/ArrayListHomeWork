package serviceImpl;

import model.Reader;
import service.ReaderService;

import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    List<Reader>readers=new ArrayList<>();

    @Override
    public void saveReader(Reader reader) {
        readers.add(reader);
        System.out.println("Successfully saved ");

    }

    @Override
    public List<Reader> getAllReaders() {
        return readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader:readers){
            if (reader.getId()==id){
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader reader1:readers){
            if(reader1.getId()==id){
                readers.set(0,reader);
            }
        }
        System.out.println("Updated");
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {

    }
}
