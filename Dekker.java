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
        if (t == 0) {
            p0wantstoenter = true;
            while (p1wantstoenter) {
                if (favoredprocess == 1) {
                    p0wantstoenter = false;
                    while (favoredprocess == 1);
                    p0wantstoenter = true;
                }
            }
        } else {
            p1wantstoenter = true;
            while (p0wantstoenter) {
                if (favoredprocess == 0) {
                    p1wantstoenter = false;
                    while (favoredprocess == 0);
                    p1wantstoenter = true;
                }
            }
        }


    }

    public void leavingCR(int t)
    {
        favoredprocess = 1-t;

        //complete exit protocol
        if (t == 0) {
            favoredprocess = 1;
            p0wantstoenter = false;
        } else {
            favoredprocess = 0;
            p1wantstoenter = false;
        }
    }
}
