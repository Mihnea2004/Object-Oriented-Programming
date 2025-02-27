import java.util.*;

abstract class Memorie{
    protected byte[] tablou;
    protected int size;
    protected Memorie(int size){
        if(size <= 0)
            throw new IllegalArgumentException();
        this.size = size;
    }

    //metoda care returneaza un vector
    public byte[] read(int start, int end){
        if(start < 0 || end < 0 || start > end || start >= (size - 1) || end >= (size - 1))
            throw new IllegalArgumentException();
        byte[] result = new byte[end-start+1];
        for(int i = start; i <= end; i++)
            result[i] = tablou[i];

        return result;
    }
}

class PROM extends Memorie{
    private int continut;
    public PROM(final byte[] tablou, int size) throws IllegalArgumentException{
        super(size);
        this.tablou = tablou;
    }
}

class RandomROM extends Memorie{
    public RandomROM(final byte[] tablou, int size) throws IllegalArgumentException{
        super(size);
        for(int i = 0; i < size; i++){
            if(Math.random() < 0.5)
                tablou[i] = 0;
            else
                tablou[i] = 1;
        }
    }
}

class RAM extends Memorie{
    public RAM(int size) throws IllegalArgumentException{
        super(size);
    }

    public void write(int start, byte[] t){
        if((start + t.length) >= size || (start <= 0))
            throw new IllegalArgumentException();

        for(int i = 0; i < t.length; i++)
            tablou[start + i] = t[i];
    }

    protected int dimList(){
        return this.size;
    }
}

class RedundantRAM extends RAM{
    private List <RAM> lista;
    public RedundantRAM(int size) throws IllegalArgumentException{
        super(size);
        lista = new ArrayList<RAM>();
    }

    public void AddWritableMemory(RAM m) throws IllegalArgumentException{
        
    }
}