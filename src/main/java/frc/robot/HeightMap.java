package frc.robot;

public enum HeightMap {

<<<<<<< Updated upstream
    Bottom(0), Cargo1(0), Hatch1(0), Cargo2(0), Hatch2(0), Cargo3(0), Hatch3(0);
=======
    //In Inches
    Bottom(0), Cargo1(1.5), Hatch1(1), Cargo2(2.5), Hatch2(2), Cargo3(3.5), Hatch3(3);
>>>>>>> Stashed changes
    
    public double rot;

    HeightMap(double rotations){
        this.rot = rotations;
    }

}
