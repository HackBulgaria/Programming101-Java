import java.io.Serializable;

public class User implements Serializable {

	/**
	 * @author anirudh
	 */
	private static final long serialVersionUID = 8309080721495266420L;
	private String firstName;
	private String lastName;
	private String email;
	private transient String fullName;

	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.fullName = firstName + " " + lastName;
	}

	//..getters and setters...

	/**
	 * Two users are equal if their firstName, lastName and email address is
	 * same.
	 */
	@Override
	public boolean equals(Object obj) {
		return (this.firstName.equals(((User) obj).firstName)
				&& this.lastName.equals(((User) obj).lastName) && this.email
					.equals(((User) obj).email));
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.email;
	}

}
