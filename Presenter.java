import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Presenter {
    private View view;
    private List<Group> groups;
    private List<Student> students;
    private List<Lesson> lessons;

    public Presenter(View view) {
        this.view = view;
        this.groups = new ArrayList<>();
        this.students = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }
    
    public void createGroup(String numberGroup) {
        this.groups.add(new Group(numberGroup));
    }

    public void getAllGroups() {
        this.view.print(this.groups);
    }

    public void getAllStudens() {
        this.view.print(this.students);
    }

    public void createStudent(String name, UUID idGroup){
        this.students.add(new Student(name, idGroup));
    }

    public void createLesson(UUID numberGroup, String date) {
        this.lessons.add(new Lesson(numberGroup, date));
    }

    public void getAllLessons(){
        this.view.print(this.lessons);
    }

    public Group getIdGroup(String name){
        return groups.stream()
            .filter(it -> Objects.equals(it.getNumber(), name))
            .findFirst().orElse(null);
    }

    public List<Student> getAllStudentsInGroup(UUID number){
        return students.stream()
            .filter(it -> Objects.equals(it.getIdGroup(), number)).toList();
    }

    public List<Lesson> getAllLessonsStudent(String nameStudent){
        Student student = students.stream().filter(
            e -> Objects.equals(
                e.getName(), nameStudent)).findFirst().orElse(null);
        return lessons.stream().filter(
            t -> Objects.equals(
                t.getIdGroup(), student.getIdGroup())).toList();
    }
}
