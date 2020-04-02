package client.spec

class ApplicationController {
    def catService

    def index() {
        [cats: catService.search()]
    }
}
