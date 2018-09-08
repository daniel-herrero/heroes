package phidays.heroes

import grails.converters.JSON

class ErrorController {

    def error404() {
        Map<String, String> error404Response = [
            error : [
                code: "error.404.page.notFound",
                message: "Page not found"
            ]
        ]

        render error404Response as JSON
    }

    def error500() {
        Map<String, String> error500Response = [
            error : [
                code: "error.500.internal",
                message: request?.exception?.cause?.cause?.message
            ]
        ]

        render error500Response as JSON
    }

    def error500Parameters() {
        Map<String, String> error500Response = [
            error : [
                code: "error.500.invalidParameters",
                message: "Missing or invalid parameters"
            ]
        ]

        render error500Response as JSON
    }

    def error500NotFound() {
        Map<String, String> error500Response = [
            error : [
                code: "error.404.element.notFound",
                message: "A required object doesn't exist"
            ]
        ]
        response.status = 404

        render error500Response as JSON
    }
}
