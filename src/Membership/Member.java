package Membership;

import Schedule.Schedule;

/**
 * Created by kdao on 7/22/16.
 */
public abstract class Member {
    protected String _name;
    protected String _phoneNumber;
    protected String _email;
    protected String _id;

    public String get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public String get_email() {
        return _email;
    }

    public void set_name(String _firstName) {
        this._name = _firstName;
    }

    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    abstract public void update(Object args);

}
