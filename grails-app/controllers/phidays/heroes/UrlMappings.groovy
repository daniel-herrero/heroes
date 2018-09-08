package phidays.heroes

import grails.validation.ValidationException
import javassist.NotFoundException
import org.springframework.boot.context.config.ResourceNotFoundException

class UrlMappings {

    static mappings = {
//        "/$controller/$action?/$id?(.$format)?"{
//            constraints {
//                // apply constraints here
//            }
//        }

        "/abilities"(controller: 'ability', action: [GET: 'listAbilities', POST: 'createAbility'])
        "/abilities/$abilityId"(controller: 'ability', action: [PUT: 'updateAbility'])
        "/characters"(controller: 'character', action: [GET: 'listCharacters', POST: 'createCharacter'])
         "/characters/$characterId"(controller: 'character', action: [PUT: 'updateCharacter', DELETE: 'deleteCharacter'])

        "404" (controller: "error", action: "error404")
        "500" (controller: "error", action: "error500Parameters", exception: IllegalArgumentException)
        "500" (controller: "error", action: "error500Parameters", exception: ValidationException)
        "500" (controller: "error", action: "error500NotFound", exception: NotFoundException)
        "500" (controller: "error", action: "error500")
    }
}
