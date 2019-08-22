package in.kuros.blog.code.java.parallel;

public class ParallelExecutionExceptionExample {

    public static void main(String[] args) {
        final ExecutionResult executionResult = ParallelExecution.of(() -> slowService(1))
                .and(() -> {
                    throw new RuntimeException("Bam!!");
                })
                .and(() -> slowService(3))
                .close();

        executionResult.get(0);
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
