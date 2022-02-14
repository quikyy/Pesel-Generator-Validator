package pl.javawannabe.Pesels;

public class Pesel{
    protected String day;
    protected String month;
    protected String year;
    protected String serial;
    protected String sex;
    protected String validationDigit;
    protected String dateOfBirth;
    protected String pesel;
    protected boolean isValidate;
    protected boolean isCorrect;

    protected String getDay() {
        return day;
    }

    protected String getMonth() {
        return month;
    }

    protected String getYear() {
        return year;
    }

    protected String getSerial() {
        return serial;
    }

    protected String getSex() {
        return sex;
    }

    protected String getDateOfBirth() {
        return dateOfBirth;
    }

    protected String getPesel() {
        return pesel;
    }

    protected String getValidationDigit() {
        return validationDigit;
    }

    protected boolean isValidate() {
        return isValidate;
    }

    protected boolean isCorrect() {
        return isCorrect;
    }
}
