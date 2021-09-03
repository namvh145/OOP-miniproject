package objects;

public class OverTransaction {
    private Long value;
    private Integer mass;

    public OverTransaction() {
    }

    public OverTransaction(Double value, Integer mass) {
        setValue(value);
        setMass(mass);
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = Math.round(value * 1000);
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass * 10;
    }
}
