package busesv;

public class Bus {
    private int busno;
    private boolean ac;
    private int capacity;
    Bus(int no,boolean ac,int c)
    {
        this.busno=no;
        this.ac=ac;
        this.capacity=c;
    }
    public int getBusno(){
        return busno;
    }
    public boolean isac()
    {
        return ac;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setAc(boolean val){
        ac=val;
    }
    public void setCapacity(int v)
    {
        capacity=v;
    }
}
