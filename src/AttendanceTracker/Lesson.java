package AttendanceTracker;

import java.util.ArrayList;

public class Lesson {
    public Teacher teacher;
    String lessonName;
    String courseCode;
    int lessonCount;
    String teacherName;

    ArrayList<Absenteeism> absenteeisms = new ArrayList<>();

    int getMaxAbsentCount() {
        return lessonCount * 10 / 100;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getLessonCount() {
        return lessonCount;
    }

    public void setLessonCount(int lessonCount) {
        this.lessonCount = lessonCount;
    }

    public ArrayList<Absenteeism> getAbsenteeisms() {
        return absenteeisms;
    }

    public void setAbsenteeisms(ArrayList<Absenteeism> absenteeisms) {
        this.absenteeisms = absenteeisms;
    }





}
