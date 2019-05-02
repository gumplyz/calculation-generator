package com.yule.edu.math.calculation.calculationgenerator.service;

public class Parameters {
    private int numQuestions;
    private Add add;


    public int getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    Add getAdd() {
        return add;
    }

    public void setAdd(Add add) {
        this.add = add;
    }



    public class Add{
        private int max;

        int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }
}
