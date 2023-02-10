package AttendanceTracker;

public class Manager extends AttendanceTracker.Person {

    public Manager(String name, int id, String username, String password) {
        super(name, id, username, password);
    }

    public Manager() {
        super();
    }

    public void addTeacher(String name, int id, String username, String password) {
        AttendanceTracker.School.addTeacher(name, id, username, password);
    }

    public void addStudent(String name, int id, String username, String password) {
        AttendanceTracker.School.addStudent(name, id, username, password);
    }

    public void showTotalFailers() {
        System.out.println("Failers: ");
        for (AttendanceTracker.Person person : AttendanceTracker.School.people) {
            if (person instanceof AttendanceTracker.Student) {
                AttendanceTracker.Student student = (AttendanceTracker.Student) person;
                for (Lesson lesson : student.lessons) {
                    if (lesson.getMaxAbsentCount() < student.calculateAbsenteeism(lesson)) {
                        System.out.println(student.getName() + " " + lesson.lessonName);
                    }
                }
            }
        }
    }
    public void addLesoon (String lessonName, String courseCode,int lessonCount, String
            teacherName){
        for (AttendanceTracker.Person person : AttendanceTracker.School.people) {
            if (person instanceof Teacher && person.getName().equals(teacherName)) {
                Teacher teacher = (Teacher) person;
                Lesson lesson = new Lesson();
                lesson.lessonName = lessonName;
                lesson.courseCode = courseCode;
                lesson.lessonCount = lessonCount;
                AttendanceTracker.Student.lessons.add(lesson);
                teacher.setLesson(lesson);
            }
        }
    }
    public void showAllPeople(){
        for (AttendanceTracker.Person person : AttendanceTracker.School.people){
            if(person instanceof Teacher){
                Teacher teacher =(Teacher) person;
                System.out.println("--------Teachers--------");
                System.out.println("Name : " + teacher.getName());
            } else if (person instanceof AttendanceTracker.Student) {
                AttendanceTracker.Student student =(AttendanceTracker.Student) person;
                System.out.println("--------Students--------");
                System.out.println("Name : " +student.getName());

            }

        }

    }

    public void addLessonToClass(Lesson lesson, String classCode) {
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
    }
}
