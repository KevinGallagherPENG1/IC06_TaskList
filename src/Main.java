import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //test

        Scanner keyboard = new Scanner(System.in);
        String name, dueDate, dueTime, priority;
        int count = 0;

        Task[] priorities = new Task[5];
        File binaryFile = new File("TaskList.dat");
        System.out.println("Previously saved tasks: ");

        if (binaryFile.exists() && binaryFile.length() > 1L)
        {
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));

                //typecast?????
                priorities = (Task[]) fileReader.readObject();

                while(priorities[count] != null)
                    System.out.println(priorities[count++]);

                fileReader.close();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else
            System.out.println("[No previous data, please enter new data]");

        do{
            System.out.println("Enter task name: ");
            name = keyboard.nextLine();
            System.out.println("Enter due date (dd/mm/yyyy): ");
            dueDate = keyboard.nextLine();
            System.out.println("Enter due time: ");
            dueTime = keyboard.nextLine();
            System.out.println("Enter priority (high, med, low): ");
            priority = keyboard.nextLine();
            priorities[count++] = new Task(name, dueDate, dueTime, priority);
        }while(true);

        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
            fileWriter.writeObject(priorities);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }




    }
}
