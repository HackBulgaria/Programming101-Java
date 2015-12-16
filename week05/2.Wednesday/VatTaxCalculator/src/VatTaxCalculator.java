
public class VatTaxCalculator {
	public static double CalculateTax(double price, String countryCode) throws NotSupportedCountryException {
		Country country = CountryManager.getInstance().getCountry(countryCode);
		return price * country.getVatTax() + price;
	}
	
	public static double CalculateTax(double price) throws NotSupportedCountryException {
		return CalculateTax(price, 
				CountryManager.getInstance().getDefaultCountryCode());
	}
	
	public static String CalculateTaxFormatted(double price, String countryCode) throws NotSupportedCountryException {
		return String.format("%.2f%s", CalculateTax(price), countryCode);
	}
	
	public static String CalculateTaxFormatted(double price) throws NotSupportedCountryException {
		return CalculateTaxFormatted(price, 
				CountryManager.getInstance().getDefaultCountryCode());
	}
}
