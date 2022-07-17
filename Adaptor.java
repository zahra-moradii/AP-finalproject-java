public class Adaptor {
    public static final int _FixRecFixStrAdap = 1;
    public static final int _FixRecDynStrAdap = 2;
    public static final int _DynRecFixStrAdap = 3;
    public static final int _DynRecDynStrAdap = 4;

    public static int adaptorType = _FixRecFixStrAdap;

    public Adaptor(){};
    public void setAdaptorType(int adap){
        adaptorType = adap;
    };
    public int getAdaptorType(){
        return adaptorType;
    };
}
