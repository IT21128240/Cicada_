package com.example.newapp;

public class ExerciseData {

    //creating private variables
    private String exerciseName;
    private String exerciseDescription;
    private Integer exerciseImage;

    //creating overloaded constructor and assign variables
    public ExerciseData(String exerciseName, String exerciseDescription, Integer exerciseImage) {
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.exerciseImage = exerciseImage;
    }

    //creating getters and setters
    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public Integer getExerciseImage() {
        return exerciseImage;
    }

    public void setExerciseImage(Integer exerciseImage) {
        this.exerciseImage = exerciseImage;
    }

}
