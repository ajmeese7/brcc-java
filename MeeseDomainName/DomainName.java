/*
 * DomainName.java
 * Author: Aaron Meese
 * Date: 2/24/19
 * 
 * Creates a DomainName object with a name field.
 * 
 * NOTE: This entire class assumes that none of the URLs
 * will contain http:// or https://, because the problem 
 * never stated that they would be part of the constraints.
 * 
 */

public class DomainName {
	private String name;
	
	public DomainName(String name) {
		this.name = name;
	}
	
	// Returns the name of the DomainName object
	public String getDomain() {
		return this.name;
	}
	
	// Sets the name of the DomainName object
	public void setDomain(String name) {
		this.name = name;
	}
	
	// Checks if the first four characters of the domain are "www."
	public Boolean hasPrefix() {
		String name = this.name;
		if (name.length() >= 4) {
			String prefix = name.substring(0,4);
			if (prefix.equals("www.")) {
				return true;
			}
		}
		
		return false;
	}
	
	// Returns whether or not the domain name has an extension
	public String extension() {
		String name = this.name;
		if (this.hasPrefix()) {
			// Removes the prefix
			int index = name.indexOf(".") + 1;
			if (name.length() >= index) {
				name = name.substring(index);
			}
		}
		
		if (name.contains(".")) {
			// TODO: Validate this condition
			int index = name.indexOf(".") + 1;
			if (name.length() >= index) {
				String extension = name.substring(index);
				return extension;
			}
		}
		
		return "unknown";
	}
	
	// Actual name in the URL, not the entire thing
	public String getName() {
		String name = this.name;
		String extension = this.extension();
		
		if (this.hasPrefix()) {
			// Removes the prefix
			int index = name.indexOf(".") + 1;
			if (name.length() >= index) {
				name = name.substring(index);
			}
		}
		
		if (!extension.equals("unknown")) {
			// Removes the extension
			int index = name.lastIndexOf(".");
			name = name.substring(0, index);
			return name;
		}
		
		return "unknown";
	}
	
	@Override
	public String toString() {
		// Is this supposed to be output a certain way?
		String name = "Name: " + this.name;
		return name;
	}
	
	// Returns if the called object has the same domain name as the specified object
	public Boolean equals(DomainName domain2) {
		if (this.name.equals(domain2.name)) {
			return true;
		}
		
		return false;
	}
}
