package people;

import java.util.Arrays;

public class Owner extends Person {
    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + Arrays.toString(address) +
                '}';
    }
}
