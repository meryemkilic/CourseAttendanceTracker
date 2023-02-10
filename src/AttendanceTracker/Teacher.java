package AttendanceTracker;

public class Teacher extends AttendanceTracker.Person {

    public Lesson lesson;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Teacher(String name, int id, String username, String password) {
        super(name, id, username, password);
    }

    public void addAbsent(String studentName, int count, int type) {
        for (AttendanceTracker.Person person : AttendanceTracker.School.people) {
            if (person instanceof AttendanceTracker.Student && person.getName().equals(studentName)) {
                AttendanceTracker.Student student = (AttendanceTracker.Student) person;
                Absenteeism absent = new Absenteeism();
                absent.lesson = lesson;
                absent.absentLesson = count;
                absent.absentType = Absenteeism.absentTypes[type];
                student.absenteeisms.add(absent);
            }
        }
    }

    @Override
    public void showLesson() {
        for (int i = 0; i < AttendanceTracker.School.classes.size(); i++) {
            for (Lesson lesson : AttendanceTracker.Class.lessons) {
                if (lesson.teacher.getId() == super.getId()) {
                    System.out.println(AttendanceTracker.School.classes.get(i).getClassCode());
                }
            }
        }
    }

    public void coursePassingStatus() {
        for (AttendanceTracker.Person person : AttendanceTracker.School.people) {
            if (person instanceof AttendanceTracker.Student) {
                AttendanceTracker.Student student = (AttendanceTracker.Student) person;
                if (student.calculateAbsenteeism(lesson) > lesson.getMaxAbsentCount()) {
                    System.out.println("Students failing the course: " + student.getName());
                } else {
                    System.out.println("Students passing the course: " + student.getName());
                }
            }
        }
    }

    public Teacher getTeacher(int id) {
        for (AttendanceTracker.Person person : AttendanceTracker.School.people) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if ((teacher.getId()) == id) {
                    return teacher;
                }
            }
        }
        return null;
    }
}

