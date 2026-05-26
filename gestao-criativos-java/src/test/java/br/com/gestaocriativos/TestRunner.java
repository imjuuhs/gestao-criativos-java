package br.com.gestaocriativos;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        List<Object> tests = List.of(
                new CreativeEvaluatorFactoryTest(),
                new ValidationChainTest(),
                new CreativeWorkflowFacadeTest()
        );

        List<String> failures = new ArrayList<>();
        int total = 0;

        for (Object test : tests) {
            for (Method method : test.getClass().getDeclaredMethods()) {
                if (method.getName().startsWith("deve")) {
                    total++;
                    try {
                        method.invoke(test);
                        System.out.println("OK - " + test.getClass().getSimpleName() + "." + method.getName());
                    } catch (Exception exception) {
                        Throwable cause = exception.getCause() == null ? exception : exception.getCause();
                        failures.add(test.getClass().getSimpleName() + "." + method.getName() + " -> " + cause.getMessage());
                    }
                }
            }
        }

        if (!failures.isEmpty()) {
            System.out.println("\nFalhas encontradas:");
            failures.forEach(System.out::println);
            throw new AssertionError(failures.size() + " teste(s) falharam");
        }

        System.out.println("\nTotal de testes executados: " + total);
        System.out.println("Todos os testes passaram.");
    }
}
