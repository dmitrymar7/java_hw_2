package ex7;

public class Celsius implements Converter{

    private double temperature;

    public Celsius(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double convertValue(TemperatureUnit unit) {
        if (unit.equals(TemperatureUnit.FAHRENHEIT)){
            return convertFahrenheit();
        }else if (unit.equals(TemperatureUnit.KELVIN)){
            return convertKelvin();
        }

        return temperature;
    }

    public double convertKelvin(){
        return this.temperature + 273.15;
    }

    public double convertFahrenheit(){
        return this.temperature * 1.8 + 32;
    }

}
