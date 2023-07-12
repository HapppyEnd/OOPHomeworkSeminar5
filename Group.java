import java.util.UUID;

public class Group {
    private UUID id;
    private String number;

    public Group(String number) {
        this.id = UUID.randomUUID();
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Group number " + number;
    }

    @Override
    public boolean equals(Object obj) {
        Group num = (Group) obj;
        return this.number == num.number;
    }
}
