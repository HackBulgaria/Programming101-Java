
public class Country {	
	private final String mCountryId;
	private final String mName;
	private final boolean mIsDefault;
	private final double mVatTax; // from 0 to 1
	
	public Country(String countryId, String name, 
			boolean isDefault, double vatTax) {
		
		if (vatTax < 0 || vatTax > 1) {
			throw new IllegalArgumentException("Invalid Vat Tax");
		}
		
		mCountryId = countryId;
		mName = name;
		mIsDefault = isDefault;
		mVatTax = vatTax;
	}
	
	public String getCountryId() {
		return mCountryId;
	}
	
	public String getName() {
		return mName;
	}
	
	public boolean isDefault() {
		return mIsDefault;
	}
	
	public double getVatTax() {
		return mVatTax;
	}	
}
