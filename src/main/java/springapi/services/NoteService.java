package springapi.services;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springapi.entities.Note;
import springapi.repositories.NoteRepository;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    // CREATE
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    // READ
    public Note findById(String id) {
        return noteRepository.findById(id);
    }
    public List<Note> findAll() {
        return noteRepository.findAll();
    }
    // UPDATE
    public String update(String id, Note note) {
        return noteRepository.update(id, note);
    }
    // DELETE
    public String delete(String id) {
        return noteRepository.delete(id);
    }
}
