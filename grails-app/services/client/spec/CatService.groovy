package client.spec

import grails.gorm.transactions.Transactional
import org.springframework.beans.factory.annotation.Autowired
import sample.cat.CatClient

@Transactional
class CatService {
    @Autowired
    CatClient catClient

    def search() {
        catClient.search()
    }
}
