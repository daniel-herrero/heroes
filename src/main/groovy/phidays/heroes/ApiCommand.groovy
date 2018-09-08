package phidays.heroes

import grails.validation.Validateable
import grails.validation.ValidationException

trait ApiCommand extends Validateable {

    boolean validate() {
        boolean isValid = validate([:])

        if (hasErrors()) {
            throw new ValidationException("", this.errors)
        }

        return isValid
    }
}