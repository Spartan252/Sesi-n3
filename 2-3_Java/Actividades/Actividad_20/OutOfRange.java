public class OutOfRange extends RuntimeException {
    private String fecha;

    public OutOfRange(int d){
        super("OutOfRange");
        this.fecha = Integer.toString(d);
    }

    public OutOfRange(int d, int m){
        super("OutOfRange");
        this.fecha = Integer.toString(d)+Integer.toString(m);
    }

    public OutOfRange(int d, int m, int y){
        super("OutOfRange");
        this.fecha = Integer.toString(d)+Integer.toString(m)+Integer.toString(y);
    }

    public String toString() {
        return getMessage() + "\n Date out of range: "+ fecha;
    }

}
