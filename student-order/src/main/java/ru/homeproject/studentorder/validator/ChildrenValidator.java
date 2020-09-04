package ru.homeproject.studentorder.validator;

import ru.homeproject.studentorder.domain.children.AnswerChildren;
import ru.homeproject.studentorder.domain.StudentOrder;

public class ChildrenValidator
{
    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children Check is running");
        return new AnswerChildren();
    }
}
