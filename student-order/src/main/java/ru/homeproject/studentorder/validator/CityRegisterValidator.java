package ru.homeproject.studentorder.validator;

import ru.homeproject.studentorder.domain.Child;
import ru.homeproject.studentorder.domain.Person;
import ru.homeproject.studentorder.domain.register.AnswerCityRegister;
import ru.homeproject.studentorder.domain.register.AnswerCityRegisterItem;
import ru.homeproject.studentorder.domain.register.CityRegisterResponse;
import ru.homeproject.studentorder.domain.StudentOrder;
import ru.homeproject.studentorder.exception.CityRegisterException;
import ru.homeproject.studentorder.exception.TransportException;
import ru.homeproject.studentorder.validator.register.CityRegisterChecker;
import ru.homeproject.studentorder.validator.register.RealCityRegisterChecker;

public class CityRegisterValidator
{
    public static final String IN_CODE = "NO_GRN";

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new RealCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();

        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));
        for (Child child : so.getChildren()) {
            ans.addItem(checkPerson(child));
        }

        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;

        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isRegistered() ?
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        } catch (TransportException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        }

        AnswerCityRegisterItem ans =
                new AnswerCityRegisterItem(status, person, error);

        return ans;
    }
}
