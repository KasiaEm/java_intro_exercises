package com.sda.ex1;

public enum BMIStatus {
    UNDERWEIGHT("You're underweight. Gain some weigth."),
    NORMAL("Your weight is normal."),
    OVERWEITGHT("You're overweight. Take care."),
    OBESITY("You're obese. Consult a doctor.");

    private String message;

    BMIStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static BMIStatus calculateBMI(double weight, double height) {
        double result = weight / (height * height);

        if (result < 18.5) {
            return BMIStatus.UNDERWEIGHT;
        } else if (result < 24.9) {
            return BMIStatus.NORMAL;
        } else if (result < 29.9) {
            return BMIStatus.OVERWEITGHT;
        }
        return BMIStatus.OBESITY;
    }
}
