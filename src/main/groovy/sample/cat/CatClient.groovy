package sample.cat

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

import javax.annotation.Nullable

@Client('${catService.url}')
interface CatClient {
    @Get('/breeds')
    List<Breed> breeds()

    @Get('/images/search{?breed_id}')
    List<Cat> search(@QueryValue @Nullable String breedId)
}
