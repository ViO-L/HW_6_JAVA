  
import java.util.Objects;

public class Notebook {

    private String name;
    private String color;
    private String model;
    private int price;
    private int ram;
    private String storage;


    public  Notebook(String name, String color, int price, String model) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.model = model;        
    }

    public String getStorage() {
        return storage.toLowerCase();
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color.toLowerCase();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "назавание='" + name + '\'' +
                ", цвет='" + color + '\'' +
                ", цена=" + price +
                ", ОЗУ=" + ram +   
                ", накопитель=" + storage +                    
                '}';
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) return true;
    //     if (obj == null || getClass() != obj.getClass()) return false;
    //     Notebook cat = (Cat) obj;
    //     return cat.name.equals(name) &&
    //             cat.price == price &&
    //             cat.color.equals(color);
    //}

    @Override
    public int hashCode() {
        return Objects.hash(name, color, model);
    }
}