package client.spec


import org.springframework.beans.factory.annotation.Autowired
import sample.cat.CatClient

class CatService {
    @Autowired
    CatClient catClient

    def search() {
        catClient.search()
    }
}
