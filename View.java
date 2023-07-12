import java.util.List;
import java.util.Scanner;

public class View {
    private Presenter presenter;
    private Scanner scanner;

    public View() {
        this.presenter = new Presenter(this);
        this.scanner = new Scanner(System.in);
    }

    public <T> void print(List<T> list){
        System.out.println(list.get(0).getClass().getName() + " list: ");
        for (T element : list) {
            System.out.println(element);
        }
        System.out.println();
    }

    public String input(String text){
        System.out.print(text + ": ");
        return scanner.nextLine();
    }

    public void start(){
        System.out.println(
            "Commands:\n" +
            "0 or q or exit- stop apps.\n" +
            "1 - Create group.\n" +
            "2 - View all groups.\n" +
            "3 - Create Student.\n" +
            "4 - View all students in group.\n" + 
            "5 - View all students.\n" +
            "6 - Create lesson.\n" +
            "7 - View all lessons.\n" +
            "8 - View lessons student.\n"
        );
        while (true){
            String command = this.input("Enter command");

            if ("exit".equals(command) || "q".equals(
                command) || "0".equals(command)) {
                break;
            }
            else if ("1".equals(command)){
                this.presenter.createGroup(
                    this.input("Enter number group"));
            }
            else if ("2".equals(command)){
                this.presenter.getAllGroups();
            }
            else if ("3".equals(command)){
                this.presenter.createStudent(
                    this.input("Enter name"),
                    presenter.getIdGroup(this.input(
                        "Enter number group")).getId());
            }
            else if ("4".equals(command)){
                this.print(
                    this.presenter.getAllStudentsInGroup(
                        presenter.getIdGroup(this.input(
                            "Enter number group")).getId()));
            }
            else if ("5".equals(command)){
                this.presenter.getAllStudens();
            }
            else if ("6".equals(command)){
                this.presenter.createLesson(
                    presenter.getIdGroup(
                        this.input("Enter number group")).getId(),
                        this.input("Enter date"));
            }
            else if ("7".equals(command)){
                this.presenter.getAllLessons();
            }
            else if ("8".equals(command)){
                this.print(
                    this.presenter.getAllLessonsStudent(
                        this.input("Enter name student")));
            }
        }
    }
    
}
