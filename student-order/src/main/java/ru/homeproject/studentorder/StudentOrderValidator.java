package ru.homeproject.studentorder;

import ru.homeproject.studentorder.dao.StudentOrderDaoImpl;
import ru.homeproject.studentorder.domain.children.AnswerChildren;
import ru.homeproject.studentorder.domain.register.AnswerCityRegister;
import ru.homeproject.studentorder.domain.student.AnswerStudent;
import ru.homeproject.studentorder.domain.wedding.AnswerWedding;
import ru.homeproject.studentorder.domain.StudentOrder;
import ru.homeproject.studentorder.exception.DaoException;

import ru.homeproject.studentorder.validator.ChildrenValidator;
import ru.homeproject.studentorder.validator.CityRegisterValidator;
import ru.homeproject.studentorder.validator.StudentValidator;
import ru.homeproject.studentorder.validator.WeddingValidator;

import java.util.List;

public class StudentOrderValidator
{
    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;


    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();

    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll() {
        try {
            List<StudentOrder> soList = readStudentOrders();

            for (StudentOrder so : soList) {
                checkOneOrder(so);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<StudentOrder> readStudentOrders() throws DaoException {
        return new StudentOrderDaoImpl().getStudentOrders();
    }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);


    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }


}
