package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class PendingState implements RequestState{
    private RequestInterface requestInterface;

    public PendingState(RequestInterface requestInterface){
        this.requestInterface = requestInterface;
    }
    @Override
    public void pending() {
        requestInterface.setState(new PendingState(requestInterface));
        System.out.println("Your request is pending !");
    }

    @Override
    public void inProgress() {
        System.out.println("Your request is pending !");
    }

    @Override
    public void approved() {
        System.out.println("Your request is pending !");
    }

    @Override
    public void completed() {
        System.out.println("Your request is pending !");
    }

    @Override
    public void cancelled() {
        System.out.println("Your request is pending !");
    }
}
