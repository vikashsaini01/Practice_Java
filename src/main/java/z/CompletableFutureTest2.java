package z;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class ToDo{
	
}
public class CompletableFutureTest2 {
	
	  Object restApiClient;
	public List<ToDo> getToDos(List<String> ids){

        List<CompletableFuture<ToDo>> futures =
                ids.stream()
                          .map(id -> getToDoAsync(id))
                          .collect(Collectors.toList());

        List<ToDo> result =
                futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList());

        return result;
    }


    CompletableFuture<ToDo> getToDoAsync(String id){

        CompletableFuture<ToDo> future = CompletableFuture.supplyAsync(new Supplier<ToDo>() {
            @Override
            public ToDo get() {
                final ToDo toDo = restApiClient.getToDo(id);

                return toDo;
            }
        });

        return future;
    }

}