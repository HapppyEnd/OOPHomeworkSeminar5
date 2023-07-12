import java.util.Objects;
import java.util.UUID;

public class Student {
    private UUID id;
    private String name; 
    private UUID idGroup;

    public UUID getIdGroup() {
        return idGroup;
    }

    public Student(String name, UUID idGroup) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.idGroup = idGroup;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Student object = (Student) obj;
        return this.id.equals(object.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return String.format("Name: %s", this.name);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
