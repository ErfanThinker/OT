package zinutech.joint.crowmaster.ot.entities;

/**
 * Created by root on 4/23/15.
 */
public class CastEnt {
    private int imageId;
    private String arg1;
    private String arg2;
    private String arg3;
    private String arg4;
    public CastEnt(int resID, String s1, String s2, String s3, String s4){
        imageId = resID;
        arg1 = s1;
        arg2 = s2;
        arg3 = s3;
        arg4 = s4;
    }

    public int getImage(){return imageId;}
    public String getArg1(){return arg1;}
    public String getArg2(){return arg2;}
    public String getArg3(){return arg3;}
    public String getArg4(){return arg4;}
}
