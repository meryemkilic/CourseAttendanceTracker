package AttendanceTracker;

import java.util.ArrayList;

public class Class {

    private String classCode;
    static ArrayList<Lesson> lessons = new ArrayList<>();

    public Class(String classCode) {
        this.classCode = classCode;
    }

    public Class(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    void addLesson(Teacher teacher, String lessonName, String courseCode, int lessonCount) {

        Lesson lesson = new Lesson();
        lesson.teacher = teacher;
        lesson.lessonName = lessonName;
        lesson.courseCode = courseCode;
        lesson.lessonCount = lessonCount;
        lessons.add(lesson);
    }


}
