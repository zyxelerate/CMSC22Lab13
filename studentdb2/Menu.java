import java.util.*;
import java.io.*;

public class Menu {
  private static final String FILE_NAME = "out.ser";
    public static void main(String[] args){
        List<Student> students = new ArrayList<Student>();
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
           File fin = new File(FILE_NAME);
            fis = new FileInputStream(fin);
            ois = new ObjectInputStream(fis);
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\t\t\tMENU");
        System.out.println("1. Add a student\n2. Remove a student\n3. View data\n4. Save data\n5. Exit");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        s.nextLine();
        int flag = 1;
     do {
             if (choice == 1) {
             System.out.print("Enter Student Number: ");
             String sn = s.nextLine();
                 for (Student toCheck : students) {
                     if ((toCheck.getStudentNumber()).equals(sn)) {
                         System.out.println("A Student with the same student number already exist");
                         flag = 0;
                     }
                 }
             if(flag == 0){
               break; 
             }
             System.out.print("Enter First Name: ");
             String fn = s.nextLine();
             System.out.print("Enter Middle Initial: ");
             String mi = s.nextLine();
             System.out.print("Enter Last Name: ");
             String ln = s.nextLine();
             System.out.print("Enter course: ");
             String course = s.nextLine();
             System.out.print("Enter year level: ");
             String yrl = s.nextLine();
             int yl = Integer.parseInt(yrl);
             System.out.print("Enter crush name: ");
             String cN = s.nextLine();
             System.out.print("Enter favorite subject code: ");
             String fsC = s.nextLine();
             System.out.print("Enter favorite subject description: ");
             String fsd = s.nextLine();
             Student n = new Student(sn, fn, mi.charAt(0), ln, course, yl, cN, fsC, fsd);
             students.add(n);
             System.out.println("Done");
         } else if (choice == 2) {
             System.out.println("Enter Student Number of the Student you want to remove: ");
             String snRemoved = s.next();
             for (Student toBeRemoved : students) {
                 if (toBeRemoved.getStudentNumber().equals(snRemoved)) {
                     students.remove(toBeRemoved);
                     break;
                 }
             }
             System.out.println("Done");
         } else if (choice == 3) {
             int flager = 1;
             System.out.println("Enter Student Number of the Student you want to view: ");
             String snToView = s.next();
               for (Student toView : students) {
                 if ((toView.getStudentNumber()).equals(snToView)) {
                     System.out.println(String.format("Student Number: %s\nFirst Name: %s\nMiddle Initial: %c\nLast Name: %s\ncourse: %s\nYear Level: %d\nCrush Name: %s\nFavorite Subject:\n Code: %s\n Description: %s\n",toView.getStudentNumber(),toView.getFirstName(),toView.getMiddleInitial(),toView.getLastName(),toView.getCourse(),toView.getYearLevel(), toView.getCrushName(), toView.getFaveSubj().getCourseCode(), toView.getFaveSubj().getCourseDescription()));
                     flager = 0;
                 }
             }
             if(flager == 1){
                 System.out.println("Student is not enrolled or has been removed");
             }
             System.out.println("Done");
         } else if (choice == 4) {
             try {
                 File file = new File(FILE_NAME);
                 if (!file.exists()) {
                     file.createNewFile();
                 }
                 File fout = new File(FILE_NAME);
                 fos = new FileOutputStream(fout);
                 oos = new ObjectOutputStream(fos);
                 oos.writeObject(students);
                 oos.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }finally {
               try {
                 fos.close();
               } catch (IOException e) {
                 e.printStackTrace();
               }
             }
         }
         System.out.println("1. Add a student\n2. Remove a student\n3. View data\n4. Save data\n5. Exit");
         choice = s.nextInt();
     }while(choice != 5);

    }

}