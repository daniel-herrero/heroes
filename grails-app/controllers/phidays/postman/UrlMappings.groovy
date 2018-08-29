package phidays.postman

class UrlMappings {

    static mappings = {
//        "/$controller/$action?/$id?(.$format)?"{
//            constraints {
//                // apply constraints here
//            }
//        }

        "/abilities"(controller: 'ability', action: [GET: 'listAbilities'])
        "/abilities/create"(controller: 'ability', action: [POST: 'createAbility'])
        "/characters"(controller: 'character', action: [GET: 'listCharacters'])
        "/characters/create"(controller: 'character', action: [POST: 'createCharacter'])


        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
