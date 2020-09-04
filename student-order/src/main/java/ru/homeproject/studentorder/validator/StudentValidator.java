package ru.homeproject.studentorder.validator;

import ru.homeproject.studentorder.domain.student.AnswerStudent;
import ru.homeproject.studentorder.domain.StudentOrder;

public class StudentValidator
{
    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Студенты проверяются");
        return new AnswerStudent();
    }
}
