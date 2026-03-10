package solid;

/**
 * L - Liskov Substitution: Alt sınıf üst sınıfın yerine kullanılabilmeli;
 * davranış sözleşmesi bozulmamalı. (Bu örnekte Square, Rectangle'ın
 * setWidth/setHeight sözleşmesini koruyor: her ikisi de kenar uzunluğunu set eder.)
 */
public class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}
