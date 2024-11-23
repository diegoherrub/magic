package pol.rubiano.magic.app.data

import android.widget.ImageView
import coil.load

fun ImageView.loadUrl(url: String) {
    this.load(url)
}