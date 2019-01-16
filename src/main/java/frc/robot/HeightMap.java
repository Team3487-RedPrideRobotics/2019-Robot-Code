package frc.robot;

public enum HeightMap {

    Bottom(0), Cargo1(0), Hatch1(0), Cargo2(0), Hatch2(0), Cargo3(0), Hatch3(0);
    
    public double rot;

    HeightMap(double rotations){
        this.rot = rotations;
    }

}
