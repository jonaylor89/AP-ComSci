package LucasNumbers;

class LNumber {

    private int value;
    private boolean divisible = false;

    LNumber(int number){
        value = number;
    }

    @Override
    public String toString() {
        return Integer.toString(value) + " : " + isDivisible();
    }

    int getValue() {
        return value;
    }

    private boolean isDivisible() {
        return divisible;
    }

    void setDivisible() {
        this.divisible = true;
    }
}
