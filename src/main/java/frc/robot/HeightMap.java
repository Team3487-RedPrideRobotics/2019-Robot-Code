package frc.robot;

public enum HeightMap {

    //In Inches
    Bottom(0), Cargo1(1.5), Hatch1(1), Cargo2(2.5), Hatch2(2), Cargo3(3.5), Hatch3(3);
    
    public double rot;

    HeightMap(double rotations){
        this.rot = rotations;
    }

}
