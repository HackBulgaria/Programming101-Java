import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountryManager {
	
	private static CountryManager sCountryManager;
	
	private HashMap<String, Country> mCountries = new HashMap<>();
	private String mDefaultCountryKey;
	
	private CountryManager() {
		
	}
	
	private void initDefaultCountry() {
		Iterator<Map.Entry<String, Country>> iterator = mCountries.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Country> entry = iterator.next();
			String key = entry.getKey();
			Country country = entry.getValue();
			if (country.isDefault()) {
				mDefaultCountryKey = key;
			}
		}
	}
	
	public static CountryManager getInstance() {
		if (sCountryManager == null) {
			sCountryManager = new CountryManager();
		}
		
		return sCountryManager;
	}
	
	public Country getCountry(String countryCode) throws NotSupportedCountryException {
		
		if (!mCountries.containsKey(countryCode)) {
			throw new NotSupportedCountryException("Country not supported.");
		}
		
		return mCountries.get(countryCode);
	}
	
	public void changeDefaultCountry(Country newDefault) throws NotSupportedCountryException {
		String newDefaultId = newDefault.getCountryId();
		
		Country country = getCountry(mDefaultCountryKey);
		mCountries.put(mDefaultCountryKey, 
			new Country(mDefaultCountryKey, country.getName(), false, country.getVatTax()));
		mCountries.put(newDefaultId, 
			new Country(newDefaultId, newDefault.getName(), true, newDefault.getVatTax()));
		
		mDefaultCountryKey = newDefaultId;
	}
	
	public void add(Country country) {
		mCountries.put(country.getCountryId(), country);
		initDefaultCountry();
	}
	
	public void add(Country[] countries) {
		for (Country country : countries) {
			mCountries.put(country.getCountryId(), country);
		}
		initDefaultCountry();
	}
	
	public void remove(Country country) {
		mCountries.remove(country.getCountryId());
	}
	
	public void remove(Country[] countries) {
		for (Country country : countries) {
			mCountries.remove(country.getCountryId());
		}
	}
	
	public String getDefaultCountryCode() {
		return mDefaultCountryKey;
	}
}
