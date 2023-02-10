package AttendanceTracker;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test {
    Login login;

    public Test() {
        login = new Login();
    }

    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.setUsername("Manager");
        manager.setPassword("123");
        AttendanceTracker.School.people.add(manager);


        Test test = new Test();
        test.Display();
    }

    void Display() {
        Scanner scan = new Scanner(System.in);
        String username, password;

        int a = 0;
        int total = 0;

        System.out.println("\n\nSelect any one for login procedure\n\n" + "1.Manager \n" + "2.Teacher \n" + "3.Student");
        System.out.print("\n\nPlease enter your choice : ");

        try {
            a = scan.nextInt();
            System.out.print("\nEnter Username : ");
            username = scan.next();
            System.out.print("Enter Password : ");
            password = scan.next();

            switch (a) {
                case 1:
                    Manager manager = login.checkManager(username, password); // AttendanceTracker.Login verification for Manager
                    if (manager == null) {
                        System.out.println("\n\nWrong username or password. Try again!");
                        Display();
                    }
                    while (manager != null) {
                        System.out.print("\n----------" + username + "----------");
                        System.out.println("\n" +
                                "1)Press to add teacher \n" +
                                "2)Press to add class and lesson \n" +
                                "3)Press to add student \n" +
                                "4)Press to show all people \n" +
                                "5)Press to show all student who failed \n" +
                                "6)Press to logout\n");

                        System.out.print("\n\nPlease enter your choice : ");
                        a = scan.nextInt();

                        switch (a) {

                            case 1:

                                System.out.print("Write teacher's name:  ");
                                String teacherName = scan.nextLine();
                                teacherName = scan.nextLine();

                                System.out.print("Write teacher's id: ");
                                int teacherId = scan.nextInt();

                                System.out.print("Write teacher's username: ");
                                String teacherUsername = scan.nextLine();
                                teacherUsername = scan.nextLine();

                                System.out.print("Write teacher's password: ");
                                String teacherPassword = scan.nextLine();

                                manager.addTeacher(teacherName, teacherId, teacherUsername, teacherPassword);
                                AttendanceTracker.School.people.get(AttendanceTracker.School.people.size() - 1);
                                System.out.println("\nTeacher's name: " + teacherName + "   Teacher's id: " + teacherId + "    Teacher's username: " + teacherUsername + "    Teacher's password: " + teacherPassword);
                                continue;


                            case 2:
                                Lesson lesson = new Lesson();

                                System.out.print("Write class code: ");
                                String classCode = scan.nextLine();
                                classCode = scan.nextLine();

                                System.out.print("Write lesson's name: ");
                                String lessonName = scan.nextLine();

                                System.out.print("Write lesson's code: ");
                                String courseCode = scan.nextLine();

                                System.out.print("Write lesson's count: ");
                                int lessonCount = scan.nextInt();

                                System.out.print("Write lesson's teacher name: ");
                                String lessonTeacherName = scan.next();

                                manager.addLessonToClass(lesson, classCode);

                                System.out.println("\nLesson's name: " + lessonName + "   Lesson's code: " + courseCode + "    Lesson's count: " + lessonCount + "    Lessons teacher name : " + lessonTeacherName);

                                manager.addLesoon(lessonName, courseCode, lessonCount, lessonTeacherName);


                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + a);

                            case 3:

                                System.out.print("Write student's name:  ");
                                String studentName = scan.nextLine();
                                studentName = scan.nextLine();

                                System.out.print("Write student's id: ");
                                int studentId = scan.nextInt();

                                System.out.print("Write student's username: ");
                                String studentUsername = scan.nextLine();
                                studentUsername = scan.nextLine();

                                System.out.print("Write student's password: ");
                                String studentPassword = scan.nextLine();

                                manager.addStudent(studentName, studentId, studentUsername, studentPassword);
                                System.out.println("\nStudent's name: " + studentName + "   Student's id: " + studentId + "    Student's username: " + studentUsername + "    Student's password: " + studentPassword);


                                continue;
                            case 4:
                                manager.showAllPeople();
                                continue;
                            case 5:
                                manager.showTotalFailers();
                                continue;
                            case 6:
                                Display();

                        }
                    }


                case 2:
                    Teacher teacher = login.checkTeacher(username, password); // AttendanceTracker.Login verification for Teacher
                    if (teacher == null) {
                        System.out.println("\n\nWrong username or password. Try again!");
                        Display();
                    }
                    while (teacher != null) {
                        System.out.print("\n----------" + username + "----------");
                        System.out.println("\n" +
                                "1)Press to add absent \n" +
                                "2)Press to show course passing status  \n" +
                                "3)Press to logout\n");

                        System.out.print("\n\nPlease enter your choice : ");
                        a = scan.nextInt();

                        switch (a) {

                            case 1:
                                System.out.print("Please enter your student name : ");
                                String studentName = scan.next();
                                System.out.println("Please enter your absenteeism count : ");
                                int count = scan.nextInt();
                                System.out.println("Please enter your absenteeism type : ");
                                System.out.println("Please press 1 to Excused" + "\nPlease press 2 to Unexcused");
                                int type = scan.nextInt();
                                teacher.addAbsent(studentName, count, type - 1);
                                continue;
                            case 2:
                                teacher.coursePassingStatus();
                                continue;
                            case 3:
                                Display();
                                continue;

                        }
                    }
                case 3:
                    Student student = login.checkStudent(username, password); // AttendanceTracker.Login verification for Teacher
                    AttendanceTracker.School school = new AttendanceTracker.School();
                    if (student == null) {
                        System.out.println("\n\nWrong username or password. Try again!");
                        Display();
                    }
                    while (student != null) {
                        System.out.print("\n----------" + username + "----------");
                        System.out.println("\n" +
                                "1)Press to show absenteeism \n" +
                                "2)Press to show all lessons  \n" +
                                "3)Press to log out");
                        System.out.print("\n\nPlease enter your choice : ");
                        a = scan.nextInt();
                        switch (a) {

                            case 1:
                                student.showAbsenteeism();
                                continue;
                            case 2:
                                student.showLesson();
                                break;
                            case 3:
                                Display();
                            default:

                        }

                    }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}