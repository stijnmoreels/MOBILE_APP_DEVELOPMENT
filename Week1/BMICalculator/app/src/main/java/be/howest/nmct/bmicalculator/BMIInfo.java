package be.howest.nmct.bmicalculator;

/**
 * Created by Stijn on 12/02/2015.
 */
public class BMIInfo {
    public static enum Category {
        GROOT_OVERGEWICHT(0,15),
        ERNSTIG_ONDERGEWICHT(15, 16),
        ONDERGEWICHT(16, 18.5f),
        NORMAAL_BMI(18.5f, 25),
        OVERGEWICHT(25, 30),
        MATIG_OVERGEWICHT(30, 35),
        ERNSTIG_OVERGEWICHT(35, 40),
        ZEER_GROOT_OVERGEWICHT(40, 100);

        private float lowerBoundary;
        private float upperBoundary;

        Category(float lower, float upper) {
            this.lowerBoundary = lower;
            this.upperBoundary = upper;
        }

        public Boolean isInBoundary(float number) {
            return number > this.lowerBoundary && number < this.upperBoundary;
        }

        public static Category getCategory(float index) {
            for(Category category : Category.values()) {
                if(category.isInBoundary(index))
                    return category;
            }
            return null;
        }
    }

    private float height = 1.70f;
    private int mass = 70;
    private float bmiIndex;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public float getBmiIndex() {
        return bmiIndex;
    }

    public BMIInfo(float height, int mass) {
        this.height = height;
        this.mass = mass;
    }

    public BMIInfo() {

    }

    public void recalculate() {
        this.bmiIndex = (float)((this.mass) / (Math.pow(this.height, 2)));
    }

    public Category GetCategory() {
        return Category.getCategory(this.bmiIndex);
    }
}
