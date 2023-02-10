package AttendanceTracker;

import java.util.ArrayList;

public class School {
    static ArrayList<Person> people = new ArrayList<>();

    ArrayList<Lesson> lessons = new ArrayList<>();

    static ArrayList<Class> classes = new ArrayList<>();

    public static void addStudent(String name, int id, String username, String password) {

        for (Person person : School.people) {
            if (person instanceof Student) {
                Student student = (Student) person;
            }
        }
        Student student = new Student(name, id, username, password);
        student.setName(name);
        student.setId(id);
        student.setUsername(username);
        student.setPassword(password);
        people.add(student);
    }

    public static void addTeacher(String name, int id, String username, String password) {
        for (Person person : School.people) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
            }
        }
        Teacher teacher = new Teacher(name, id, username, password);
        teacher.setName(name);
        teacher.setId(id);
        teacher.setUsername(username);
        teacher.setPassword(password);
        people.add(teacher);
    }

    public void addLesson(String lessonName, String courseCode, int lessonCount, String teacherName) {

        Lesson lesson = new Lesson();
        lesson.lessonName = lessonName;
        lesson.courseCode = courseCode;
        lesson.lessonCount = lessonCount;
        lessons.add(lesson);
    }

    /*public void addLessonToClass(Lesson lesson, String classCode) {
        for (Class class1 : School.classes) {
            if (class1.getClassCode().equals(classCode)) {
                class1.getLessons().add(lesson);
                for (Person person : School.people) {
                    if (person instanceof Student) {
                        Student student = (Student) person;
                        if (student.class1.getClassCode() == class1.getClassCode()) {
                            student.lessons.add(lesson);
                        }
                    }
                }
            }
        }
    }*/

}



