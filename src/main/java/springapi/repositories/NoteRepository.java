package springapi.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springapi.entities.Note;

import java.util.List;

@Repository
public class NoteRepository {

    @Autowired
    private DynamoDBMapper mapper;

    // CREATE
    public Note save(Note note) {
        mapper.save(note);
        return note;
    }


    // READ
    public Note findById(String id) {
        return mapper.load(Note.class, id);
    }

    public List<Note> findAll() {
        return mapper.scan(Note.class, new DynamoDBScanExpression());
    }

    // UPDATE
    public String update(String id, Note note) {
        mapper.save(note, new DynamoDBSaveExpression()
                .withExpectedEntry("id", new ExpectedAttributeValue(
                        new AttributeValue().withS(id)
                )));
        return "Successfully Updated Note: " + id;
    }


    // DELETE
    public String delete(String id) {
        Note noteToDelete = mapper.load(Note.class, id);
        mapper.delete(noteToDelete);
        return "Succsessfully Deleted Note: " + id;
    }
}
