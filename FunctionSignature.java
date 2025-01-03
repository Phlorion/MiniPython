public class FunctionSignature {
    private final int requiredArgs;
    private final int defaultArgs;

    public FunctionSignature(int requiredArgs, int defaultArgs) {
        this.requiredArgs = requiredArgs;
        this.defaultArgs = defaultArgs;
    }

    public int getRequiredArgs() {
        return requiredArgs;
    }

    public int getDefaultArgs() {
        return defaultArgs;
    }
}