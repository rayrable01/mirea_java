import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

public class Student {
    private String fullName;
    private Date birthDate;

    public Student(String fullName, String birthDateStr) {
        this.fullName = fullName;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            this.birthDate = dateFormat.parse(birthDateStr);
        } catch (ParseException e) {
            System.out.println("Ошибка при парсинге даты. Используется текущая дата.");
            this.birthDate = new Date();
        }
    }

    public Student(String fullName, Date birthDate) {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public String getFormattedBirthDate(String format) {
        SimpleDateFormat dateFormat;

        switch (format.toLowerCase()) {
            case "short":
                dateFormat = new SimpleDateFormat("dd.MM.yy");
                break;
            case "medium":
                dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                break;
            case "full":
                dateFormat = new SimpleDateFormat("d MMMM yyyy 'года'");
                break;
            default:
                // Пользовательский формат
                dateFormat = new SimpleDateFormat(format);
        }

        return dateFormat.format(birthDate);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return "Студент: " + fullName + "\nДата рождения: " + dateFormat.format(birthDate);
    }

    // Геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}