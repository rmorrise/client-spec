package client.spec


import org.springframework.beans.factory.annotation.Autowired
import sample.cat.CatClient

class ApplicationController {
    @Autowired
    CatClient catClient

    def index() {
        [cats: catClient.search()]
    }
}
