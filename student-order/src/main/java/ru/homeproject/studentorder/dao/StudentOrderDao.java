package ru.homeproject.studentorder.dao;

import ru.homeproject.studentorder.domain.StudentOrder;
import ru.homeproject.studentorder.exception.DaoException;

import java.util.List;

public interface StudentOrderDao
{
    Long saveStudentOrder(StudentOrder so) throws DaoException;

    List<StudentOrder> getStudentOrders() throws DaoException;
}
