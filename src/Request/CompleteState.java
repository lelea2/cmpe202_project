package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public class CompleteState implements RequestState{
    RequestInterface requestInterface;

    public CompleteState(RequestInterface requestInterface){
        this.requestInterface = requestInterface;
    }
    @Override
    public void pending() {
        System.out.println("Your request is completed!");
    }

    @Override
    public void inProgress() {
        System.out.println("Your request is completed!");
    }

    @Override
    public void approved() {
        System.out.println("Your request is completed!");
    }

    @Override
    public void completed() {
        requestInterface.setState(new CompleteState(requestInterface));
        System.out.println("Your request is completed!");
    }

    @Override
    public void cancelled() {
        System.out.println("Your request is completed!");
    }
}
