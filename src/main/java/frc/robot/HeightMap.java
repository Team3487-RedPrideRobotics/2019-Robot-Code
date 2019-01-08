package frc.robot;

public enum HeightMap {

    //Replace these values with the proper test verified encoder position.
    Cargo1(2), Hatch1(1), Cargo2(4), Hatch2(3), Cargo3(6), Hatch3(5);

    //The storage variable for the height.
    public final int pos;

    //Constructor for the data class.
    HeightMap(int encoderPosition) {
        this.pos = encoderPosition;
    }

    //Getter method for the encoder position.
    public int height() {
        return this.pos;
    }

}