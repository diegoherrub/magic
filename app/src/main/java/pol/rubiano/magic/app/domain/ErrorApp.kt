package pol.rubiano.magic.app.domain

import org.koin.core.annotation.Single

@Single
sealed class ErrorApp : Throwable(){
    data object InternetErrorApp : ErrorApp() {
        private fun readResolve(): Any = InternetErrorApp
    }

    data object ServerErrorApp: ErrorApp() {
        private fun readResolve(): Any = ServerErrorApp
    }

    data object DataErrorApp: ErrorApp() {
        private fun readResolve(): Any = DataErrorApp
    }

    data object UnknowErrorApp: ErrorApp() {
        private fun readResolve(): Any = UnknowErrorApp
    }

    // TODO - create a new error in requestExt.kt ¿?
    data object FailedGetRandomCard: ErrorApp() {
        private fun readResolve(): Any = FailedGetRandomCard
    }
}