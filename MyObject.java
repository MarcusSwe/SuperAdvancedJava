package packageUppgift1;

public class MyObject {

    private boolean bool;
    private int value;
    private String name;

    public MyObject(boolean b, int v, String n){
      this.bool = b;
      this.value = v;
      this.name = n;

    }


    public boolean getBoolean(){
        return this.bool;
    }

    public void setBoolean(boolean b1){
        this.bool = b1;
    }


    public int getInt(){
        return this.value;
    }

    public void setInt(int i1){
        this.value = i1;
    }


    public String getString(){
        return this.name;
    }

    public void setString(String n1){
        this.name = n1;
    }

}
