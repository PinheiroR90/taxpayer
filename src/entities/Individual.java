package entities;

public class Individual extends TaxPayer{
    private Double healthExpenditures ;
    public Individual(){}

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double impost = 0.0;
        if (getAnualIncome()<20000.00){
            impost = getAnualIncome() * 0.15;
            return impost;

        }else if(getHealthExpenditures()>0){
            impost = (getAnualIncome() * 0.25) - (getHealthExpenditures() * 0.50);
            return impost;

        }else{
            impost = getAnualIncome() * 0.25;
            return impost;
        }
    }
}
