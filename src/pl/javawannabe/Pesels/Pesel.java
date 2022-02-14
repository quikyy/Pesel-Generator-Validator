package pl.javawannabe.Pesels;

public class Pesel {
    public String day;
    public String month;
    public String year;
    public String serial;
    public String sex;
    public String validationDigit;
    public String dateOfBirth;
    public String pesel;
    public boolean isValidate;
    public boolean isCorrect;

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getSerial() {
        return serial;
    }

    public String getSex() {
        return sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPesel() {
        return pesel;
    }

    public String getValidationDigit() {
        return validationDigit;
    }

    public boolean isValidate() {
        return isValidate;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setValidationDigit(String validationDigit) {
        this.validationDigit = validationDigit;
    }

    public void setValidate(boolean validate) {
        isValidate = validate;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }


}
