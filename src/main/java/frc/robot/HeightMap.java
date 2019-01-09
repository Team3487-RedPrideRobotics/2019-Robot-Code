package frc.robot;

public enum HeightMap {

    Cargo1(0), Hatch1(0), Cargo2(0), Hatch2(0), Cargo3(0), Hatch3(0);
     /*
 Jacob, before you start to make changes in every document (which yes I will admit is good)
 you MUST talk to me about it.  Changing 34 thousand things and then expecting me to understand is not okay.
 This is a necessary change, please abide by it.  I will be putting this on all docs
 in case you don't visit this one.
*/
    public double rot;

    HeightMap(double rotations){
        this.rot = rotations;
    }

}