package example;


import statemachine.ActionState;

public class StateSelectLanguage extends ActionState<IvrContext>{
    public StateSelectLanguage(String name, boolean startState) {
        super(name, startState);
    }

    @Override
    protected void action(IvrContext ivrContext) {
        ivrContext.setIvrResponse(new IvrResponse("Please select your language preference"));
    }

    @Override
    protected String nextTransition(IvrContext ivrContext) {
        IVRRequest request = ivrContext.getIvrRequest();
        return Data.userToLanguageMap.get(request.getNumber());
    }

    @Override
    protected void exitAction(IvrContext ivrContext) {
        IVRRequest request = ivrContext.getIvrRequest();
        SaveLanguage( request.getNumber(),request.getUserInput());
    }

    private void SaveLanguage( String number,String userInput) {
        Data.userToLanguageMap.put(number,userInput);
    }
}