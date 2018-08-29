package phidays.postman

import phidays.postman.marshaller.JSONMarshallers

class BootStrap {
    LoadInitialDataBusinessService loadInitialDataBusinessService

    def init = { servletContext ->
        println ":bootStrap:loadingHeroes"
        loadInitialDataBusinessService.loadHeroes()

        println ":bootStrap:loadingCustomMarshallers"
        JSONMarshallers.init()
    }

    def destroy = {
    }
}
