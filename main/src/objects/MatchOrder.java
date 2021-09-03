package objects;

public class MatchOrder {
    private Long fluctuate;
    private Double percentage;
    private Long value;
    private Integer mass;
    private Integer sum;

    public MatchOrder() {
    }

    public MatchOrder(Double fluctuate, Double percentage, Double value, Integer mass, Integer sum) {
        setFluctuate(fluctuate);
        setPercentage(percentage);
        setValue(value);
        setMass(mass);
        setSum(sum);
    }

    public Long getFluctuate() {
        return fluctuate;
    }

    public void setFluctuate(Double fluctuate) {
        this.fluctuate = Math.round(fluctuate * 1000);
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum * 10;
    }
}
