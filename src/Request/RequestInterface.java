package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public interface RequestInterface {

    public void pending();
    public void inProgress();
    public void approved();
    public void completed();
    public void cancelled();

    public void setState(RequestState state);
    public RequestState getRequestState();
}
