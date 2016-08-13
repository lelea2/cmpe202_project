package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class CancelledState implements RequestState{

    RequestInterface requestInterface;

    public CancelledState(RequestInterface requestInterface){
        this.requestInterface = requestInterface;
    }
    @Override
    public void pending() {
        System.out.println("Your request is cancelled!");
    }

    @Override
    public void inProgress() {
        System.out.println("Your request is cancelled!");
    }

    @Override
    public void approved() {
        System.out.println("Your request is cancelled!");
    }

    @Override
    public void completed() {
        System.out.println("Your request is cancelled!");
    }

    @Override
    public void cancelled() {
        requestInterface.setState(new CancelledState(requestInterface));
        System.out.println("Your request is cancelled!");
    }
}
