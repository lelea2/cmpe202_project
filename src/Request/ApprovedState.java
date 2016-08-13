package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class ApprovedState implements RequestState{

    RequestInterface requestInterface;

    public ApprovedState(RequestInterface requestInterface){
        this.requestInterface = requestInterface;
    }
    @Override
    public void pending() {
        System.out.println("Your request is approved!");
    }

    @Override
    public void inProgress() {
        System.out.println("Your request is approved!");
    }

    @Override
    public void approved() {
        requestInterface.setState(new ApprovedState(requestInterface));
        System.out.println("Your request is approved!");
    }

    @Override
    public void completed() {
        System.out.println("Your request is approved!");
    }

    @Override
    public void cancelled() {
        System.out.println("Your request is approved!");
    }
}
