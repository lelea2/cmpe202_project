package Request;

/**
 * Created by YuexingYin on 8/12/16.
 */
public interface RequestState {
    void stateAction();
    void goToNextState();
    String stateDescription();
}
