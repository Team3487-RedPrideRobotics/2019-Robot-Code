package frc.robot;

public enum HeightMap {

    //In Inches
    Bottom(RobotMap.low), Cargo1(RobotMap.cargo1), Hatch1(RobotMap.hatch1), Cargo2(RobotMap.cargo2), Hatch2(RobotMap.hatch2), Cargo3(RobotMap.cargo3), Hatch3(RobotMap.hatch3);
    
    public double rot;

    HeightMap(double rotations){
        this.rot = rotations;
    }

}
