import java.util.UUID;

public class Lesson {
    private UUID id, idGroup;
    private String date;
    private int numberLesson;
    static int count = 1;

    public Lesson(UUID idGroup, String date) {
        this.id = UUID.randomUUID();
        this.idGroup = idGroup;
        this.date = date;
        this.numberLesson = count;
        count++;
    }

    @Override
    public String toString() {
        return "Lesson " + this.numberLesson;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdGroup() {
        return idGroup;
    }

    public String getDate() {
        return date;
    }

    public int getNumberLesson() {
        return numberLesson;
    }
}
