package in.kuros.blog.code.java.parallel;

import java.util.List;

public class ExecutionResult {

    private List<?> result;

    ExecutionResult(final List<?> result) {
        this.result = result;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(final int index) {
        return (T) result.get(index);
    }
}
