package Membership;

/**
 * Created by kdao on 7/22/16.
 */
public abstract class Member {
    protected String _firstName;
    protected String _lastName;
    protected String _phoneNumber;
    protected String _email;

    public String get_firstName() {
        return _firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public String get_email() {
        return _email;
    }

    abstract public void update(Object args) ;

}
