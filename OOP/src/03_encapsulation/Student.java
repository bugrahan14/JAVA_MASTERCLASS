package encapsulation;

/**
 * Kapsülleme: Not 0-100 aralığında tutulur; gereksiz setter yok.
 */
public class Student {

    private static final int MIN_GRADE = 0;
    private static final int MAX_GRADE = 100;

    private String name;
    private int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    /** Geçerlik kontrolü tek yerde: not 0-100 aralığında. */
    public void setGrade(int grade) {
        if (grade >= MIN_GRADE && grade <= MAX_GRADE) {
            this.grade = grade;
        }
    }
}
