package test;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.testng.annotations.Test;

public class MyTest {

    @Test(dataProvider = "dp", dataProviderClass = DataProviderTest.class)
    public void testLogin(String browser, String url) {
        // Your test logic here
        System.out.println("browser name: " + browser + " and url: " + url);
        // Assertions go here

    }
    @Test
    public void javaExample() throws InterruptedException, ExecutionException {
    	CompletableFuture<String> f = CompletableFuture
				.supplyAsync(() -> "A")
				.thenApplyAsync(s -> s + "X")
				.thenApply(s -> s + "Z");

				System.out.println(f.get());
    }
    
}