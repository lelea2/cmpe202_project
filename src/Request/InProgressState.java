package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class InProgressState implements RequestState{
    RequestInterface requestInterface;

    public InProgressState(RequestInterface requestInterface){
        this.requestInterface = requestInterface;
    }
    @Override
    public void pending() {
        System.out.println("Your request is in progress!");
    }

    @Override
    public void inProgress() {
        requestInterface.setState(new InProgressState(requestInterface));
        System.out.println("Your request is in progress!");
    }

    @Override
    public void approved() {
        System.out.println("Your request is in progress!");
    }

    @Override
    public void completed() {
        System.out.println("Your request is in progress!");
    }

    @Override
    public void cancelled() {
        System.out.println("Your request is in progress!");
    }
}
