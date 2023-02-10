package AttendanceTracker;

import java.util.ArrayList;

public class Student extends Person {

    AttendanceTracker.Class class1;

    static ArrayList<Lesson> lessons = new ArrayList<>();
    static ArrayList<Absenteeism> absenteeisms = new ArrayList<>();

    public Student(String name, int id, String username, String password) {

        super(name, id, username, password);
    }

    int calculateAbsenteeism() {
        int totalAbsenteeism = 0;
        for (Absenteeism absenteeism : absenteeisms) {
            if (absenteeism.absentType == Absenteeism.absentTypes[1]) {
                totalAbsenteeism += absenteeism.absentLesson;
            }
        }
        return totalAbsenteeism;
    }

    int calculateAbsenteeism(Lesson lesson) {
        int totalAbsenteeism = 0;
        for (Absenteeism absenteeism : absenteeisms) {
            if (absenteeism.lesson == lesson) {
                if (absenteeism.absentType == Absenteeism.absentTypes[1]) {
                    totalAbsenteeism += absenteeism.absentLesson;
                }
            }
        }
        return totalAbsenteeism;
    }

    @Override
    public void showLesson() {
        for (Lesson lesson : lessons) {
            System.out.println(lesson.lessonName + " " + lesson.teacher.getName());
        }
    }

    public void showAbsenteeism() {
        for (Lesson lesson : lessons) {
            System.out.println(lesson.lessonName+" Absence Status: " + calculateAbsenteeism(lesson));
            System.out.println(lesson.lessonName+ " Remaining AttendanceTracker.Absenteeism Count: " + (lesson.getMaxAbsentCount() - calculateAbsenteeism(lesson)));
            System.out.println("----------");
        }
    }

}


