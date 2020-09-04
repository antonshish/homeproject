package ru.homeproject.studentorder.validator;

import ru.homeproject.studentorder.domain.wedding.AnswerWedding;
import ru.homeproject.studentorder.domain.StudentOrder;

public class WeddingValidator
{
    public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding запущен");
        return new AnswerWedding();
    }
}
