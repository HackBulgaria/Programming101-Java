
public class Main {

	public static void main(String[] args) {
		
		CountryManager manager = CountryManager.getInstance();
		manager.add(new Country("bgn", "Bulgaria", true, 0.2));
		manager.add(new Country("uk", "United Kingdom", false, 0.1));
		
		try {
			System.out.println(VatTaxCalculator.CalculateTaxFormatted(0.1));
		} catch (NotSupportedCountryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
