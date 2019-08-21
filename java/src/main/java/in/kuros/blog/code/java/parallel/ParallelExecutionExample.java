package in.kuros.blog.code.java.parallel;

public class ParallelExecutionExample {

    public static void main(String[] args) {
        final ExecutionResult executionResult = ParallelExecution.of(() -> slowService(1))
                .and(() -> slowService(2))
                .and(() -> slowService(3))
                .close();

        int val = executionResult.get(0);
        int val2 = executionResult.get(1);
        int val3 = executionResult.get(2);

        System.out.println(val + val2 + val3);
    }

    private static Integer slowService(final int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return i;
    }
}
