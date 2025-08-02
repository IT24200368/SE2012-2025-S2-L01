import java.util.Scanner;

public class Marks {

public static String getGrade(int score){
 if (score >= 90) return "Grade A";
 else if (score >= 80) return "Grade B";
 else if (score >= 70) return "Grade C";
 else if (score >= 60) return "Grade D";
 else return "Fall";
}

public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

   System.out.print("Enter number of students: ");
   int n = sc.nextInt();
   
 int[][] marks = new int[n + 1][4];

 System.out.println("\nAvailable Commands:");
 System.out.println("1. Add student marks: add [studentID]");
 System.out.println("2. Update student mark: update [studentID] [subjectID]");
 System.out.println("3. Get the average for a subject: average_s [subjectID]");
 System.out.println("4. Get the average for a student: average [studentID]");
 System.out.println("5. Get the total mark of a student: total [studentID]");
 System.out.println("6. Show grades of all student: grades");
 System.out.println("7. Exit: 7 ");

 sc.nextLine();

    while (true) {
        System.out.print("\nEnter command: ");
        String input = sc.nextLine();
        String[] parts = input.split(" ");

  if (parts[0].equalsIgnoreCase("add")) {
  int id = Integer.parseInt(parts[1]);
    if (id < 1 || id > n) {
  System.out.println("Invalid student ID.");
      continue;
    }
  System.out.print("Math marks: ");
    marks[id][1] = sc.nextInt();
  System.out.print("Chemistry marks: ");
    marks[id][2] = sc.nextInt();
  System.out.print("Physics marks: ");
    marks[id][3] = sc.nextInt();
 sc.nextLine(); 
 System.out.println("Marks added for student " + id);

    } else if (parts[0].equalsIgnoreCase("update")) {
       int id = Integer.parseInt(parts[1]);
       int sub = Integer.parseInt(parts[2]);
          if (id < 1 || id > n || sub < 1 || sub > 3) {
          System.out.println("Invalid ID or subject.");
             continue;
    }
   System.out.print("Enter new mark: ");
    marks[id][sub] = sc.nextInt();
 sc.nextLine();
 System.out.println("Mark updated.");

    } else if (parts[0].equalsIgnoreCase("average_s")) {
       int sub = Integer.parseInt(parts[1]);
       if (sub < 1 || sub > 3) {
        System.out.println("Invalid subject ID.");
         continue;
     }
      int sum = 0;
       for (int i = 1; i <= n; i++) {
          sum += marks[i][sub];
        }
          double avg = (double) sum / n;
      System.out.printf("Average mark for subject %d: %.2f\n", sub, avg);

     } else if (parts[0].equalsIgnoreCase("average")) {
          int id = Integer.parseInt(parts[1]);
            if (id < 1 || id > n) {
         System.out.println("Invalid student ID.");
           continue;
       }
         double avg = (marks[id][1] + marks[id][2] + marks[id][3]) / 3.0;
        System.out.printf("Average mark for student %d: %.2f\n", id, avg);

      } else if (parts[0].equalsIgnoreCase("total")) {
          int id = Integer.parseInt(parts[1]);
        if (id < 1 || id > n) {
      System.out.println("Invalid student ID.");
         continue;
      }
        int total = marks[id][1] + marks[id][2] + marks[id][3];
     System.out.println("Total mark for student " + id + ": " + total);

     }else if (parts[0].equalsIgnoreCase("grades")) {
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Student", "Math", "Chemistry", "Physics");
        for (int i = 1; i <= n; i++) {
            String g1 = getGrade(marks[i][1]);
            String g2 = getGrade(marks[i][2]);
            String g3 = getGrade(marks[i][3]);
            System.out.printf("%-10d %-10s %-10s %-10s\n", i, g1, g2, g3);
        }

      } else if (parts[0].equals("7")) {
                System.out.println("Exit ");
                break;

            } else {
                System.out.println("Invalid command.");
            }
        }

        sc.close();
    }
}


