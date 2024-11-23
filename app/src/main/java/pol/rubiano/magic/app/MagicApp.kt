package pol.rubiano.magic.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import pol.rubiano.magic.app.di.AppModule
import pol.rubiano.magic.app.di.LocalModule
import pol.rubiano.magic.app.di.RemoteModule
import pol.rubiano.magic.features.domain.random.di.RandomCardModule

class MagicApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MagicApp)
            modules(
                AppModule().module,
                LocalModule().module,
                RemoteModule().module,
                RandomCardModule().module
            )
        }
    }
}