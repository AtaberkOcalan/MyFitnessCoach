
package Model;

public class MuscleActivation{
    static int BackReps = 0;
    static int ChestReps = 0;
    static int ShouldersReps = 0;
    static int LegReps = 0;
    static int ArmReps = 0;
    
    public static void reset() {
        BackReps = 0;
        ChestReps = 0;
        ShouldersReps = 0;
        LegReps = 0;
        ArmReps = 0;
    }

    public int getBackReps() {
        return BackReps;
    }

    public void setBackReps(int BackReps) {
        this.BackReps += BackReps;
    }

    public int getChestReps() {
        return ChestReps;
    }

    public void setChestReps(int ChestReps) {
        this.ChestReps += ChestReps;
    }

    public int getShouldersReps() {
        return ShouldersReps;
    }

    public void setShouldersReps(int ShouldersReps) {
        this.ShouldersReps += ShouldersReps;
    }

    public int getLegReps() {
        return LegReps;
    }

    public void setLegReps(int LegReps) {
        this.LegReps += LegReps;
    }

    public int getArmReps() {
        return ArmReps;
    }

    public void setArmReps(int ArmReps) {
        this.ArmReps += ArmReps;
    }
    
    
}
