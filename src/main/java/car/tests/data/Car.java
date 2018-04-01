package car.tests.data;

public class Car {
   private String modelName;
   private int year;
   private String color;

public String toString(){
    return "Marca: "+ modelName + ","+ " An fabricatie: "+ year + "," + " Culoare: " + color;
}

  public void setModelName(String marca){
    modelName = marca;
    }
    public String getModelName(){
    return modelName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }

}

