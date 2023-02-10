package AttendanceTracker;

public class Login {

    public AttendanceTracker.Teacher checkTeacher(String username, String password) {
        for (AttendanceTracker.Person person : AttendanceTracker.School.people) {
            if (person instanceof AttendanceTracker.Teacher) {
                AttendanceTracker.Teacher teacher = (AttendanceTracker.Teacher) person;
                if (username.equals(teacher.getUsername()) && password.equals(teacher.getPassword())) {
                    System.out.println("AttendanceTracker.Login successfully.");
                    return teacher;
                }
            }
        }
        return null;
    }

    public AttendanceTracker.Student checkStudent(String username, String password) {
        for (AttendanceTracker.Person person : AttendanceTracker.School.people) {
            if (person instanceof AttendanceTracker.Student) {
                AttendanceTracker.Student student = (AttendanceTracker.Student) person;
                if (username.equals(student.getUsername()) && password.equals(student.getPassword())) {
                    System.out.println("AttendanceTracker.Login successfully.");
                    return student;
                }
            }
        }
        return null;
    }

    public AttendanceTracker.Manager checkManager(String username, String password) {
        for (AttendanceTracker.Person person : AttendanceTracker.School.people) {
            if (person instanceof AttendanceTracker.Manager) {
                AttendanceTracker.Manager manager = (AttendanceTracker.Manager) person;
                if (username.equals(manager.getUsername()) && password.equals(manager.getPassword())) {
                    System.out.println("AttendanceTracker.Login successfully.");
                    return manager;
                }
            }
        }
        return null;
    }
}
