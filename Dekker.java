public class Dekker implements Synchronizer
{
    private volatile int favoredprocess;
    private volatile boolean p0wantstoenter;
    private volatile boolean p1wantstoenter;

    public Dekker()
    {
        favoredprocess = 0;
        p0wantstoenter = false;
        p1wantstoenter = false;
    }

    public void enteringCR(int t)
    {
        int other;

        other = 1 - t;

        //complete entry protocol

    }

    public void leavingCR(int t)
    {
        favoredprocess = 1-t;

        //complete exit protocol

    }
}
